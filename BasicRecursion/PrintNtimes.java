package BasicRecursion;

import java.util.ArrayList;
import java.util.List;

public class PrintNtimes {

    public static List<String> printNtimes(int x, List<String> CN) {

        if (x == 1) {
            CN.add("TUF");
        } else {
            CN.add("TUF");
            printNtimes(x - 1, CN);
        }
        return CN;
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> CN = new ArrayList<>();
        for (String string : printNtimes(n, CN)) {
            System.out.println(string);
        }
    }
}
