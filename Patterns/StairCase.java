package Patterns;

public class StairCase {
    public static void staircase(int n) {
        // Write your code here
        int spaces = n - 1, stars = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = spaces; j >= 0; j--) {
                System.out.print("$");
            }
            for (int j = stars; j > 0; j--) {
                System.out.print("#");
            }
            System.out.println();
            stars++;
            spaces--;
        }

    }

    public static void main(String[] args) {
        int n = 5; // number of steps
        staircase(n);
    }
}
