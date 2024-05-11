package Array.Easy;

public class RightRotateArrayByDPlaces {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 4, 5 };
        // rightRotatebyDplaces(arr, 2);
        leftRoateByDPlaces(arr, 2);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static int[] rightRotatebyDplaces(int[] arr, int d) {
        if (d == 0 || d == arr.length)
            return arr;
        int i = 0, temp;
        while (i < d) {
            temp = arr[i];
            arr[i] = arr[(d + i) % arr.length];
            arr[(d + i) % arr.length] = temp;
            // d--;
            i++;
        }
        return arr;
    }

    private static void leftRoateByDPlaces(int[] arr, int d) {
        int n = arr.length;
        d %= n;
        if (d > n)
            return;
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
