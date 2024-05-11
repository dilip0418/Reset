package Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FindHighestNLowestFrequesnt {

    public static void findHighestNLowestFrequesntUsingTreeMap(int arr[], int n) {
        // Calcute the system time
        long begin = System.nanoTime();
        Map<Integer, Integer> map = new TreeMap<>();
        // Populate the frequency map
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        System.out.println(map);

        int max = 0, maxKey = 0;
        int min = n, minKey = 0;
        /*
         * As the TreeMap is sorted a normal approach can be used to find the max and
         * min frequent element in the array
         */
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            int key = entry.getKey();
            if (value > max) {
                maxKey = key;
                max = value;
            }
            if (value < min) {
                min = value;
                minKey = key;
            }
        }
        long end = System.nanoTime();
        System.out.println(maxKey + " is the highest frequent lowest number with frequency: " + max);
        System.out.println(minKey + " is the lowest frequent lowest number with frequency: " + min);
        System.out.println("The time taken by the above snippet which uses Treemap:" + (end - begin));
    }

    public static void findHighestNLowestFrequesntUsingHashMap(int[] arr, int n) {
        long begin = System.nanoTime();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int min = n, minKey = Integer.MIN_VALUE;
        int max = n, maxKey = Integer.MAX_VALUE;

        /*
         * As HashMap is an unorder data structure check the elements with same
         * frequency and store the minimum element among them
         */
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value < max) {
                max = value;
                maxKey = key;
            } else if (max == value) {
                maxKey = Math.min(key, maxKey);
            }
            if (value > min) {
                min = value;
                minKey = key;
            } else if (min == value) {
                minKey = Math.min(key, maxKey);
            }
        }
        long end = System.nanoTime();
        System.out.println(maxKey + " is the highest frequent lowest number with frequency: " + max);
        System.out.println(minKey + " is the lowest frequent lowest number with frequency: " + min);
        System.out.println("The time taken by the above snippet which uses HashMap:" + (end - begin));
    }

    public static void main(String[] args) {
        int n;
        int[] arr = { 1, 1, 1, -2, -2, -2, 3, 2, 4 }; // Given array of integers.
        n = arr.length;
        findHighestNLowestFrequesntUsingTreeMap(arr, n);
        findHighestNLowestFrequesntUsingHashMap(arr, n);
    }
}

/*
 * Note:
 * 
 * Using HashMap is recommended as it's unordered therefore the time taken to
 * insert operations is less than the TreeMap as it's ordered. So check for the
 * chance of using HashMap in the problem given.
 */
