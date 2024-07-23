package Array.Easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinANDMaxSubArraySumWithSizeK {
    public static void main(String[] args) {
        int[] arr = new int[] { 10, 4, 2, 5, 6, 3, 8, 1 };

        // Brute Force: Checing all possible sub arrays of size K
        System.out.println(Arrays.toString(minAndMaxSubArraySumWithSizeKBruteForce(arr, 3)));
        System.out.println(Arrays.toString(minAndMaxSubArraySumWithSizeKBetter(arr, 3)));
    }

    /*
     * Time Complexity: O(n*k)
     * SPace Complexity: O(n)
     */
    private static int[] minAndMaxSubArraySumWithSizeKBruteForce(int[] arr, int k) {
        int[] result = { 0, 0 };

        int minSum = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; (i + k) <= n; i++) {
            int currSum = 0;
            for (int j = i; j < (i + k); j++) {
                currSum += arr[j];
            }
            minSum = Math.min(minSum, currSum);
            maxSum = Math.max(maxSum, currSum);

        }
        result[0] = minSum;
        result[1] = maxSum;

        return result;
    }

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(k)
     */
    private static int[] minAndMaxSubArraySumWithSizeKBetter(int[] arr, int k) {
        int[] result = new int[2];

        int minSum = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;

        int n = arr.length;

        Queue<Integer> queue = new LinkedList<>();

        int sumMin = 0;
        int sumMax = 0;

        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
            sumMin += arr[i];
            sumMax = sumMin;
        }

        for (int i = k; i < n; i++) {
            sumMin -= queue.peek();
            sumMax -= queue.peek();

            queue.poll();

            queue.add(arr[i]);
            sumMax += arr[i];
            sumMin = sumMax;

            minSum = Math.min(minSum, sumMin);
            maxSum = Math.max(maxSum, sumMax);

        }
        result[0] = minSum;
        result[1] = maxSum;

        return result;
    }

    // private static int[] optimal
}
