package Patterns;

public class Pattern22 {
    public static void main(String[] args) {
        int n = 5;

        for (int i = 0; i < 2 * n - 1; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                System.out.print(n - Math.min(Math.min(j, (2 * n - 2) - j), Math.min(i, (2 * n - 2) - i)) + " ");
            }
            System.out.println();
        }
    }
}
