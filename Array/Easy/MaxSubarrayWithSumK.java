package Array.Easy;

import java.util.HashMap;
import java.util.Map;

public class MaxSubarrayWithSumK {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 1, 1, 1 };
        int k = 3;
        // int[] arr = { 1, 2, 1, 3 };
        // int k = 2;
        // System.out.println(longestSubarrayWithSumKBrute(arr, k));
        // System.out.println(longestSubarrayWithSumKBetter1(arr, k));
        // System.out.println(longestSubarrayWithSumKBetter2(arr, k));
        System.out.println(longestSubarrayWithSumKOptimal(arr, k));
    }

    // brute force TC ~ O(n^3) & SC = O(1)
    public static int longestSubarrayWithSumKBrute(int[] A, int K) {
        int longestSubarray = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                int sum = 0;
                for (int j2 = i; j2 <= j; j2++) {
                    sum += A[j2];
                }
                if (sum == K) {
                    longestSubarray = Math.max(longestSubarray, j - i + 1);
                }
            }
        }
        return longestSubarray;
    }

    // better - 1 TC ~ O(n^2) & SC = O(1)
    public static int longestSubarrayWithSumKBetter1(int[] a, int k) {
        int longestSubarray = 0;
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                if (sum == k) {
                    longestSubarray = Math.max(longestSubarray, j - i + 1);
                }
            }
        }
        return longestSubarray;
    }

    // better - 2 using hashmap "optimal for array/list which has 0's, positve no's
    // and negative no's"
    public static int longestSubarrayWithSumKBetter2(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int s = 0;
        for (int i = 0; i < a.length; i++) {
            s += a[i];
            /*
             * if at any time the sum becomes k then we can add length of subarray from
             * index 0 to that element
             */
            if (s == k)
                result = Math.max(result, i + 1);
            /*
             * check whether the map has an item with is (sum - k) if exists, find the
             * evaluate the maximum length of the sub array by subracting the current index
             * value with index value pointed by (sum - k)
             */
            if (map.containsKey(s - k)) {
                result = Math.max(result, i - map.get(s - k));
            }
            // populates the map with the prefixSum of elements until index i
            if (!map.containsKey(s))
                map.put(s, i);
        }
        return result;
    }

    // optimal approach "for arrays/lists with positive no's only"
    // using two pointer approach and sliding the pointers.
    public static int longestSubarrayWithSumKOptimal(int[] arr, int K) {
        int n = arr.length;
        int l = 0;
        int sum = 0;
        int result = 0;
        for (int r = 0; r < n; r++) {
            /*
             * subract the left most element from the subarray and move the left pointer 1
             * step towards right
             */
            while (l <= r && sum > K) {
                sum -= arr[l++];
            }

            /*
             * if at any point sum becomes K then update the maxLength as max of the lenght
             * of the subarray and the previous one.
             */
            if (sum == K) {
                result = Math.max(result, r - l);
            }

            // this is to populate the sum variable
            if (r < n)
                sum += arr[r];
        }
        return result;
    }
}
