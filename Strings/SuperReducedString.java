package Strings;

public class SuperReducedString {
    public static void main(String[] args) {
        String s = "aab"; // output = b
        String s1 = "aaabccddd"; // output = abcd
        String s2 = "aa"; // output = empty string

        System.out.println(superReducedString(s));
        System.out.println(superReducedString(s1));
        System.out.println(superReducedString(s2));
    }

    private static String superReducedString(String s) {
        char[] arr = s.toCharArray();
        int end = -1;

        for (int i = 0; i < arr.length; i++) {
            if (end >= 0 && arr[end] == arr[i]) {
                end--;
            } else {
                end++;
                arr[end] = arr[i];
            }
        }

        if (end == -1) {
            return "Empty String";
        } else {
            return new String(arr, 0, end + 1);
        }
    }
}
