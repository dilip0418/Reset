package Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FrequencyArray {
    public static int[] countFrequencyUsingTreemap(int n, int x, int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (freqMap.containsKey(nums[i])) {
                freqMap.put(nums[i], freqMap.get(nums[i]) + 1);
            } else if (nums[i] <= n) {
                freqMap.put(nums[i], 1);
            }
        }
        int[] ans = new int[n];

        // Traversing a Map data structure using EntrySet.
        for (Map.Entry<Integer, Integer> item : freqMap.entrySet()) {
            ans[item.getKey() - 1] = item.getValue();
            System.out.println(item.getKey() + "-->" + item.getValue());
        }
        return ans;
    }

    public static int[] countFrequencyUsingArray(int n, int x, int[] nums) {
        // Write your code here.
        int[] FrequencyArray = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n)
                FrequencyArray[nums[i] - 1] += 1;
        }
        return FrequencyArray;
    }

    public static void main(String[] args) {
        // int[] arr = { 11, 14, 8, 3, 12, 14, 1, 7, 4, 3};
        int[] arr = { 10, 7, 9, 8, 14, 20, 6 };

        int[] ans = countFrequencyUsingArray(7, 20, arr);
        int[] ansHMap = countFrequencyUsingTreemap(7, 20, arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < ansHMap.length; i++) {
            System.out.print(ansHMap[i] + " ");
        }

    }
}

/*
 * Note:
 * A hashmap is a unordered map.
 * A TreeMap is an Ordered map.
 */