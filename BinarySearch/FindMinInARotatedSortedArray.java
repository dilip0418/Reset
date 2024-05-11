package BinarySearch;

public class FindMinInARotatedSortedArray {

    public static int findMin(int[] arr) {
        if (arr.length == 1)
            return arr[0];

        int n = arr.length;
        int low = 0, high = n - 1;
        int min = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            /*
             * Identify the sorted part in the array
             * And update min with the minimum element
             * (nums[low] if left part is sorted, nums[mid] if right part is sorted)
             * in the sorted part and discard the sorted part.
             * move the low pointer to mid + 1 (if left part is sorted).
             * move the high pointer to mid - 1 (if right part is sorted).
             */

            if (arr[low] <= arr[mid]) {
                min = Math.min(min, arr[low]);
                low = mid + 1;
            } else {
                min = Math.min(min, arr[mid]);
                high = mid - 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 35, 43, 45, 1, 2, 9, 12, 13, 19, 20, 26, 28, 29, 32 };
        System.out.println("The minimum element of the given sorted and rotated array is : " + findMin(arr));
    }
}
