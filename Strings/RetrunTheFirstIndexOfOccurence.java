package Strings;

/* Given two strings needle and haystack, return the index of the 
first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1. 
*/

public class RetrunTheFirstIndexOfOccurence {
    public static void main(String[] args) {
        String str = "Hello";
        String str1 = "ll";
        // String str = "sadbutsad";
        // String str1 = "sad";
        // String str = "a";
        // String str1 = "a";
        // String str = "abc";
        // String str1 = "c";
        System.out.println(strStr(str, str1));
    }

    public static int strStr(String haystack, String needle) {

        if (needle.equals(haystack))
            return 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() <= haystack.length()) {
                String s = haystack.substring(i, needle.length() + i);
                if (needle.equals(s)) {
                    return i;
                }
            }
        }
        return -1;
    }

}
