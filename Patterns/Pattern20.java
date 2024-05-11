package Patterns;

public class Pattern20 {
    public static void main(String[] args) {
        int n = 5;
        int stars = 1, spaces = 2 * n - 2;
        int brkpt = (2 * (n - 1)) / 2; // breakpoint for symmetry
        for (int i = 0; i < 2 * n; i++) {
            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }
            System.out.println();

            if (i < brkpt) {
                // increment the stars by 1 and decrement the spaces by 2 until the breakpoint
                // is reached
                stars++;
                spaces -= 2;
            } else {
                // perform the operation in the opposite manner
                stars--;
                spaces += 2;
            }
        }
    }
}
