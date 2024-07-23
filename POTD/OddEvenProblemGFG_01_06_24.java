package POTD;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
 * Given a string s of lowercase English characters, determine whether the summation of x and y is EVEN or ODD.
where:

x is the count of distinct characters that occupy even positions in the English alphabet and have even frequency. 
y is the count of distinct characters that occupy odd positions in the English alphabet and have odd frequency.
Ex: string = "ab" here 'a' has an odd(1) position in the English alphabet & has an odd(1) frequency in the string so a is odd but b has an even(2) position in the English alphabet & has odd(1) frequency so it doesn't count(since string doesn't have 2 b's) so the final answer x + y = 1+0 = 1(odd) would be "ODD".

Note: Return "EVEN" if the sum of x & y is even otherwise return "ODD".

Example 1:

Input: 
s = "abbbcc"
Output: 
ODD
Explanation: 
x = 0 and y = 1 so (x + y) is ODD. 'a' occupies 1st place(odd) in english alphabets and its frequency is odd(1), 'b' occupies 2nd place(even) but its frequency is odd(3) so it doesn't get counted and 'c' occupies 3rd place(odd) but its frequency is even(2) so it also doesn't get counted.
Example 2:

Input: 
s = "nobitaa"
Output: 
EVEN
Explanation: 
Here n, b, t & a would not count since doesn't match with the even condition but o & i will be counted as it satisfies the odd conditions so x = 0 and y = 2 so (x + y) is EVEN.
Your Task:  
You don't need to read input or print anything. Complete the function evenOdd() which takes s as input parameter and returns "EVEN"  if x + y is even, and returns "ODD" otherwise.

Expected Time Complexity: O(|s|)
Expected Auxiliary Space: O(1) 
 */
public class OddEvenProblemGFG_01_06_24 {
    public static void main(String[] args) {
        String s = "abbbcc";
        // String s = "nobitaa";
        // String s = "dgamrakmk";
        // String s = "bddvpw"; // even

        char alphabet[] = {
                'a', 'b', 'c', 'd', 'e', 'f',
                'g', 'h', 'i', 'j', 'k', 'l',
                'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

        System.out.println(Arrays.toString(alphabet));
        System.out.println(oddEven(s));
    }

    private static String oddEven(String s) {
        /*
         * int[] alphabet = new int[26];
         * 
         * for (int i = 0; i < s.length(); i++) {
         * int ch = s.charAt(i) - 'a' + 1;
         * boolean oddCase = ((i + 1) & 1) == 1 && (ch & 1) == 1;
         * boolean evenCase = ((i + 1) & 1) == 0 && (ch & 1) == 0;
         * if (oddCase || evenCase)
         * alphabet[ch]++;
         * }
         * 
         * int x = 0, y = 0;
         * 
         * for (int i = 1; i <= 26; i++) {
         * if (alphabet[i] % 2 == 1) {
         * x += alphabet[i];
         * } else {
         * y += alphabet[i];
         * }
         * }
         */
        // int x = 0, y = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            int ch = c - 'a' + 1;
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if ((e.getKey() + e.getValue()) % 2 == 0) {
                res++;
            }
        }

        // System.out.println(Arrays.toString(alphabet));
        return (res & 1) == 1 ? "ODD" : "EVEN";
    }
}
