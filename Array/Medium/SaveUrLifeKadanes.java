package Array.Medium;

import java.util.HashMap;
import java.util.Map;

public class SaveUrLifeKadanes {
    public static void main(String[] args) {
        /*
         * String W = "abcde";
         * int n = 1;
         * char[] X = { 'c' };
         * int[] B = { -1000 };
         */

        String W = "dbfbsdbf";
        int n = 2;
        char X[] = { 'b', 's' };
        int B[] = { -100, 45 };
        System.out.println(maxSum(W, X, B, n));
    }

    /*
     * Using Kadane's algorithm by keeping track of the start and end pointers of
     * the maxSum subString.
     */
    private static String maxSum(String W, char[] X, int[] B, int n) {

        // Rare case if given string is null
        if (W == null)
            return "";

        /*
         * Using string builder to construct the substring efficiently.
         * We can also use String and concatenate, but a new string is created everytime
         * and copy the current to the new string.
         * 
         * Or else we can also use the subString method from String class
         */
        StringBuilder ans = new StringBuilder();

        // Pointers to track the start end end index of the max Sum substring
        int start = 0;
        int ansStart = -1, ansEnd = -1;

        // Sum Variables to track the maxSum
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        /*
         * Store the X[i] --> B[i] for retrieving and finding the maxSum.
         * We can omit using map, however we have to traverse the X[] char array
         * everytime to get he corresponding custom ascii value from B[] this will take
         * additional time complexity of O(n), where n --> length of X.
         */
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(X[i], B[i]);
        }

        // applying kadane's algorithm
        for (int i = 0; i < W.length(); i++) {

            char ch = W.charAt(i);
            // if the ith character in W exists in map take the custome ascii value
            if (map.containsKey(ch)) {
                sum += map.get(ch);
            }
            // else the normal ascii value
            else {
                sum += ch;
            }

            // update the maxSum & ansStart, ansEnd pointers
            if (maxSum < sum) {
                maxSum = sum;
                ansStart = start;
                ansEnd = i;
            }

            /*
             * if sum becomes -ve we will drop the current sum = 0
             * update the start pointer to point to the next element.
             */
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }

        // As we have got the start and end indexes of the maxSum substring
        /*
         * for (int i = ansStart; i <= ansEnd; i++) {
         * ans.append(W.charAt(i));
         * }
         * 
         * return new String(ans);
         */
        return W.substring(ansStart, ansEnd);
    }
}
