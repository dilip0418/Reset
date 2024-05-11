package BasicRecursion;

import java.util.Scanner;

public class PrintNumbers {

    // fill the array from the last index.
    public static int[] fillArray(int n, int[] arr) {
        // if array lenght is 1 then fill the 0th index of the array with 1.
        if (n == 1) {
            arr[0] = 1;
        } else {
            // else fill the (n-1)th index of the array with value n for example 0(n-1)
            // will have 1(n), 1 --> 2, 2 --> 3 and so on.
            arr[n - 1] = n;
            // as we are filling the array from the last index decrease the value of n(index
            // pointer) by one at each recursive call.
            fillArray(n - 1, arr);
        }
        return arr;
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] res = new int[n];
        res = fillArray(n, res);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
