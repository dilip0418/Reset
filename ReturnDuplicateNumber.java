import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ReturnDuplicateNumber {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(2);
        System.out.println("The duplicate number is " + findDuplicateNumberWhichReapeatsTwice(arr, 2));

        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(3);
        arr1.add(3);
        arr1.add(3);
        arr1.add(1);
        arr1.add(2);
        arr1.add(4);
        System.out
                .println("The duplicate number is " + findDuplicateNumberWhichReapeatsMoreThanTwice(arr1, arr1.size()));

    }

    public static int findDuplicateNumberWhichReapeatsMoreThanTwice(ArrayList<Integer> array, int n) {
        Set<Integer> set = new HashSet<>();
        int ans = -1;
        for (Integer integer : array) {
            if (set.contains(integer)) {
                ans = integer;
            } else {
                set.add(integer);
            }
        }
        return ans;
    }

    private static int findDuplicateNumberWhichReapeatsTwice(ArrayList<Integer> arr, int N) {
        int sumN = N * (N + 1) / 2; // Sum of first N natural numbers
        int sumARR = 0;
        for (Integer integer : arr) {
            sumARR += integer;
        }
        return sumARR - sumN;
    }
}
