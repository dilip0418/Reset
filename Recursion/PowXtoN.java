package Recursion;

public class PowXtoN {
    public static void main(String[] args) {
        double x = 1;
        int n = -2147483648;

        System.out.println(myPower(x, n));
    }

    public static double myPower(double x, int n) {
        // Check if the power (n) is negative
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return myPowHelper(x, n);
    }

    private static double myPowHelper(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double temp = myPowHelper(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return x * temp * temp;
        }
    }
}
