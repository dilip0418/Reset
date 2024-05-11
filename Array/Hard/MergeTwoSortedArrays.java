package Array.Hard;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    // Time Complexity: O(min(n,m))) + O(nlogn) + O(mlogm)
    // Space complexiet: O(1)
    public static void mergeTwoSortedArraysWithoutExtraSpace(long[] a, long[] b) {
        int left = a.length - 1;
        int right = 0;
        while (left >= 0 && right < b.length) {
            if (a[left] > b[right]) {
                long temp = a[left];
                a[left] = b[right];
                b[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }

    public static void swapIfgreater(long[] nums1, long[] nums2, int m, int n) {
        if (nums1[m] > nums2[n]) {
            long temp = nums1[m];
            nums1[m] = nums2[n];
            nums2[n] = temp;
        }
    }

    public static void mergeTwoSortedArraysWithoutExtraSpaceWithGapTechnique(long[] nums1, int m, long[] nums2, int n) {
        int length = (n + m);
        int gap = (length / 2) + (length % 2);
        while (gap > 0) {
            int left = 0;
            int right = left + gap;
            while (right < length) {
                if (left < m && right >= m) {
                    swapIfgreater(nums1, nums2, left, right - m);
                } else if (left >= m) {
                    swapIfgreater(nums2, nums2, left - m, right - m);
                } else {
                    swapIfgreater(nums1, nums1, left, right);
                }
                left++;
                right++;
            }
            if (gap == 1)
                break;
            gap = (gap / 2) + (gap % 2);
        }
    }

    public static void main(String[] args) {
        long arr1[] = new long[] { 1, 3, 5, 7 };
        long arr2[] = new long[] { 2, 4, 6, 8 };
        mergeTwoSortedArraysWithoutExtraSpaceWithGapTechnique(arr1, arr1.length, arr2, arr2.length);
        System.out.println("Given two sorted arrays");
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
