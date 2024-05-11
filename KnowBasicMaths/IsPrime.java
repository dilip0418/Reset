package KnowBasicMaths;

import java.util.Scanner;

public class IsPrime {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        boolean prime = false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                prime = false;
                break;
            } else {
                prime = true;
            }
        }
        if (prime) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
