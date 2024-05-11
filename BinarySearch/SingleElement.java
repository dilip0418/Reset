package BinarySearch;

public class SingleElement {
    public static void main(String[] args) {
        int arr[] = new int[] { 3, 3, 7, 7, 11, 11, 12 };
        System.out.println("Given array is rotated " + singleElementUsingBSWithXOR(arr));
    }

    private static int singleElementUsingBSWithXOR(int[] nums) {
        int low = 0;
        int high = nums.length - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            /*
             * the XOR operator will check the next element if the current mid element's
             * index is even and the previous element if the current mid element's index is
             * odd
             * example:
             * if mid = 2
             * 2 in binary --> 10
             * and 2 xor 1 --> 10 ^ 01 = 11 (3) next element
             * 
             * if mid = 3
             * 3 in binary --> 11
             * and 2 xor 1 --> 11 ^ 01 = 10 (20) the previoud element
             */
            if (nums[mid] == nums[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return nums[low];
    }
}
