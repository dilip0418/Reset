package Patterns;

/**
 * Pattern17
 */
public class Pattern17 {

    public static void main(String[] args) {
        int n = 5; // size of the pattern
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            char ch = 'A';
            int breakPoint = (2 * i + 1) / 2; //create a breakkpoint
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print(ch);
                if (j < breakPoint)
                    ch++;
                else
                    ch--;
            }
            for (int j = n - 1 - i; j > 0; j--) {
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}