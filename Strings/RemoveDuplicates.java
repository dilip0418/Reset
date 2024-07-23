package Strings;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String s = "baabbsbbahsahbahshhbhsjjjj";
        System.out.println(removeDuplicates(s));
    }

    private static String removeDuplicates(String s) {
        if (s == null || s.length() == 0)
            return s;
        char[] chars = s.toCharArray();
        int i = 0;
        for (int j = 1; j < chars.length; j++) {
            if (chars[i] != chars[j]) {
                chars[++i] = chars[j];
            }
        }
        return new String(chars, 0, i + 1);
    }
}
