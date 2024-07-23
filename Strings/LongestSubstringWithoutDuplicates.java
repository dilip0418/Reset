package Strings;

import java.util.Arrays;

public class LongestSubstringWithoutDuplicates {
    public static void main(String[] args) {
        String s = "abcaabcdba";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /*
     * Time complexity: O(n) --> since the algo depends on the variable r which
     * moves from index 0 to n-1.
     * Space complexity: O(255)
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0, r = 0;
        int maxLen = 0;
        int[] map = new int[255];
        Arrays.fill(map, -1);

        while (r < n) {
            char c = s.charAt(r);

            // If a character is already seen/considered
            if (map[c] != -1) {
                if (map[c] >= l) { // this will help avoid indexOutOfBoundsException
                    l = map[c] + 1; // update the left to the next index where the current current char was seen
                                    // last time
                }
            }
            map[c] = r; // update the last seen index of the current char
            /*
             * Update the maxLen
             */
            int len = r - l + 1;
            maxLen = Math.max(maxLen, len);
            // Move the right pointer
            r++;

        }
        return maxLen;
    }
}
