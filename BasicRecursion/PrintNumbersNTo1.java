package BasicRecursion;

public class PrintNumbersNTo1 {

    public static int[] printNTo1(int beg, int n, int[] arr) {
        if (n == 0)
            return arr;
        else {
            arr[n - 1] = beg + 1;
            printNTo1(beg + 1, n - 1, arr);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[3];
        printNTo1(0, 3, arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]); 
        }
    }
}
