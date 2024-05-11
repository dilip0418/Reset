package Patterns;

/**
 * Pattern15
 */
public class Pattern15 {

    public static void main(String[] args) {
        int n = 5; // size of the pattern
        for (int i = 0; i < n; i++) {
            char ch = 'A';
            for (int j = 0; j < n - i; j++) {
                System.out.print(ch++);
            }
            System.out.println();
        }
    }
}