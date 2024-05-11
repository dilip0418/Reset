package Patterns;

/**
 * Paatern16
 */
public class Pattern16 {

    public static void main(String[] args) {
        int n = 5; // size of the pattern
        char ch = 'A';
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(ch);
            }
            ch++;
            System.out.println();
        }
    }
}