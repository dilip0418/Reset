package Array.Easy;

public class IsSortedLeet {
    public static void main(String[] args) {
        // int[] arr = { 3, 6, 10, 1, 8, 9, 9, 8, 9 };
        int[] arr = { 1, 4, 1, 2, 3, 5 };
        System.out.println(isSortedLeet(arr, arr.length));
    }

    private static boolean isSortedLeet(int[] arr, int length) {

        if (length == 1 || length == 2)
            return true;
        int c = 0;
        for (int i = 0; i < length; i++) {
            // as we have compare the current element with the next one so start from i+1
            // int pos = (i + 1) % length;
            if (arr[i] > arr[(i + 1) % length]) {
                c++;
            }
            if (c > 1)
                return false;
        }
        return true;

    }
}

/*
 * Use the concet of traversing an array in a circular fashion as the question
 * has the word rotation. And as the counter "c" for keeping a count of
 * voilations.
 * GFG link: https://www.geeksforgeeks.org/circular-array/
 * Leet link:
 * https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
 */