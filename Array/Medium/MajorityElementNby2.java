package Array.Medium;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementNby2 {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3 };
        // int[] nums = new int[] { 3, 1, 3, 3, 2 };

        // System.out.println(
        // "Major element in the array whose count is greater than n/2: " +
        // majorityElementNby2Brute(nums));
        // System.out.println(
        // "Major element in the array whose count is greater than n/2: " +
        // majorityElementNby2Better(nums));
        System.out.println(
                "Major element in the array whose count is greater than n/2: " + majorityElementNby2Optimal(nums));
    }

    // Time complexity: O(n^2)
    // Space Complexity: O(1)
    private static int majorityElementNby2Brute(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count > n / 2) {
                return nums[i];
            }
        }
        return -1;
    }

    /*
     * Using map to store the frequency of each number in the given array
     * Time Complexity: O(n) (or)
     * TIme Complexity: O(n^2) if the read operation of item from hashmap may take
     * O(n)
     * Space Complexity: O(n) // hashmap
     */
    private static int majorityElementNby2Better(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int n = nums.length;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.get(i) > n / 2) {
                return i;
            }
        }
        return -1;
    }

    // Using the Moore's Voting Algorithm
    private static int majorityElementNby2Optimal(int[] nums) {
        int elem = nums[0], count = 0;
        for (int i : nums) {
            if (count == 0)
                elem = i;

            if (elem == i)
                count++;
            else
                count--;
        }
        count = 0;
        for (int i : nums) {
            if (elem == i) {
                count++;
            }
        }
        return count > nums.length / 2 ? elem : -1;
    }
}
