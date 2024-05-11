package BinarySearch;

public class PeakElement {
    public static void main(String[] args) {
        int[] nums = new int[] { 85, 21686, 47033, 26146, 38370, 87465, 71859, 24577, 5407, 27270, 22334, 80105, 23772,
                43237, 74748, 75684, 90342, 15115, 13161, 12574, 54143, 504, 73277, 46076, 51157, 10700, 32558, 60599,
                42480, 4598, 78163, 83060, 75621, 13851, 41187, 57249, 74312, 28480, 96283, 79694, 82078, 54868, 65534,
                30981, 82800, 35260, 96151, 69447, 74108, 98012, 50266, 84709, 25957, 55519, 75336, 65272, 13194, 36516,
                27249, 39389, 45876, 37861, 62292, 17104, 1193, 99172, 57570, 71300, 59870, 7253, 27713, 17917, 32714,
                12418, 34412, 87658, 33301, 26431, 64984, 63682, 96911, 78859, 46641, 23258, 25693, 18175 };
        System.out.println("Peak element in the given array is at: " + findPeak(nums, nums.length));
    }

    private static int findPeak(int[] nums, int n) {
        if (n == 1)
            return 0; // If there's only one number, it's a peak.

        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }

        int low = 0, high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (nums[mid] > nums[mid + 1]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
