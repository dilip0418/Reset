package POTD;

import java.util.*;

public class IntervalIntersection {
    public static ArrayList<ArrayList<Integer>> intervalIntersection(int[][] interval1, int[][] interval2) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < interval1.length && j < interval2.length) {
            int start1 = interval1[i][0];
            int end1 = interval1[i][1];
            int start2 = interval2[j][0];
            int end2 = interval2[j][1];

            // Check if intervals intersect
            if (start1 <= end2 && start2 <= end1) {
                // Calculate the intersection
                ArrayList<Integer> intersection = new ArrayList<>();
                intersection.add(Math.max(start1, start2));
                intersection.add(Math.min(end1, end2));
                result.add(intersection);
            }

            // Move the pointer that has the smaller endpoint
            if (end1 < end2) {
                i++;
            } else {
                j++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Dummy data
        int T = 2;

        // Test case 1
        int N1_1 = 2;
        int N2_1 = 3;
        int[][] INTERVAL1_1 = { { 2, 8 }, { 12, 16 } };
        int[][] INTERVAL2_1 = { { 5, 9 }, { 10, 12 }, { 14, 15 } };

        // Test case 2
        int N1_2 = 3;
        int N2_2 = 0;
        int[][] INTERVAL1_2 = { { 1, 2 }, { 4, 6 }, { 8, 12 } };
        int[][] INTERVAL2_2 = {};

        // List to store the results of each test case
        List<ArrayList<ArrayList<Integer>>> results = new ArrayList<>();

        // Process each test case
        for (int t = 0; t < T; t++) {
            int[][] INTERVAL1, INTERVAL2;
            if (t == 0) {
                INTERVAL1 = INTERVAL1_1;
                INTERVAL2 = INTERVAL2_1;
            } else {
                INTERVAL1 = INTERVAL1_2;
                INTERVAL2 = INTERVAL2_2;
            }

            ArrayList<ArrayList<Integer>> intersections = intervalIntersection(INTERVAL1, INTERVAL2);
            results.add(intersections);
        }

        // Output the results
        for (ArrayList<ArrayList<Integer>> result : results) {
            for (ArrayList<Integer> interval : result) {
                System.out.print(interval.get(0) + " " + interval.get(1) + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
