package BinarySearch.BinarySearchOn2D;

import java.util.Arrays;

public class FindMedian {
    public static void main(String[] args) {
        /*
         * [
         * [1, 3, 5],
         * [2, 6, 9],
         * [3, 6, 9]
         * ]
         */

        int[][] arr = { { 1, 3, 5 }, { 2, 6, 9 }, { 3, 6, 9 } };
        System.out.println("The median is " + medianBrute(arr, arr.length, arr[0].length));
        System.out.println("The median is " + median(arr, arr.length, arr[0].length));
    }

    // Time Complexity : O(n*m) + O((n+m)log(n+m))
    private static int medianBrute(int[][] matrix, int R, int C) {
        // flattening the matrix to a 1D array
        int[] flattenedArray = new int[R * C];

        int index = 0;
        // Iterating to all the elements in the matrix --> O(n*m)
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                flattenedArray[index] = matrix[i][j];
                index++;
            }
        }
        // sort the array --> O((n+m)log(n+m))
        Arrays.sort(flattenedArray);

        // The median will now be available at the mid index in the flattened array
        return flattenedArray[(R * C) / 2];
    }

    private static int median(int[][] matrix, int R, int C) {

        // find the search space : by find the min and max elements in the matrix
        int min = matrix[0][0];
        int max = matrix[0][0];

        /*
         * as the given matrix is sorted finding min in 0th col and max in last column
         * (C-1)th
         */
        for (int i = 0; i < C; i++) {
            min = Math.min(matrix[i][0], min);
            max = Math.max(matrix[i][C - 1], max);
        }

        int required = (R * C) / 2;

        while (min <= max) {
            int mid = min + (max - min) / 2;

            /*
             * A median is a number which has equal number of numbers on both the sides
             * therefore finding the number of numbers (<= mid) will let us exploit the
             * binary search algorithm.
             */

            /*
             * this case if the numbers of numbers less than mid are less than or equal to
             * the required number (half --> (R*C)/2) means that the median may be in the
             * right half of the search space, hence move the min (low) pointer.
             */
            if (required >= blackBox(matrix, mid)) {
                min = mid + 1;
            }
            /* else move the max (high) pointer in the vice-versa case */
            else {
                max = mid - 1;
            }
        }
        return min;
    }

    private static int blackBox(int[][] matrix, int x) {

        /*
         * checking the number of number grater than the given number x by using the
         * upper bound concept (where in it finds the index of the number just greater
         * than the given number). Which we can use to count the number of numbers
         * greater than x.
         */

        int count = 0;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            count += upperBound(matrix[i], x);
        }

        return count;
    }


    
    private static int upperBound(int[] arr, int x) {

        int n = arr.length;
        int l = 0, r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid] <= x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
