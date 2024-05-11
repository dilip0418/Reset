package BinarySearch.BinarySearchOn2D;

import java.util.Arrays;

public class FindRowWithMax1s {
    public static void main(String[] args) {
        int[][] nums = {
                { 0, 0, 1, 1, 1 },
                { 0, 0, 0, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0 }
        };
        System.out.println("The row with the maximum number of 1's is " + Arrays.toString(findRowWithMax1s(nums)));
    }

    private static int[] findRowWithMax1s(int[][] nums) {
        int maxOnes = 0;
        int maxRow = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (nums[i][j] == 1) {
                    if (maxOnes < nums[0].length - j + 1)
                        maxRow = i;
                    maxOnes = nums[0].length - j + 1;
                }
            }
        }
        return new int[]{maxRow, maxOnes};
    }
}
