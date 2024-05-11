package Patterns;

public class Pattern19 {
    public static void main(String[] args) {
        int n = 5;
        int spaces = 0;
        // Upper pattern
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");

            }
            for (int j = n - i; j > 0; j--) {
                System.out.print("*");
            }
            spaces += 2;
            System.out.println();
        }

        // Lower Pattern
        for (int i = 0; i < n; i++) {
            /*
             * Decrement in the begining as the last iteration from the upper patter will
             * increment the spaces by 2 in this case it'll make it 10 wherein we require 8
             * so decrement at the start.
             */
            spaces -= 2;
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
