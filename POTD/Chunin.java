package POTD;

import java.util.Arrays;
import java.util.Vector;

public class Chunin {

    public static Vector < Integer > chuninNinja(int n, int m, int arr[][]) {
        Vector<Integer> ans = new Vector<>();
        for (int i = 0; i < n; i++) {
            
            int row = Arrays.stream(arr[i]).max().getAsInt();
            int col = Integer.MAX_VALUE; 
            for (int j = 0; j < n; j++) {
                col = Math.min(col, arr[j][i]);
            }
            if(row == col)
                ans.add(row);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] arr = new int[][]{
            {2, 2},
            {3, 4},
            {2, 5},
            {2, 3}
        };
        
        System.out.println("The chunins"+chuninNinja(arr.length, arr[0].length,arr));
    }
}
