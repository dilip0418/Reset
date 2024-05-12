package Mathematical;

/* 
Given an infinite number line. You start at 0 and can go either to the left or to the right. The condition is that in the ith move, you must take i steps. Given a destination d, find the minimum number of steps required to reach that destination.

Example 1:

Input: d = 2
Output: 3
Explaination: The steps takn are +1, -2 and +3.
Example 2:

Input: d = 10
Output: 4
Explaination: The steps are +1, +2, +3 and +4.
Your Task:
You do not need to read input or print anything. Your task is to complete the function minSteps() which takes the value d as input parameter and returns the minimum number of steps required to reach the destination d from 0.

Expected Time Complexity: O(d)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ d ≤ 10000
 */

public class MinimumStepsToDistanceD {
    public static void main(String[] args) {
        // int d = 10;
        int d = 2;
        System.out.println("Minimum Steps to reach distance " + d + " is " + minimumStepsToDistanceD(d));
    }

    /*
     * Intuition: We continuously add 'i' steps (where 'i' is the index of the move)
     * until the total distance exceeds or equals 'd' and the difference between the
     * total and 'd' is even. This ensures that we reach the destination with an
     * exact number of steps.
     */
    private static int minimumStepsToDistanceD(int d) {
        if (d <= 0)
            return 0;

        int steps = 0, totalDistanceCovered = 0;

        while (totalDistanceCovered < d || (totalDistanceCovered - d) % 2 != 0) {
            steps += 1;
            totalDistanceCovered += steps;
        }

        return steps;
    }
}
