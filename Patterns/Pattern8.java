package Patterns;

import java.util.Scanner;

public class Pattern8 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.err.println("Enter the value of n:");
            int n = sc.nextInt();
            int stars = 2 * n - 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < stars; j++) {
                    System.out.print("*");
                }
                for (int j = 0; j <= i; j++) {
                    System.out.print(" ");
                }
                stars -= 2;
                System.out.println();
            }
        }
    }
}
