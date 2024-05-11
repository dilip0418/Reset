package Patterns;

import java.util.Scanner;

public class Pattern7 {
    public static void main(String[] args) {
        int n;
        try (Scanner scanner = new Scanner(System.in)) {
            System.err.println("Enter the value of n: ");
            n = scanner.nextInt();
        }
        int stars = 1;
        for (int i = 0; i < n; i++) {

            // 1st pyramid which prints spaces
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            // 2nd pyramid which prints stars
            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }
            // 3rd pyramid which prints spaces
            for (int j = 0; j < n - i; j++) {
                System.err.print(" ");
            }
            /*
             * The first line has 1 star and the next has 3 and so on till n at every line
             * there are 2 stars more than the stars in previous line
             */
            stars += 2;
            System.out.println();
        }

        System.out.println("The other possibility without using a variable for holding the count of stars:");
        for (int i = 0; i < n; i++) {
            // spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            // spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
