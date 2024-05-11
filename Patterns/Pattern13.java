package Patterns;

public class Pattern13 {
    public static void main(String[] args) {
        int rows = 5; // number of rows to print
        int x = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(++x + " ");
            }
            System.out.println();
        }
    }
}
