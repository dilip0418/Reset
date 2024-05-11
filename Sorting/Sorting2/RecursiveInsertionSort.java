package Sorting.Sorting2;

public class RecursiveInsertionSort {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 3, 5, 4 };
        recursiveInsertionSort(arr, arr.length, 0);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void recursiveInsertionSort(int[] arr, int length, int i) {
        /*
         * base case: the element is inserted at its correct position or when the i (the
         * index of current element) becomes equal to the length return.
         */
        if (i == length)
            return;
        int currentValueIndex = i;
        while (currentValueIndex > 0 && arr[currentValueIndex - 1] > arr[currentValueIndex]) {
            // swap elements if they are in wrong order
            arr[currentValueIndex] ^= arr[currentValueIndex - 1];
            arr[currentValueIndex - 1] ^= arr[currentValueIndex];
            arr[currentValueIndex] ^= arr[currentValueIndex - 1];
            currentValueIndex--;
        }
        recursiveInsertionSort(arr, length, currentValueIndex + 1);
    }
}
