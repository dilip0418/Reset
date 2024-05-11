package Array.Hard.BS_On_Answers;

import java.util.Arrays;

public class AggresiveCows {
    public static void main(String[] args) {
        int n = 3, k = 4;
        int[] stalls = new int[] { 0, 3, 4, 7, 10, 9 };
        System.out
                .println("The minimum possible maximum distance between any two cows is :" + minDistance(n, k, stalls));
    }

    public static boolean canBePlaced(int[] stalls, int k, int distance) {
        // Initially we will place the first cow at the first stall
        int numberOfCows = 1, lastCow = stalls[0];
        /*
         * As the first cow is already placed in the first stall, no we start checking
         * from stall1 (hence i = 1)
         */
        for (int i = 1; i < stalls.length; i++) {
            /*
             * if the distance btween two stalls is greater than equals to the
             * currentDistance,
             * then it's possible to place a cow at index i
             */
            if (stalls[i] - lastCow >= distance) {
                numberOfCows++; // at one of the cow is place we increment the count of cows placed
                lastCow = stalls[i]; // also update the position of the last cow placed
                if (numberOfCows >= k) // at any point if the number of cows place becomes equal to K return true
                    return true;
            }
        }
        return false; // if the we weren't able to place all k cows in the stalls then return false.
    }

    private static int minDistance(int n, int k, int[] stalls) {

        /*
         * sorting the given array so that we can leverage the binary search algorithm.
         */
        Arrays.sort(stalls);

        /*
         * The answer will lie between the smallest and largest elements in the sorted
         * array.
         * Example: If there are (k=4) cows that are to be placed in the given stalls
         * (stalls[] = {0, 3, 4, 7, 10, 9}),
         * Then we can place the first cow at stall 0 at the second cow at
         * stall 10.
         * Hence , minimum distance should be present in the
         * range [minimum, maximum - minimum] element in the stall.
         */
        int low = stalls[0], high = stalls[n - 1] - low;

        // performing the standard Binary Seach algorithm.
        /*
         * Binary search is used here because, at stall at x distance we consider we
         * will be able to eliminate a part of the solution space
         * That is for the above example where k = 4, stalls = {0, 3, 4, 7, 10, 9}
         * [after sorting stalls = {0, 3, 4, 7, 9, 10}]
         * low = 0 & high = 10,
         * [0,1,2,3,4,5,6,7,8,9,10] is the search space.
         * We start with mid = 5, and we check if we can place all k cows with this
         * distance.
         * If yes then we move low to the right (since we have to find the minimum
         * distance that is maximum possible) by eliminating the left half of the
         * search space.
         * If no then we move high to the left by eliminating the right half of the
         * search space.
         */
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canBePlaced(stalls, k, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        /*
         * Initially the low will be pointing to a stall(at some distance) hence the low
         * will be a possible answer whereas the high will be pointing to a stall(at
         * some distance) where we may not be able to place all k cows.
         * As both the pointers are moving in the opposite direction the polarity
         * changes. That is the low will be pointing to a stall which will no be an
         * annswer and the high will be at a stall which is the answer.
         * Hence return high.
         */
        return high;
    }
}
