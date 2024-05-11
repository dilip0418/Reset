package POTD;

import java.util.HashSet;
import java.util.Set;

public class MaxXor {
    public static int max_xor(int[] arr) {
        int max_xor = 0;
        int mask = 0;

        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i); // Set the i-th bit in mask

            Set<Integer> prefixes = new HashSet<>();

            for (int num : arr) {
                prefixes.add(num & mask); // Add the prefix of each number
            }

            int candidate_xor = max_xor | (1 << i); // Potential maximum XOR with i-th bit set

            for (int prefix : prefixes) {
                if (prefixes.contains(candidate_xor ^ prefix)) {
                    max_xor = candidate_xor;
                    break;
                }
            }
        }
        return max_xor;
    }

    public static void main(String[] args) {
        int[] arr1 = { 2, 1, 4 };
        System.out.println(max_xor(arr1)); // Output: 6

        int[] arr2 = { 3, 2 };
        System.out.println(max_xor(arr2)); // Output: 1

        int[] arr3 = { 3 };
        System.out.println(max_xor(arr3)); // Output: 0
    }
}
