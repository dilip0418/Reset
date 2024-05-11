package BinarySearch;

public class SerachInRotatedArray1 {

    public static void main(String[] args) {
        // int[] arr = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        // int[] arr = new int[] { 10, 11, 1, 2, 3, 4, 5, 6, 9 };
        int[] arr = new int[] { 11, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println("The target is 3 and the result is : " + search(arr, 3, arr.length));
    }

    private static int search(int[] arr, int target, int n) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                if (arr[low] <= target && target <= arr[mid])
                    low = mid + 1;
                else
                    high = mid - 1;
            } else {
                if (arr[mid] <= target && target <= arr[high])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }
}
