package Array.Medium;

import java.util.Arrays;

public class FindPairWithDiffX {
    public static void main(String[] args) {
        int[] arr = { 5, 20, 3, 2, 5, 80 };
        int x = 78;
        System.out.println(findPair(arr, x));
    }

    private static boolean findPair(int[] arr, int x) {
        int i = 0, j = 1;
        Arrays.sort(arr);
        while (j < arr.length) {
            int difference = arr[j] - arr[i];
            if (difference == x) {
                return true;
            } else if (difference > x) {
                i++;
            } else {
                j++;
            }
        }
        return false;
    }
}
