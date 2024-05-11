package BinarySearch;

public class FirstAndLastOccurence {
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
                if (arr[mid] == k)
                    ans = mid;
                l = mid + 1;
            }
        }
        return ans;
    }

    public static int[] firstAndLastPosition(int[] arr, int n, int k) {
        // Write your code here.
        int firstOccurence = lowerBound(arr, n, k);
        if (firstOccurence == -1) {
            return new int[] { -1, -1 };
        }
        int lastOccurence = upperBound(arr, n, k);
        return new int[] { firstOccurence, lastOccurence };
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 2 };
        // arr.add(0);
        // arr.add(0);
        // arr.add(1);
        // arr.add(1);
        // arr.add(2);
        // arr.add(2);
        // arr.add(2);
        // arr.add(2);
        int n = arr.length;
        int k = 2;
        int[] result = firstAndLastPosition(arr, n, k);
        System.out.println("First position of " + k + ": " + result[0]);
        System.out.println("Last position of " + k + ": " + result[1]);
    }
}
