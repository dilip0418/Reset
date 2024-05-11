package BasicRecursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciNumbers {

    public static int fib(int n) {
        var dp = new int[n + 2];
        dp[n + 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1] + dp[i + 2];
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        return dp[0];
    }

    public static List<Integer> fibIterativeList(int n) {
        List<Integer> result = new ArrayList<>();
        if (n == 0) {
            result.add(0);
        }
        if (n == 1) {
            result.add(1);
        }
        if (n > 1) {
            result.add(0);
            result.add(1);
            for (int i = 2; i <= n; i++) {
                result.add(result.get(i - 1) + result.get(i - 2));
            }
        }
        return result;
    }

    public static int[] fibIterative(int n) {
        int[] result = new int[n];
        if (n == 1) {
            result[0] = 0;
        }
        if (n == 2) {
            result[1] = 1;
        }
        if (n > 1) {
            result[0] = 0;
            result[1] = 1;
            for (int i = 2; i < n; i++) {
                result[i] = result[i - 1] + result[i - 2];
            }
        }
        return result;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        var n = sc.nextInt();

        System.out.println(fibIterativeList(n));

        var result = fibIterative(n);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}