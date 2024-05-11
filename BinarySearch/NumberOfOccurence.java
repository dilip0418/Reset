package BinarySearch;

public class NumberOfOccurence {
    public static int lowerBound(int[] arr, int n, int k) {
        int l = 0;
        int r = n - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= k) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public static int upperBound(int[] arr, int n, int k) {
        int l = 0;
        int r = n - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > k) {
                r = mid - 1;
            } else {
                ans = mid;
                l = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        /*
         * int arr[] = new int[] { 1, 1, 1, 2, 2, 3, 3 };
         * int n = arr.length;
         * int l = lowerBound(arr, n, 3);
         * l = l < 0 ? 0 : l;
         * int r = upperBound(arr, n, 3);
         * r = arr[r] == 3 ? r : 0;
         * int ans = r - l + 1;
         * System.out.println(ans);
         */
        // Output: 0

        int arr[] = new int[] { 1, 1, 1, 2, 7, 9, 11, 11, 16, 17, 19 };
        int n = arr.length;
        int x = 1;
        int l = lowerBound(arr, n, x);
        l = l < 0 ? 0 : l;
        int r = upperBound(arr, n, x);
        r = arr[r] == x ? r : 0;
        int ans = r > 0 && l >= 0 ? r - l + 1 : 0;
        System.out.println(ans);
        // Output: 0
    }
}
