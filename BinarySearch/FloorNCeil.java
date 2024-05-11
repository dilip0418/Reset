package BinarySearch;

import java.util.Arrays;

public class FloorNCeil {

    public static int floor(int[] a, int n, int x) {
        int floor = -1;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] <= x) {
                floor = a[mid];
                l = mid + 1;
            } else if (a[mid] > x) {
                r = mid - 1;
            }
        }
        return floor;
    }

    public static int ceil(int[] a, int n, int x) {
        int ceil = -1;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] >= x) {
                ceil = a[mid];
                r = mid - 1;
            } else if (a[mid] < x) {
                l = mid + 1;
            }
        }
        return ceil;
    }

    public static int[] getFloorAndCeil(int[] a, int n, int x) {
        // Wriute your code here.
        int[] ans = new int[2];
        ans[0] = floor(a, n, x);
        ans[1] = ceil(a, n, x);
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 3, 4, 4, 7, 8, 10 };
        int x = 8;
        System.out.println(
                "Floor and ceil of " + Arrays.toString(arr) + " is "
                        + Arrays.toString(getFloorAndCeil(arr, arr.length, x)));

    }
}
