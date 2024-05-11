import java.util.ArrayList;

public class RaotateArrayByKTimes {

    public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
        // Write your code here.
        System.out.println(arr.size());
        while (k != 0) {
            int temp = arr.get(0);
            for (int i = 1; i < arr.size(); i++) {
                arr.set(i - 1, arr.get(i));
            }
            arr.set(arr.size() - 1, temp);
            k--;
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        rotateArray(list, 3);
        System.out.println(list);
    }
}
