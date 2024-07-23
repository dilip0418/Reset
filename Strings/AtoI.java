package Strings;

class AtoI {
    public static int myAtoi(String s) {
        s = s.trim();

        if (s.isEmpty() || s.charAt(0) == '.')
            return 0;

        int number = 0;
        int i = 0;
        int mulIdentity = 1;

        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            i++;
            mulIdentity = (s.charAt(0) == '-') ? -1 : 1;
        }

        while (i < s.length()) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                break;
            }
            int digit = c - '0';

            /*
             * Check the overflow condition in advance
             * The below code subtracts the maxValue with current digit (which contributes
             * the answer.) and then divides it
             * by 10 to move the digits towards the right by one digit.
             */
            if (number > (Integer.MAX_VALUE - digit) / 10) {
                return (mulIdentity == -1)
                        ? Integer.MIN_VALUE
                        : Integer.MAX_VALUE;
            }

            number = (number * 10) + digit;
            // System.out.println(number);
            i++;
        }
        return number * mulIdentity;
    }

    
    public static int myAtoiRecursive(String s, int n) {
        /*
         * If str is NULL or str contains non-numeric
         * characters then return 0 as the number is not
         * valid
         */
        if (s == "" || !s.matches("^\\d*$")) {
            return 0;
        }
        if (n == 1)
            return s.charAt(0) - '0';

        return (10 * myAtoiRecursive(s, n - 1) + s.charAt(n - 1) - '0');
    }

    public static void main(String[] args) {

        String s = "214748364";
        System.out.println(myAtoi(s));
        System.out.println("Recursive: " + myAtoiRecursive(s, s.length()));

        /*
         * String s1 = "what is you 987";
         * System.out.println(myAtoi(s1));
         * 
         * String s2 = "143 how are you?";
         * System.out.println(myAtoi(s2));
         */
    }
}