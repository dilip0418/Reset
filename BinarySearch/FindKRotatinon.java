package BinarySearch;

public class FindKRotatinon {
    public static void main(String[] args) {
        // int arr[] = new int[] { 3, 4, 5, 1, 2 };
        int arr[] = new int[] { 2, 3, 4, 1 };
        System.out.println("Given array is rotated " + findKRotation(arr, arr.length));
        System.out.println("Given array is rotated " + findKRotationUsingBS(arr, arr.length));
        
    }

    /*
     * Brute force approach performing a linear search to find the first element
     * which is greater than its next element and then finding that index
     * Time complexity: O(n)
     * Space Complexity: O(1)
     */
    private static int findKRotation(int[] arr, int length) {
        int k = 0;

        if (arr.length == 1)
            return k;
        for (int i = 0; i < length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                k = i + 1;
                break;
            }
        }
        return k;
    }

    private static int findKRotationUsingBS(int[] arr, int n) {
        int k = 0;

        if (arr.length == 1)
            return k;

        int low = 0, high = n - 1;
        int min = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[low] <= arr[mid]) {
                if (min > arr[low]) {
                    min = Math.min(min, arr[low]);
                    k = low;
                }
                low = mid + 1;
            } else {
                if (min > arr[mid]) {
                    min = Math.min(min, arr[mid]);
                    k = mid;
                }
                high = mid - 1;
            }
        }
        return k;
    }

    private static int findKRotationUsingBSWithXOR(int[] nums) {
        int low = 0;
        int high = nums.length - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == nums[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return nums[low];
    }
}
