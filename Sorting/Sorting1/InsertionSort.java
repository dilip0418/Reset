package Sorting.Sorting1;

public class InsertionSort {

    public static void insertionSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                arr[j] ^= arr[j - 1];
                arr[j - 1] ^= arr[j];
                arr[j] ^= arr[j - 1];
                j--;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 1, 6 };
        insertionSort(arr, arr.length);
    }
}

/*
 * Time complexiety of insertion sort is O(n^2) for worst & average cases and
 * for best case it's O(n) as the inner loop dooesn't execute at all.
 * 
 * One line answer:
 * Pick the element one at a time and place it in the right
 * place. {basically segregates the given set of items into sorted block and
 * unsorted block}
 */