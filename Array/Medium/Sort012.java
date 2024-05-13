package Array.Medium;

import java.util.Arrays;

public class Sort012 {
    public static void main(String[] args) {
        int[] nums = new int[] { 0, 2, 1, 2, 0 };
        // sort012Brute(nums);

        // sort012Better(nums);

        sort012UsingDNF(nums);
        System.out.println("Sorted Os 1s & 2s: " + Arrays.toString(nums));
    }

    // Time complexity : O(nlogn)
    // Space Complexity : O(1)
    private static void sort012Brute(int[] nums) {
        Arrays.sort(nums);
    }

    // Time Complexity : O(n) + O(n)
    // Space Complexity : O(1)
    private static void sort012Better(int[] nums) {
        /*
         * count the number of 0s, 1s & 2s and then replace them accordingly in the
         * given array
         */

        int zeroes = 0, ones = 0, twos = 0;
        for (int i = 0; i < nums.length; i++) { // ---> O(n)
            if (nums[i] == 0) {
                zeroes++;
            } else if (nums[i] == 1) {
                ones++;
            } else {
                twos++;
            }
        }

        // Below while loops will contribute ---> O(n)
        int i = 0;
        while (i < zeroes) {
            nums[i++] = 0;
        }
        while (i < zeroes + ones) {
            nums[i++] = 1;
        }
        while (i < zeroes + ones + twos) {
            nums[i++] = 2;
        }
    }

    // Using the famous Dutch National Flag (DNF) algorithm
    /*
     * Algorithm:
     * If we observe carefully we can draw some points as we have three numbers 0, 1
     * & 2
     * Therefore we can divide the array into 3 partitions
     * partition I : (0 to left - 1) ---> having only 0s
     * partition II : (left to mid - 1) ---> having only 1s
     * partition III : (right to n-1) ---> having only 2s
     * 
     * And the DNF algorithm says that the middle part of the array has items in the
     * unsorted fashion.
     * Therefore,
     * condtion 1:
     * if a[mid] == 0: // as zeros should be in the left section swap
     * swap(a[left], a[mid])
     * left++, mid++
     * 
     * condition 2:
     * if a[mid] == 1: // as ones should be in the middle section do nothing
     * mid++; // do nothing
     * 
     * condition 3:
     * if a[mid] == 2: // as two should be in the right section swap
     * swap(a[mid], a[right])
     * right--
     */
    // Time Complexity : O(n)
    // Space Complexity : O(1)
    private static void sort012UsingDNF(int[] a) {
        int left = 0, mid = 0;
        int right = a.length - 1;

        while (mid <= right) {
            if (a[mid] == 0) {
                swap(a, left, mid);
                left++;
                mid++;
            } else if (a[mid] == 1) {
                mid++;
            } else {
                swap(a, mid, right);
                right--;
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
