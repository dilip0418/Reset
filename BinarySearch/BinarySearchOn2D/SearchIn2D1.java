package BinarySearch.BinarySearchOn2D;

public class SearchIn2D1 {
    public static void main(String[] args) {
        // int mat[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int mat[][] = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        // 10 20 30 40 15 25 35 45 27 29 37 48 32 33 39 50
        // int mat[][] = {
        // { 10, 20, 30, 40 },
        // { 15, 25, 35, 45 },
        // { 27, 29, 37, 48 },
        // { 32, 33, 39, 50 }
        // };
        int target = 60;
        boolean res = matSearch(mat, mat.length, mat[0].length, target);
        // boolean res = matSearchRowColSorted(mat, mat.length, mat[0].length, target);
        System.out.println("Is " + target + " present in the matrix? " + (res ? "Yes" : "No"));
    }

    public static boolean matSearch(int mat[][], int N, int M, int X) {
        // your code here

        int low = 0, high = (N * M) - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int x = mid / M;
            int y = mid % M;
            if (mat[x][y] == X) {
                return true;
            } else if (mat[x][y] < X) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    private static boolean matSearchRowColSorted(int[][] mat, int N, int M, int X) {
        int row = 0, col = M - 1;
        while (row < N && col >= 0) {
            if (mat[row][col] == X) {
                return true;
            } else if (mat[row][col] < X) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
