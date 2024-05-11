package Sorting.Sorting2;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        // int arr[] = { 4, 6, 2, 5, 7, 9, 1, 3 };
        // int[] arr = { 4, 3, 8, 4, 6, 5 };
        int[] arr = { 4, 1, 3, 9, 7 };
        quicksort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void quicksort(int[] arr, int low, int high) {

        if (low < high) {
            int pIdx = getPartition(arr, low, high);
            quicksort(arr, low, pIdx - 1);
            quicksort(arr, pIdx + 1, high);
        }

    }

    private static int getPartition(int[] arr, int low, int high) {
        // Choosing the first item as pivot
        int pivot = arr[low];
        int i = low, j = high;
        while (i < j) {
            // find the first largest element that's greater then or equal than pivot
            while (arr[i] <= pivot && i <= high - 1)
                i++;
            // find the smallest element that is smaller than pivot
            while (arr[j] > pivot && j >= low + 1)
                j--;
            if (i < j) {
                arr[i] ^= arr[j];
                arr[j] ^= arr[i];
                arr[i] ^= arr[j];
            }
        }
        int temp = arr[j];
        arr[j] = arr[low];
        arr[low] = temp;
        System.out.println(Arrays.toString(arr));
        System.out.println();
        return j;
    }
}
