package Array.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[] { 2, 6, 5, 8, 11 };
        int target = 14;
        // int[] nums = new int[] { 0, -1, 2, -3, 1 };
        // int target = -2;
        // int[] nums = new int[] { 1, -2, 1, 0, 5 };
        // int target = 0;

        // System.out
        // .println("The indexes of the two numbers forming the target:"
        // + Arrays.toString(twoSumBruteForce(nums, target)));
        System.out
                .println("The indexes of the two numbers forming the target:"
                        + Arrays.toString(twoSumBruteForce(nums, target))); // Variant 1 where we have to return the
                                                                            // index of the the pairs

        // The optimised version of Variant 1
        System.out.println("The indexes of the two numers forming the target:" + target + " is "
                + Arrays.toString(twoSumOptimalUsingMap(nums, target)));

        // Variant 2 where we have to confirm the existence of a pair forming the sum
        boolean containsPair = twoSumOptimalUsingHashSet(nums, target);
        if (containsPair) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    // Time Complexity : O(n^2)
    // Space Complexity : O(1)
    private static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }

    // Time complexity : O(n)
    // space complexity : O(2n) // hashmap
    private static int[] twoSumOptimalUsingMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];

            if (map.containsKey(remaining)) {
                return new int[] { map.get(remaining), i };
            }
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }

    // Time Complexity : O(n)
    // Space Complexity : O(n) --> for the hashset
    /*
     * (suggested when we have to confirm the existence of the pair)
     */
    private static boolean twoSumOptimalUsingHashSet(int[] nums, int target) {
        // Using an hash table to store the prefix sum
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // evaluate the remaining number required to form the target sum
            int sum = target - nums[i];

            // if the hashset contains the remaining number return true
            if (hashSet.contains(sum)) {
                return true;
            }
            // add the current element for future reference
            hashSet.add(nums[i]);
        }
        return false;
    }

}
