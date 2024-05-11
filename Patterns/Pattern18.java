package Patterns;

public class Pattern18 {
    public static void main(String[] args) {
        int n = 5; // size of the pattern

        for (int i = 0; i < n; i++) {
            /*
             * At every iteration set the ch variable to hold the character which is
             * 'A'+n-i-1 that is if i = 0 (A + 5 - 0 - 1 will give us 65 + 5 - 0 - 1 which
             * is 69 and the ascii/unicode value of E is 69 similarly at each iteration)
             */
            char ch = (char) ('A' + n - i - 1);
            for (int j = 0; j <= i; j++) {
                System.out.print(ch++ + " ");
            }
            System.out.println();
        }
    }
}
