package Patterns;

import java.util.Scanner;

public class Pattern9 {
    public static void main(String[] args) {
        int n = 0;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the value of n:");
            n = sc.nextInt();
        } catch (Exception e) {
            System.out.println(e);
        }

        // for upper triangle
        int stars = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }
            for (int j = n - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < args.length; j++) {

            }
            stars += 2;
            System.out.println();
        }

        // for lower triangle
        stars = 2 * n - 1;
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }
            for (int j = i; j > 0; j--) {
                System.out.print(" ");
            }
            stars -= 2;
            System.out.println();
        }
    }
}
