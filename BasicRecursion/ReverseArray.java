package BasicRecursion;

public class ReverseArray {

    public static int[] rev(int i, int n, int[] nums) {
        if (i > n) {
            return nums;
        } else {
            nums[i] ^= nums[n - 1];
            nums[n - 1] ^= nums[i];
            nums[i] ^= nums[n - 1];
            i += 1;
            n -= i;
        }
        return nums;
    }

    public static int[] reverseArray(int n, int[] nums) {
        int[] arr;
        arr = rev(0, n, nums);
        return arr;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] nums = { 1, 2, 3, 4, 5 };
        int[] ans = reverseArray(n, nums);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
