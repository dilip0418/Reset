package Array.Hard;

import java.util.Arrays;

public class TrappingRainwater {
    public static void main(String[] args) {
        int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        // System.out.println("Height array: " + java.util.Arrays.toString(height));
        System.out.println("Maximum amount of water that can be trapped is: " + trap(height));
        System.out.println("Maximum amount of water that can be trapped is: " + trapUsingTwoPointers(height));
    }

    /**
     * Brute force approach : TC = O(n^2), SC = O(1).
     * O(n) for finding maximum(n-1 to i) & minimum(0, i)th bar of and then again
     * O(n) to calculate the amount of rainwater on left and right
     */
    private static int trap(int[] height) {
        int maxLeft = 0;
        int maxRight = 0;
        int waterTrapped = 0;
        long start = System.currentTimeMillis();
        for (int i = 1; i < height.length; i++) {
            maxLeft = Arrays.stream(height, 0, i + 1).max().getAsInt();
            maxRight = Arrays.stream(height, i, height.length).max().getAsInt();
            waterTrapped += Math.min(maxLeft, maxRight) - height[i];
        }
        long end = System.currentTimeMillis();
        System.out.println("brute force: " + (end - start) + "ms");
        return waterTrapped;
    }

    /*
     * Optimal solution using stack : TC = O(n), SC=O(1).
     * Using two pointers approach
     * check whether the height at left pointer is smaller than equals to right
     * if yes , move the left pointer else move the right pointer
     * before moving check whether the current height is greater than the previous
     * maximumHeight. And update the maxLeft &
     * maxRight pointers accordingly.
     * 
     */
    private static int trapUsingTwoPointers(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int res = 0;
        int maxLeft = 0, maxRight = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (maxLeft < height[left])
                    maxLeft = height[left];
                else
                    res += maxLeft - height[left];
                left++;
            } else {
                if (maxRight < height[right]) {
                    maxRight = height[right];
                } else {
                    res += maxRight - height[right];
                }
                right--;
            }
        }
        return res;
    }
}
