package BinarySearch.BS_On_Answers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AllocateBooks {
    public static void main(String[] args) {
        // int[] books = new int[]{25,46,26,49,24};
        // ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24));
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(12, 34, 67, 90));
        // int k = 4;
        int k = 2;
        System.out.println(
                "The maximum number of books with pages which is minimum is: " + findPages(arr, arr.size(), k));
        System.out.println(
                "The maximum number of books with pages which is minimum is: " + findPagesUSingBS(arr, arr.size(), k));
    }

    private static int numOfStudents(ArrayList<Integer> arr, int currentPages) {

        // Initially we have picked one student to whom we will be allocating books.
        int numOfStudents = 1;
        // Initially the student will have zero pages (no books with him).
        int numOfPages = 0;
        int n = arr.size();

        // running a loop for all the books
        for (int i = 0; i < n; i++) {

            /*
             * Check whether the current student can be allocated with pages (books) which
             * is less than the maximum currentPages Limit per student
             * 
             * if yes, then allocate the pages (book) to the current student by incrementing
             * the number of pages (books) he/she is holding.
             * 
             * if no, allocate the current number of pages (at book i) to the next student
             * by increasing the number of students.
             */
            if (numOfPages + arr.get(i) <= currentPages) {
                numOfPages += arr.get(i);
            } else {
                numOfStudents++;
                numOfPages = arr.get(i);
            }
        }
        /*
         * if the number of students that got books with currentPages limit is equal to
         * K (actual number of students), return true.
         */
        return numOfStudents;
    }

    // Brute force Using Linear Search.
    /*
     * Time complexity: O(sum - max + 1)*O(n)
     * Space complexity: O(1)
     */
    private static int findPages(ArrayList<Integer> arr, int n, int k) {
        long start = System.currentTimeMillis();
        /*
         * Return -1 if the number of books are less than the number of students.
         */
        if (n < k)
            return -1;

        /*
         * The minimum number of pages that a student can have is the books with maximum
         * pages.
         * and the maximum number of pages that a student can have is the sum of the
         * pages of all books.
         */
        int low = Collections.max(arr);
        int high = arr.stream()
                .mapToInt(i -> i)
                .sum();

        /*
         * Checking for every possible combination of books (number of pages) in range
         * [low,high] per student.
         */
        for (int j = low; j <= high; j++) {
            if (numOfStudents(arr, j) == k) {
                long end = System.currentTimeMillis();
                System.out.println("Execution time using Linear approach: " + (end - start) + "ms");
                return j;
            }
        }
        /*
         * Return the start (max element), this is a situation where the number of
         * students are equal to the number of books
         */
        long end = System.currentTimeMillis();
        System.out.println("Execution time using Linear approach: " + (end - start) + "ms");
        return low;
    }

    // Optimal solution Using Binary Search
    /*
     * Time complexity: O(log(sum - max + 1)*n)
     * Space complexity: 1
     */
    private static int findPagesUSingBS(ArrayList<Integer> arr, int n, int k) {

        if (n < k)
            return -1;
            
        long start = System.currentTimeMillis();
        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(i -> i).sum();

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (numOfStudents(arr, mid) > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Execution time using Binary search: " + (end - start) + "ms");
        return low;
    }
}







