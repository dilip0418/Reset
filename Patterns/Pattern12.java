package Patterns;

public class Pattern12 {
    public static void main(String[] args) {
        int n = 5; // number of rows
        int spaces = 2 * n - 2; // to track the number of spaces to print in a line b/w the numbers
        for (int i = 0; i < n; i++) {
            int x = 0; // for printing the numbers and setting it to the initial state at each row
                       // change
            for (int j = 0; j < i + 1; j++) {
                System.out.print(++x); // increment the value of 'x' for printing left triangle
            }
            for (int j = spaces; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i + 1; j++) {
                System.out.print(x--); // decrementing the value of 'x' for printing right triangle
            }
            spaces -= 2; // decrement the spaces by 2 at every new row
            System.out.println();
        }
    }
}