package Strings;

public class LargestOddNumberInString {
    public static void main(String[] args) {
        // String s = "52";
        // String s = "4206";
        // String s = "2";
        String[] s = { "239537672423884969653287101", "2", "4206", "52" };
        for (String string : s) {
            System.out.println(string);
            System.out.println(largestOddNumberBruteForce(string));
            System.out.println(largestOddNumberOptimal(string));
            System.out.println();
        }
    }

    // moving from left to right
    public static String largestOddNumberBruteForce(String num) {
        long start = System.currentTimeMillis();
        String max = "";
        for (int i = 0; i < num.length(); i++) {
            if (Integer.parseInt(num.charAt(i) + "") % 2 == 1) {
                max = num.substring(0, i + 1);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Time taken:(using left - right approach) " + (end - start) + " ms");
        return max;
    }

    /*
     * moving from right to left (as we have to find the largest odd number from the
     * string so it makes sense to start checking form the end )
     */

    private static String largestOddNumberOptimal(String num) {
        long start = System.currentTimeMillis();
        int i = num.length() - 1;
        for (; i >= 0; i--) {
            if ((num.charAt(i) & 1) == 1) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Time taken:(using right - left approach) " + (end - start) + " ms");
        return num.substring(0, i + 1);
    }

}
