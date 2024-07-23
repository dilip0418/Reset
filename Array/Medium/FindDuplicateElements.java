package Array.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindDuplicateElements {
    public static void main(String[] args) {
        // int a[] = { 0, 3, 1, 2 };
        int a[] = { 1, 0, 3, 1, 2, 2 };
        System.out.println(findDuplicateElementsBruteForce(a));
        System.out.println(findDuplicateElementsOptimal(a));
    }

    /*
     * Using map to store the frequency of each item and return the list of elements
     * whose frequency > 1
     * 
     * Time Complexity: O(n) + O(n);
     * Space Complexity: (2n) ---> Map
     */
    private static ArrayList<Integer> findDuplicateElementsBruteForce(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();

        for (var i : a) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> element : map.entrySet()) {
            var val = element.getValue();
            if (val > 1)
                list.add(element.getKey());
        }

        if (list.isEmpty()) {
            list.add(-1);
            return list;
        } else {
            return list;
        }
    }

    private static ArrayList<Integer> findDuplicateElementsOptimal(int[] a) {
        int visited[] = new int[a.length];
        Arrays.fill(visited, -1);

        int pos = 0;

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (visited[a[i]] == -1) {
                visited[a[i]] = -10;
            } else if (visited[a[i]] == -10) {
                visited[a[i]] = a[i];
            }
        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] > -1) {
                a[pos++] = i;
            }
        }

        if (pos == 0) {
            list.add(-1);
            return list;
        }
        for (int i = 0; i < pos; i++) {
            list.add(a[i]);
        }
        return list;
    }
}
