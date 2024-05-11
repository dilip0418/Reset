package KnowBasicMaths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintAllDivisors {
    public static void main(String[] args) {
        int n = 10;
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                res.add(i);
                // System.out.print(i + " ");
                if (n / i != i) {
                    res.add(n / i);
                    // System.out.print(n / i + " ");
                }
            }
        }
        Collections.sort(res);
        System.out.println(res);
    }
}
