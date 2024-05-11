package BinarySearch;

public class SearchInRotatedSortedArray2 {
    public static void main(String[] args) {
        // int arr[] = new int[] { 3, 4, 5, 0, 0, 1, 2 };
        int arr[] = new int[] { 1, 3 };
        int key = 3;
        boolean isPresent = searchInARotatedSortedArrayII(arr, key);
        if (isPresent) {
            System.out.println(key + " is present in the array");
        } else {
            System.out.println(key + " is not present in the array");
        }
    }

    public static boolean searchInARotatedSortedArrayII(int[] nums, int target) {
        if (nums.length == 1 && nums[0] == target)
            return true;
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return true;

            /*
             * The below condition is tackle the situation where the elements
             * at low, mid & high are same: In this situation we reduce the search space
             * on both the side of the array by moving the low and high pointers
             */
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            /*
             * else performing the search operation similar to the fashion that was followed
             * in search in a rotated sorted array 1 (where all the elements were unique).
             */

            /*
             * check the left side is sorted or not to say that the left side of mid is
             * sorted
             * the element at low should either be less or equals to the elment at mid.
             */
            if (nums[low] <= nums[mid]) {
                /*
                 * in order to decide whether to search in right side or left side
                 * check whether the target lies between the low & mid element to conform that
                 * the target is in the left side, hence move the high pointer to mid - 1.
                 */
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            /*
             * here we conclude that the right side is sorted
             */
            else {
                /*
                 * to decide the side to check for the target check whether the
                 * target lies between mid and high, if yes update the low pointer to mid + 1
                 * else high to mid - 1.
                 */
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
