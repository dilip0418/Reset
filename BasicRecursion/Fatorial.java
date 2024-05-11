package BasicRecursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fatorial {
    public static void main(String[] args) {
        long n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println(factorialNumbers(n));
    }

    public static List<Long> factorialNumbers(long n) {
        List<Long> factorialNumbers = new ArrayList<>();
        long i = 1, num = factorial(i);

        /*
         * 1. start with factorial(1) and
         * 2. add the factorial(i) to the result list & check whether the factorial of
         * the current value of i is less than of
         * 3. if factorial(i) is less than n increment i by 1 and repeat from step 2
         * again.
         */
        while (num <= n) {
            factorialNumbers.add(num);
            i += 1;
            num = factorial(i);
        }

        return factorialNumbers;
    }

    private static long factorial(long n) {
        if (n == 0 || n == 1)
            return 1;
        return n * factorial(n - 1);

    }
}
