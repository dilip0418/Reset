package Array.Easy;

public class RightRotateArrayByDPlaces {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 4, 5 };
        // rightRotatebyDplaces(arr, 2);
        // leftRoateByDPlaces(arr, 2);
        rightRotatebyDplaces(arr, 2);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void rightRotatebyDplaces(int[] arr, int d) {
        int n = arr.length;
        // normalize the d value to lie withing length of the array
        if (d > n)
            d %= n;
        reverse(arr, 0, n);
        reverse(arr, 0, d);
        reverse(arr, d, n);
    }

    private static void leftRoateByDPlaces(int[] arr, int d) {
        int n = arr.length;
        if (d > n)
            d %= n;
        reverse(arr, 0, d);
        reverse(arr, d, n);
        reverse(arr, 0, n);
    }

    private static void reverse(int[] arr, int start, int end) {
        for (int i = start, j = end - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
