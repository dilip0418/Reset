package Array.Easy;

import java.util.Arrays;

public class FindSecondLargeNSecondSmall {

    // bruteForce
    public static int[] getSecondOrderElementsBruteForce(int n, int[] a) {
        long start = System.nanoTime();
        Arrays.sort(a);
        int large = a[n - 1];
        int small = a[0];
        int i = 1, j = n - 2;
        while (a[i] == small && i < n) {
            i++;
        }
        while (a[j] == large && j > 0) {
            j--;
        }

        long end = System.nanoTime();
        System.out.println("The time taken by brute force algorithm is " + (end - start) + " ns");
        return new int[] { a[j], a[i] };
    }

    // better version using two pointers technique
    public static int[] getSecondOrderElementsBetter(int n, int[] arr) {
        long start = System.nanoTime();
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max)
                max = num;
        }
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < min)
                min = num;
        }
        int i = 0;

        int smax = -1, smin = Integer.MAX_VALUE;
        while (i < n && arr[i] <= max) {
            if (arr[i] > smax && arr[i] != max)
                smax = arr[i];
            i++;
        }

        i = 0;
        while (i < n && arr[i] >= min) {
            if (arr[i] < smin && arr[i] != min)
                smin = arr[i];
            i++;
        }
        long end = System.nanoTime();
        System.out.println("The time taken by better approach algorithm is " + (end - start) + " ns");
        return new int[] { smax, smin };
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 6, 7, 4 };
        int[] ans = getSecondOrderElementsBruteForce(arr.length, arr);
        System.out.println("The second largest and the second smallest elements are: " + ans[0] + " and " + ans[1]);
        int[] arr1 = { 5, 3, 6, 7, 4 };
        int[] ans1 = getSecondOrderElementsBetter(arr1.length, arr1);
        System.out.println("The second largest and the second smallest elements are: " + ans1[0] + " and " + ans1[1]);
        int[] ans2 = getSecondOrderElementsOptimal(arr1.length, arr1);
        System.out.println("The second largest and the second smallest elements are: " + ans2[0] + " and " + ans2[1]);
    }

    // Optimized version of the above method which traverses the array only once
    private static int[] getSecondOrderElementsOptimal(int length, int[] arr) {
        long start = System.nanoTime();
        int smax = smax(arr, length);
        int smin = smin(arr, length);
        long end = System.nanoTime();
        System.out.println("The time taken by the optimal algorithm is " + (end - start) + " ns.");
        return new int[] { smax, smin };
    }

    private static int smin(int[] arr, int length) {
        int smin = Integer.MAX_VALUE, min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                smin = min;
                min = arr[i];
            } else if (arr[i] < smin && arr[i] > min) {
                smin = arr[i];
            }
        }
        return smin;
    }

    public static int smax(int[] a, int length) {
        int smax = Integer.MIN_VALUE, max = a[0];
        for (int i = 0; i < length; i++) {
            if (a[i] > max) {
                smax = max;
                max = a[i];
            } else if (a[i] > smax && a[i] < max) {
                smax = a[i];
            }
        }
        return smax;
    }
}
