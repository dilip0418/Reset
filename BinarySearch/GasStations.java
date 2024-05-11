package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class GasStations {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4, 5 };
        int n = nums.length, k = 4;
        // System.out.println(
        // "The minimum number of refueling stops required is " +
        // minimumDistanceBtwGasStations(nums, n, k));
        System.out.println(
                "The minimum number of refueling stops required is " + minMaxDistance3(nums,
                        n, k));
        System.out.println(
                "The minimum distance that can be maintained between any two stations is "
                        + minimizeMaximumDistance(nums, k));
    }

    // Time complexity : O(k * n) * O(n)
    private static double minimumDistanceBtwGasStations(int[] nums, int n, int k) {
        if (n == 0 || k <= 0)
            return 0;
        /*
         * to Keep track of the number of gas stations placed between any two
         * consecutive gas stations.
         */
        int[] howManyPlaced = new int[n - 1];

        /* Initially there will be no new gas stations hence initializing with zero */
        Arrays.fill(howManyPlaced, 0);

        /* Finding the section length (or) the distance between any two stations */
        double sectionLength = -1;

        /* As we have to place k new stations looping from station 1 to k */
        for (int i = 1; i <= k; i++) {

            double maxValue = -1;
            int maxValueIndex = -1;

            /*
             * To place a new gas station between any two gas stations
             * 1. Find the maaximum distance between two consective gas stations.
             * 2. And populating the howManyPlaced array with number of stations placed at
             * any section.
             */
            for (int j = 0; j < n - 1; j++) {

                int diff = nums[j + 1] - nums[j];

                // the sectionLength specifies the number of sections between the stations
                /*
                 * The formula for calculating the no. of sections: (diff / sectionLength) + 1
                 */
                sectionLength = diff / ((double) howManyPlaced[j] + 1);

                /* Everytime check for the maximum section value */
                if (maxValue < sectionLength) {
                    maxValue = sectionLength;
                    maxValueIndex = j; // keeping track of the maximumindex to update the howManyPlaced
                }

                // Incremnt the new sations planted on the
                howManyPlaced[maxValueIndex]++;
            }
        }

        /*
         * Finding the maximum sectionLength which represent the minimized maximum
         * distance between any two gasstations.
         */
        double maxAns = -1;
        for (int i = 0; i < n - 1; i++) {
            sectionLength = (nums[i + 1] - nums[i]) / ((double) howManyPlaced[i] + 1);
            maxAns = Math.max(maxAns, sectionLength);
        }
        return maxAns;
    }

    /*
     * Create a class : Pair where the first element is a double type and the second
     * is of integer type.
     */

    public static class Pair {
        double first;
        int second;

        Pair(double first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    // Better approach using priority queue
    public static double minMaxDistance3(int[] nums, int n, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));

        if (n == 0 || k <= 0)
            return 0;
        /*
         * to Keep track of the number of gas stations placed between any two
         * consecutive gas stations.
         */
        int[] howManyPlaced = new int[n - 1];

        /* Initially there will be no new gas stations hence initializing with zero */
        Arrays.fill(howManyPlaced, 0);

        for (int i = 0; i < n - 1; i++) {
            pq.add(new Pair((double) (nums[i + 1] - nums[i]), i));
        }

        for (int gasStn = 1; gasStn <= k; gasStn++) {
            Pair pair = pq.poll();
            int secInd = pair.second;
            howManyPlaced[secInd]++;
            double initDiff = nums[secInd + 1] - nums[secInd];
            double newSecLen = initDiff / (double) (howManyPlaced[secInd] + 1);
            pq.add(new Pair(newSecLen, secInd));
        }
        return pq.poll().first;
    }

    // Optimizing space complexity using binary search
    private static double minimizeMaximumDistance(int[] arr, int k) {
        int n = arr.length;
        double low = 0, high = 0;
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, (double) (arr[i + 1] - arr[i]));
        }
        double diff = 1e-6;
        while (high - low > diff) {
            double mid = low + (high - low) / 2.0;
            int cnt = noOfGasStnsRequired(mid, arr);
            if (cnt > k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }

    private static int noOfGasStnsRequired(double dist, int[] arr) {
        int cnt = 0; // 0 gas stations initially.
        for (int i = 1; i < arr.length; i++) {
            int noInBtw = (int) ((arr[i] - arr[i - 1])/dist);
            if ((arr[i] - arr[i - 1]) / dist == noInBtw * dist) {
                noInBtw--;
            }
            cnt += noInBtw;
        }
        return cnt;
    }
}
