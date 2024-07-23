package Recursion;

public class BasicRecursion {
    public static void main(String[] args) {
        int n = 5;
        int i = 1;
        // printName(i, n);
        i = 5;
        // printNto1(i, n);

        // print1ToNUsingBackTracking(n, n);

        // printNto1UsingBackTracking(1, n);
        // System.out.println(sumOfNNumbers(n));
        System.out.println(factorial(n));
    }

    public static void printName(int i, int n) {
        if (i > n) {
            return;
        }
        System.out.println("Hello " + i);
        printName(i + 1, n);
    }

    public static void printNto1(int i, int n) {
        if (i < 1) {
            return;
        }
        System.out.println(i);
        printNto1(i - 1, n);
    }

    public static void print1ToNUsingBackTracking(int i, int n) {
        if (i < 1) {
            return;
        }
        print1ToNUsingBackTracking(i - 1, n);
        System.out.println(i);
    }

    public static void printNto1UsingBackTracking(int i, int n) {
        if (i > n) {
            return;
        }
        printNto1UsingBackTracking(i + 1, n);
        System.out.println(i);
    }

    public static int sumOfNNumbers(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumOfNNumbers(n - 1);
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
