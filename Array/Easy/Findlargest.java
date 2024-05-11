package Array.Easy;

public class Findlargest {
    public static void main(String[] args) {
        // int arr[] = new int[] { 1, 5, -73, 29, -10 };
        int arr[] = new int[] { 5, 9, 3, 4, 8, 4, 3, 10 };
        System.out.println("Largest element in the array is: " + findMaxElement(arr));
    }

    private static int findMaxElement(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr.length == 1) {
                return arr[0];
            } else {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
        }
        return max;
    }
}
