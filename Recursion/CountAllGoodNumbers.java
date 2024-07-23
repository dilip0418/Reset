/* 
 * A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).

For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.

A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.
 

Example 1:

Input: n = 1
Output: 5
Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".
Example 2:

Input: n = 4
Output: 400
Example 3:

Input: n = 50
Output: 564908303



Question Consolidated: Given a number n(mentions the number of digits in a number or simply length of the string) we have to find how many good numbers can be formed of number (string) with n digits in it.


This falls down as a classical category of math problems (permutations and combinations).

Intution: A good number should have below conditions satisfied:
1. Digits at even index should be even (0, 2, 4, 6, 8).
2. Digits at odd index should be prime (2, 3, 5, 7).

And one more observation: There can only be one digit at any index.
So at even indexes there can be one of the 5 digits (0, 2, 4, 6, 8) therefor 5 possibilities.
At odd indexes there can be one of the 4 digits (2, 3, 5, 7) therefore 4 possibilities. 

therefore the total number of good numbers that can be formed boils down to (n^5 * n^4).
Since this can be a large number to store in int variable. 
We have to MOD the value obtained at each step by MOD = 10^9 + 7 to avoid overflow.
 */

package Recursion;

public class CountAllGoodNumbers {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        long n = 50;
        System.out.println(countGoodNumbers(n));
    }

    public static int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;

        return (int) ((power(5, even) % MOD * power(4, odd) % MOD) % MOD);
    }

    public static long power(long x, long n) {

        // base case
        if (n == 0)
            return 1;

        // exponentially reducing the value of the power (n by 2)
        long ans = power(x, n >> 1);

        // This is the case when n is even
        ans = (ans * ans) % MOD;

        // and if n is odd multiply an extra x to it
        /*
         * example: n = 5 x = 3
         * ans = 3 * (3 ^ (5/2) * 3 ^ (5/2))
         */
        if ((n & 1) == 1)
            ans = (ans * x) % MOD;
        return ans;

        /*
         * if ((n & 1) == 1)
         * return (x * ans * ans) % MOD;
         * else
         * return (ans * ans) % MOD;
         */
    }
}
