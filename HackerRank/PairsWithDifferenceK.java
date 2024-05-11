package HackerRank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairsWithDifferenceK {

    private static int countPairs(List<Integer> arr, int k) {
        if (arr == null || arr.size() < 2)
            return 0;
        int count = 0;
        /* 
         * for (int i = 0; i < arr.size(); i++) {
         * int rem = Math.abs(arr.get(i)-k);
         * for (int j = 0; j < arr.size(); j++) {
         * if(i != j && arr.get(j) == rem){
         * count++;
         * }
         * }
         * }
         */

         Set<Integer> set = new HashSet<>();
         for (Integer integer : arr) {
            set.add(integer);
         }

         for(Integer integer : set){
            if(set.contains(integer - k) || set.contains(integer + k)){
                count++;
            }
         }
        return (int)Math.ceil((double)count/2);
    }

    public static void main(String[] args) {
        int n = 5, k = 2;
        List<Integer> arr = Arrays.asList(1, 5, 3, 4, 2);
        System.out.println("Number of pairs with difference K: " + countPairs(arr, k));
    }
}
