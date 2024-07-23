package Strings;

public class RotateString {
    public static void main(String[] args) {
        // String s = "abcde";
        // String goal = "bcdea";
        String s = "abcde";
        String goal = "abced";
        // String s = "abcde";
        // String goal = "cdeab";
        System.out.println(rotateString(s, goal));
        System.out.println(rotateStringUsingUtils(s, goal));
    }

    private static boolean rotateString(String s, String goal) {

        if (s.length() < goal.length() || s.length() > goal.length())
            return false;

        if (s.equals(goal))
            return true;

        for (int i = 0; i < s.length(); i++) {
            String temp = rotate(s, i);
            if (goal.equals(temp)) {
                return true;
            }
        }

        return false;
    }

    private static String rotate(String s, int d) {
        char c[] = s.toCharArray();
        int n = c.length;

        reverse(c, 0, d);
        reverse(c, d, n);
        reverse(c, 0, n);

        return new String(c);
    }

    private static void reverse(char[] c, int start, int end) {
        for (int i = start, j = end - 1; i < j; i++, j--) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }
    }

    private static boolean rotateStringUsingUtils(String s, String goal) {
        if (s.length() < goal.length() || s.length() > goal.length())
            return false;
        if (s.equals(goal))
            return true;

        s = s + s;
        if (s.contains(goal))
            return true;
        return false;
    }
}
