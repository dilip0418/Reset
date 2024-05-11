package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MissingNumbers {

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < brr.size(); i++) {
            // System.out.println(brr.get(i));
            if (Collections.frequency(brr, brr.get(i)) != Collections.frequency(arr, brr.get(i))
                    && !ans.contains(brr.get(i))) {
                ans.add(brr.get(i));
            }
        }
        return ans.stream().sorted().toList();
    }

    private static List<Integer> missingNumbersOpt(List<Integer> arr, List<Integer> brr) {

        Map<Integer, Integer> frequency = new HashMap<>();

        for (Integer integer : arr) {
            frequency.put(integer, frequency.getOrDefault(integer, 0) + 1);
        }
        for (Integer integer : brr) {
            frequency.put(integer, frequency.getOrDefault(integer, 0) - 1);
        }

        // List to store missing numbers
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            if (freq < 0) {
                ans.add(num);
            }
        }
        System.out.println(frequency);
        return ans.stream().toList();
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(203, 204, 205, 206, 207, 208, 203, 204, 205, 206);
        List<Integer> brr = Arrays.asList(203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204);
        // System.out.println("Missing from first array: " + missingNumbers(arr, brr));
        System.out.println("Missing from first array: " + missingNumbersOpt(arr, brr));
    }
}
