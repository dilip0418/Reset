package BinarySearch.BinarySearchOn2D;

import java.util.Arrays;

public class FindPeakElement2 {
    public static void main(String[] args) {
        // [[10,20,15],[21,30,14],[7,16,32]]
        int[][] nums = { { 10, 20, 15 }, { 21, 30, 14 }, { 7, 16, 32 } };
        System.out.println(
                "The peak element is at " + Arrays.toString(findPeakElement(nums, nums.length, nums[0].length)));
    }

    private static int[] findPeakElement(int[][] nums, int n, int m) {
        int low = 0, high = m - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int maxRow = 0;

            // find the row-index of the maxElement column-wise
            for (int row = 0; row < m; row++) {
                maxRow = nums[row][mid] >= nums[maxRow][mid] ? row : maxRow;
            }

            // find the left and right elements of the element ar (maxRow, mid)
            int left = (mid >= 0) ? nums[maxRow][mid - 1] : -1;
            int right = (mid < m) ? nums[maxRow][mid + 1] : -1;

            /*
             * check for the condition where the element found is greater than the left and
             * right elements
             */
            if (left < nums[maxRow][mid] && nums[maxRow][mid] > right) {
                return new int[] { maxRow, mid };
            }

            /*
             * if the element found is less than the right element, means the element is in
             * the upstream direction to the peak element therefore the peak element will be
             * towards the right hence move low pointer.
             */
            else if (nums[maxRow][mid] < right) {
                low = mid + 1;
            }
            /*
             * in this case the element found will be less than the left element, means the
             * the element is in the downstream direction from the peak element therefore
             * the peak element will be towards the left hence move the high pointer.
             */
            else {
                high = mid - 1;
            }
        }

        return new int[] { -1, -1 };
    }
}
