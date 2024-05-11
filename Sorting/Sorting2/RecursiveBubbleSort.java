package Sorting.Sorting2;

public class RecursiveBubbleSort {
    public static void main(String[] args) {
        int arr[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        bubbleSortRecursively(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void bubbleSortRecursively(int[] arr, int n) {
        // Base case: if the array is empty or only has one element left, it's already
        // sorted
        if (arr == null || n == 1)
            return;
        // Perform a pass through the array
        for (int i = 0; i <= n - 2; i++) {
            if (arr[i] > arr[i + 1]) {
                // Swap elements if the current element is greater than the next one
                arr[i] ^= arr[i + 1];
                arr[i + 1] ^= arr[i];
                arr[i] ^= arr[i + 1];
            }
        }
        bubbleSortRecursively(arr, n - 1);
    }
}
