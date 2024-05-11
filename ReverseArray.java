import java.util.ArrayList;
import java.util.Collections;

public class ReverseArray {
    public static void main(String[] args) {

        ArrayList<Integer> array = new ArrayList<Integer>();
        Collections.addAll(array, 1, 2, 3, 4, 5);
        reverseAfterPositionM(array, 2);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void reverseAfterPositionM(ArrayList<Integer> array, int m) {
        // Write your code here.
        int i, j;
        for (i = m + 1, j = array.size() - 1; i < j; i++, j--) {
            int temp = array.get(i);
            array.set(i, array.get(j));
            array.set(j, temp);
        }
        System.out.println(i + " " + j);
        for (Integer integer : array) {
            System.out.println(integer);
        }
    }
}
