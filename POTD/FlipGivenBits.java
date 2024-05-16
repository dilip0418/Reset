package POTD;

/* 
Problem Statement:
Problem statement
You have been given an integer 'NUM' (32 bits) and an array of size 'N'.
Your task is to flip all the bits of 'NUM' at position 'ARR[i]' where 0<= i <= N-1.
Constraints:
1 <= 'T' <= 10
1 <= 'NUM' <= 10^9
1 <= 'N' <= 10^5
1 <= 'ARR[i]' <= 31

Time Limit: 1 sec
Sample Input 1:
2
21
3
4 2 1
40
1
4
Sample Output 1:
30
32
Explanation for Sample Input 1:
Before flipping
21 => 10101
After flipping the 4th, 2nd and 1st bit from the end we get 
30 => 11110

Before flipping
40 => 101000
After flipping the 4th bit from the end we get 
32 => 100000
Sample Input 2:
1
5
3
6 2 5
Sample Output 2:
55
 */
public class FlipGivenBits {

    public static int flipSomeBits(int num, int[] arr, int n) {
        // Write your code here.
        for (int i = 0; i < n; i++) {
            System.out.println(num + " before flipping " + arr[i] + "th bit.");
            num = (num ^ (1 << (arr[i] - 1)));
            System.out.println(num + " after flipping " + arr[i] + "th bit.");
            System.out.println();
        }
        return num;
    }

    public static void main(String[] args) {
        int num = 21;
        int n = 3;
        int[] arr = { 4, 2, 1 };
        System.out.println(flipSomeBits(num, arr, n));
    }
}