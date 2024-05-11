package Patterns;

public class Pattern11 {
    public static void main(String[] args) {
        int n = 5; // number of rows
        int x = 1;
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 1)
                x = 1;
            else
                x = 0;
            for (int j = 0; j < i + 1; j++) {
                // x ^= 1; // toggle the x value from 0 <-> 1
                System.out.print(x ^= 1);
            }
            System.out.println();
        }
    }
}