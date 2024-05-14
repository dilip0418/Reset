package Array.Medium;

import java.util.Arrays;

public class Kadane {

    public static int[] maxSubarraySum(int[] arr, int n) {
        long maxi = Long.MIN_VALUE; // maximum sum
        long sum = 0;

        int start = 0;
        int ansStart = -1, ansEnd = -1;
        for (int i = 0; i < n; i++) {

            sum += arr[i];

            /*
             * If the current sum is greater than the max sum update
             * max sum with current sum.
             */
            if (sum > maxi) {
                maxi = sum;

                // Keep a track of the start and end pointers of the previous suubarray.
                ansStart = start;
                ansEnd = i;
            }

            // If sum < 0: discard the sum calculated & update the start to i + 1.
            /*
             * Since considering negative sum will lead to minimum sum we reintialise sum to
             * zero and move the start pointer to i+1.
             */
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }

        int[] ans = new int[ansEnd - ansStart + 1];

        // printing the subarray:
        // System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            ans[i - ansStart] = arr[i];
        }
        // System.out.print("]n");

        // To consider the sum of the empty subarray
        // uncomment the following check:

        // if (maxi < 0) maxi = 0;

        return ans;
    }

    public static void main(String args[]) {
        int[] arr = { 1, -1, 2, 4, -3 };
        int n = arr.length;
        int[] ans = maxSubarraySum(arr, n);
        System.out.println(Arrays.toString(ans));
        // System.out.println("The maximum subarray sum is: " + maxSum);

    }
}
