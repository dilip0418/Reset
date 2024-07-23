package Recursion;

public class Atoi {
    public static void main(String[] args) {
        String s = " -0.42er";
        // String s = " -I42er";
        // String s = "" + Integer.MIN_VALUE;
        // System.out.println(myAtoi(s));
        System.out.println("Recursive AtoI:" + myAtoiR(s));
    }

    public static int myAtoi(String s) {
        int i = 0, n = s.length(), sign = 1, res = 0;
        s = s.trim();

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')
                && ++i < n)
            sign = s.charAt(i) == '+' ? 1 : -1;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10)
                    && digit > 7)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + digit;
            i++;
        }
        return res * sign;
    }

    /* Write the recursive form for the above function Atoi as AtoiRecursive */
    public static int myAtoiR(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }

        int index = 0;
        boolean isNegative = false;

        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            isNegative = s.charAt(index) == '-';
            index++;
        }

        return recursiveAtoi(s, index, 0, isNegative);
    }

    private static int recursiveAtoi(String s, int index, int result, boolean isNegative) {
        // Base case: end of string or non-digit character
        if (index >= s.length() || !Character.isDigit(s.charAt(index))) {
            return isNegative ? -result : result;
        }

        int digit = s.charAt(index) - '0';

        // Check for overflow before updating the result
        if (result > (Integer.MAX_VALUE - digit) / 10) {
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        // Update result and recurse
        return recursiveAtoi(s, index + 1, result * 10 + digit, isNegative);
    }

}
