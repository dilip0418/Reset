package BasicRecursion;

public class PalindromeString {

    /*
     * public static boolean isPalindrome(boolean isPalindrome, String string, int
     * length, int i) {
     * if (string.charAt(i) != string.charAt(length - 1)) {
     * isPalindrome = false;
     * return isPalindrome;
     * } else {
     * if (i > length) {
     * return isPalindrome;
     * }
     * i++;
     * length--;
     * isPalindrome = true;
     * }
     * return isPalindrome(isPalindrome, string, length, i);
     * }
     */
    public static boolean checkPal(boolean isPal, String string, int i, int length) {
        if (string.charAt(i) != string.charAt(length - 1)) {
            isPal = false;
            return isPal;
        } else {
            if (i > length) {
                return isPal;
            }
            i++;
            length--;
            isPal = true;
        }
        return checkPal(isPal, string, i, length);
    }

    public static boolean isPalindrome(String s) {
        String res = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
        int length = res.length();
        if (s.equals(" ") || s.length() == 1) {
            return true;
        } else {
            return checkPal(false, res, 0, length);
        }

    }

    public static void main(String[] args) {
        // String string = "A man, a plan, a canal: Panama";
        String string = "a";
        String res = string.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        System.out.println(res);
        System.out.println(isPalindrome(res));
    }
}
