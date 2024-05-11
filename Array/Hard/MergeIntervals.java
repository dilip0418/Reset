package Array.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 1, 1 }, { 3, 5 }, { 2, 4 }, { 6, 7 } };
        /*
         * List<List<Integer>> result = mergeInervalsBrute(intervals);
         * for (List<Integer> list : result) {
         * System.out.println(list);
         * }
         */
        int[][] ans = mergeIntervalsOptimized(intervals);
        for (int[] arr : ans) {
            System.out.println(Arrays.toString(arr));
        }
    }

    /*
     * Time complexiety : O(nlogn) {for sorting the list of pairs} + O(2n) {2n -> as
     * every pair is atmost visited twice}.
     * Space complexity : O(1). and for storing ans recovered
     */
    private static List<List<Integer>> mergeInervalsBrute(int[][] arr) {

        // sorting list of pairs
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int start = arr[i][0];
            int end = arr[i][1];

            /*
             * skip the current interval if it's end [second value] is less than the
             * previous pairs end value.
             */
            if (!res.isEmpty() && end <= res.get(res.size() - 1).get(1)) {
                continue;
            }
            /*
             * else check the next pairs and see if they can be merged with the current
             * interval.
             */
            for (int j = i + 1; j < n; j++) {
                /*
                 * if the next elements start is less than the current element's end then we
                 * have found a valid pair to merge.
                 */
                if (arr[j][0] <= end) {

                    /*
                     * consider the maximum of the end values in the current end [end] and the next
                     * interval's end [arr[j][1]]
                     * example: {2,7} and {3,5}, we will get {2,7} becuase 5 [the next interval's
                     * end] will be covered in the current end i.e 7.
                     */
                    end = Math.max(end, arr[j][1]);
                } else {
                    break;
                }
            }
            res.add(Arrays.asList(start, end));
        }
        return res;
    }

    /*
     * Time complexity : O(nlogn) = O(n).
     * Space complexity: O(1).
     */
    public static int[][] mergeIntervalsOptimized(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            if (result.isEmpty() || intervals[i][0] > result.get(result.size() - 1)[1]) {
                result.add(intervals[i]);
            } else {
                result.set(
                        result.size() - 1,
                        new int[] {
                                Math.min(intervals[i][0], result.get(result.size() - 1)[0]),
                                Math.max(intervals[i][1], result.get(result.size() - 1)[1])
                        });
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
