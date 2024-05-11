package Array.Easy;

public class MoveZeroesToEnd {
    public static void main(String[] args) {
        int[] nums = new int[] { 0, 1, 0, 3, 12 };
        moveZeroes(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length == 1)
            return;
        int j = -1;
        // point j pointer to the first zero in array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j++;
                break;
            }
        }
        /*
         * check if the j is still -1 after loop
         * which means there are no zeros in the array
         */
        if (nums[j] == -1)
            return;

        /*
         * set i pointer to the next of j and start moving pointers and perform swap
         * operation if the element at i pointer is a non zero element
         */
        for (int i = j + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                /*
                 * increment j so that it points to the zero again and repeat the process until
                 * the last item
                 */
                j++;
            }
        }
    }
}
