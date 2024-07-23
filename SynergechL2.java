import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SynergechL2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();
        int matrixSize = message.length();
        char[][] encodeMatrix = new char[matrixSize][matrixSize];
        encodeMatrix = loadMatrix(message, encodeMatrix);
        for (char[] row : encodeMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static char[][] loadMatrix(String message, char[][] encodeMatrix) {
        message = new StringBuilder(message).reverse().toString();
        int n = encodeMatrix.length;
        int k = 0;

        // Fill the matrix with random characters first
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                encodeMatrix[i][j] = getUniqueRandomCharacter(encodeMatrix, i, j);
            }
        }

        // Now place the message characters on the diagonals
        for (int i = 0; i < n; i++) {
            // Left diagonal encoding
            encodeMatrix[i][i] = message.charAt(k);

            // Right diagonal encoding
            encodeMatrix[i][n - i - 1] = message.charAt(k);

            k++;
        }

        return encodeMatrix;
    }

    public static char getUniqueRandomCharacter(char[][] matrix, int row, int col) {
        Random random = new Random();
        char newChar;
        do {
            newChar = (char) ('A' + random.nextInt(26)); // Generate a random uppercase letter
        } while (!isUnique(matrix, row, col, newChar));
        return newChar;
    }

    public static boolean isUnique(char[][] matrix, int row, int col, char ch) {
        int n = matrix.length;
        // Check left
        if (col > 0 && matrix[row][col - 1] == ch)
            return false;
        // Check right
        if (col < n - 1 && matrix[row][col + 1] == ch)
            return false;
        // Check up
        if (row > 0 && matrix[row - 1][col] == ch)
            return false;
        // Check down
        if (row < n - 1 && matrix[row + 1][col] == ch)
            return false;
        return true;
    }
}
