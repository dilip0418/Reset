package BinarySearch;
import java.util.ArrayList;
import java.util.Collections;

public class BinarySearchAlgo {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Collections.addAll(arr, 1, 2, 3, 4, 5, 6, 7);
        int l = 0, r = arr.size() - 1;
        System.out.println(binarySearchIterative(arr, 6, l, r)); // true
    }

    private static int binarySearchIterative(ArrayList<Integer> arr, int target, int l, int r) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == arr.get(mid)) {
                return mid;
            }
            if (target > arr.get(mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

}
