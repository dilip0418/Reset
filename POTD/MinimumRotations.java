package POTD;

public class MinimumRotations {
    public static void main(String[] args) {
        String s = "ninja";
        // String s = "ccccc";
        // System.out.println(
        // "Minimum number of rotations required to find the string again is: " +
        // minimumRotations(s.length(), s));
        System.out.println(
                "Minimum number of rotations required to find the string again is: "
                        + minimumRotationsOptimal(s.length(), s));
    }

    private static String rotate(String s, int n) {
        char[] t = s.toCharArray();
        char temp = t[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            t[i + 1] = t[i];
        }
        t[0] = temp;
        return new String(t);
    }

    /*
     * public static int minimumRotations(int n, String s) {
     * String s1 = s;
     * for (int i = 0; i < n; i++) {
     * s1 = rotate(s1, n);
     * System.out.println(s1);
     * if (s1.equals(s)) {
     * return i + 1;
     * }
     * }
     * return -1;
     * }
     */

    /*
     * private static int minimumRotations(int n, String s) {
     * // minimum rotations required to get the same string again
     * String concat = s + s;
     * for (int i = 1; i < n; i++) {
     * String temp = concat.substring(i,n);
     * if(temp.equals(s)){
     * return i;
     * }
     * }
     * return n;
     * }
     */
    private static int minimumRotations(int n, String s) {
        // minimum rotations required to get the same string again
        String original = s;
        for (int i = 1; i <= n; i++) {
            s = s.substring(1) + s.charAt(0);
            if (s.equals(original))
                return i;
        }
        return n;
    }

    /*
     * Certainly! We can optimize the solution by realizing that for a given string,
     * if we rotate it by i positions (where i is less than the length of the
     * string), we'll get the same string if i is a divisor of the string's length.
     * 
     * So, we can iterate from 1 to the length of the string and check if the
     * current index i is a divisor of the length of the string. If it is, we can
     * check if rotating the string by i positions results in the original string.
     * If so, we return i as the minimum number of rotations.
     */

    public static int minimumRotationsOptimal(int n, String str) {
        // Iterate from 1 to n (inclusive)
        for (int i = 1; i <= n; i++) {
            // Check if i is a divisor of n
            if (n % i == 0) {
                System.out.println(i);
                // Construct the rotated string by rotating str by i positions
                String rotated = str.substring(i) + str.substring(0, i);
                // Check if the rotated string matches the original string
                if (rotated.equals(str)) {
                    // If it matches, return i as the minimum number of rotations
                    return i;
                }
            }
        }

        // If the original string cannot be obtained after all rotations, return -1
        return -1;
    }
}
