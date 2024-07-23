package Strings;

/* 
 * Look & Say Sequence
 * Problem statement
You have been given a positive integer N. Your task is to find the Nth term of the Look-And-Say sequence.

The Look-And-Say sequence is a sequence of positive integers. The sequence is as follows:

1, 11, 21, 1211, 111221, 312211, 13112221,...

This sequence is constructed in the following way:

The first number is 1.

This is read as “One 1”. 
Hence, the second number will be 11.

The second number is read as “Two 1s”. 
Hence, the third number will be 21.

The third number is read as “One 2, One 1”. 
Hence, the fourth number will be 1211.

The fourth term is read as “One 1, One 2, Two 1s”.
Hence, the fifth term will be 111221. And so on.

Constraints:
1 <= T <= 100
1 <= N <= 40

Time Limit: 1 sec
Sample Input 1:
3
1
2
3
Sample Output 1:
1
11
21
Explanation for Sample 1:
The first term is 1.
The second term is 11.
The third term is 21.
Sample Input 2:
1
6
Sample Output 2:
312211
 */
public class LookAndSay {
    public static void main(String[] args) {
        int n = 4; // output: 111221
        System.out.println(lookAndSay(n));
    }

    private static String lookAndSay(int n) {

        if (n <= 0)
            return "";

        String result = "1";

        for (int i = 1; i < n; i++) {
            result = getNextTerm(result);
        }

        return result;
    }

    private static String getNextTerm(String term) {
        StringBuilder nextTerm = new StringBuilder();
        int count = 1;
        char currentTerm = term.charAt(0);

        for (int i = 1; i < term.length(); i++) {
            if (term.charAt(i) == currentTerm) {
                count++;
            } else {
                nextTerm.append(count).append(currentTerm);
                currentTerm = term.charAt(i);
                count = 1;
            }
        }
        nextTerm.append(count).append(currentTerm);
        return new String(nextTerm);
    }
}

/*
 * Solution Explanation:
 * link:
 * https://leetcode.com/problems/count-and-say/solutions/5179675/easy-solution-
 * clean-code-x-explanation
 */

/*
 * Same problem with different problem statement:
 * The count-and-say sequence is a sequence of digit strings defined by the
 * recursive formula:
 * 
 * countAndSay(1) = "1"
 * countAndSay(n) is the run-length encoding of countAndSay(n - 1).
 * Run-length encoding (RLE) is a string compression method that works by
 * replacing consecutive identical characters (repeated 2 or more times) with
 * the concatenation of the character and the number marking the count of the
 * characters (length of the run). For example, to compress the string "3322251"
 * we replace "33" with "23", replace "222" with "32", replace "5" with "15" and
 * replace "1" with "11". Thus the compressed string becomes "23321511".
 * 
 * Given a positive integer n, return the nth element of the count-and-say
 * sequence.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 4
 * 
 * Output: "1211"
 * 
 * Explanation:
 * 
 * countAndSay(1) = "1"
 * countAndSay(2) = RLE of "1" = "11"
 * countAndSay(3) = RLE of "11" = "21"
 * countAndSay(4) = RLE of "21" = "1211"
 * Example 2:
 * 
 * Input: n = 1
 * 
 * Output: "1"
 * 
 * Explanation:
 * 
 * This is the base case.
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 30
 */