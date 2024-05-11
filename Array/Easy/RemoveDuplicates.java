package Array.Easy;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    private static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}

/*
 * Using two pointers one (i) for the current element and other (j) for checking
 * the next unique element.
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */