package Sorting.Sorting1;

public class BubbleSort {

    public static void bubbleSort(int[] arr, int n) {
        long start = System.nanoTime();
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        long end = System.nanoTime();
        System.out.println("The time taken by the bubble sort brute-force algorithm:" + (end - start) + "ns");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /*
     * We can check whether there's a swapping operation done in the inner loop and
     * set a flag to continue further operations.
     * If the flag is not set then it's means the array is sorted
     */
    public static void bubbleSortOptimized(int[] arr, int n) {
        long start = System.nanoTime();
        for (int i = n - 1; i > 0; i--) {
            boolean isSwapped = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    isSwapped = true;
                }
            }
            if (isSwapped == false) {
                break;
            }
        }
        long end = System.nanoTime();
        System.out.println("The time taken by the optimised bubble sort algorithm:" + (end - start) + "ns");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 13, 4, 1, 3, 6 };
        int[] arr1 = { 2, 1, 3, 5, 4, 6 };
        bubbleSort(arr, arr.length);
        bubbleSortOptimized(arr1, arr1.length);
    }
}

/*
 * 
 * Time Complexiety:
 * O(n^2) In all cases where n is the number of elements in an array.
 * And the optimised Bubble sort time complexiety: O(n).
 * 
 * One line answer: Pick two items adjacent to each other and swap them if they
 * are not in the right place.
 * {At each iteration of i one item from the last position is placed in its
 * correct place.}
 */