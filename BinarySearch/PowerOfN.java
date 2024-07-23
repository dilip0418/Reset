package BinarySearch;

public class PowerOfN {

    public static double helper(double x, long n, double ans) {
        while (n > 0) {
            if ((n & 1) == 0)
                ans *= helper(x * x, n / 2, ans);
            else
                ans *= x * helper(x * x, n / 2, ans);
        }
        return ans;
    }

    private static double power(double x, long n) {
        if (n == 1)
            return x;
        if (n == 0)
            return 1;

        return n < 0 ? 1 / helper(x, Math.abs(n), 1.0) : helper(x, Math.abs(n), 1.0);
    }

    public static double myPow(double x, int n) {
        // Check if the power (n) is negative
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double pow = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                pow *= x;
            }
            x *= x;
            n >>>= 1; // shifts the bits by ignoring the sign bit.
        }
        return pow;
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
        // double x = 2;
        // int n = 10;
        double x = 1;
        int n = -2147483648;
        System.out.println("The value of " + x + " to the power of " + n + " is:" + myPow(x, n));
    }
}
