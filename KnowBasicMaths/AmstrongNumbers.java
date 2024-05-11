package KnowBasicMaths;

import java.util.Scanner;

public class AmstrongNumbers {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int k = String.valueOf(n).length();
        int temp = 0;
        int temp1 = n;
        while (n != 0) {
            temp += Math.pow(n % 10, k);
            n /= 10;
        }
        if (temp == temp1)
            System.out.println(true);
        else
            System.out.println(false);

    }
}
