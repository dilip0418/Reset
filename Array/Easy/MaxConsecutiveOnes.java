package Array.Easy;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 1, 0, 1, 1, 1 }; // variant 1 : when an array is given
        System.out.println(findMaxConsecutiveOnesVariant1(arr));

        int n[] = new int[] { 5, 13 }; // variant 2 when number is given and asked to find the max number of consective
                                       // one's in the binary format of the number.
        for (int j = 0; j < n.length; j++) {
            System.out.println(n[j] + " " + findMaxConsecutiveOnesVariant2(n[j]));
        }
    }

    /*
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static int findMaxConsecutiveOnesVariant1(int[] nums) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                count = 0;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    // using bit manipulation
    /*
     * Example 1: n = 5 ---> 101 count = 0
     * step 1: n = 101 & (101 << 1) ---> 101 & 010 = 000 (count++) {n = 0}
     * output = 1
     * 
     * Example 2: n = 13 ---> 1101
     * step 1: n = 1101 & (1101 << 1) ---> 1101 & 1010 = 1000 (count++) {n = 8}
     * step 2: n = 1000 & (1000 << 1) ---> 1000 & 0000 = 0000 (count++) {n = 0}
     * output = 2
     */
    /*
     * Time complexity: O(maxConseq1s(binaryString(n))) --> length of the max
     * consecutive 1s binary string of n
     * Space complexity: O(1)
     */
    private static int findMaxConsecutiveOnesVariant2(int n) {
        int count = 0;
        while (n > 0) {
            n = (n & (n << 1));
            count++;
        }
        return count;
    }
}
