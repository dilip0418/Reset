package Patterns;

public class Pattern10 {
    public static void main(String[] args) {
        int rows = 5; // number of rows
        int stars = 1;
        for (int i = 0; i < 2 * rows - 1; i++) {
            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }
            for (int j = stars; j > 0; j--) {
                System.out.print(" ");
            }
            /*
             * increment the count of stars until the mid line (2*rows -1)
             * and decrease it after that
             * Example: rows = 5
             * so we have to print 2*n-1 (9) rows of stars & spaces
             * so the star count will increase util the mid line i.e 4 (0 based index)
             * after that the star count will decrease
             */
            if (i < rows - 1)
                stars++;
            else
                stars--;
            System.out.println();
        }
    }
}
