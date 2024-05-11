package Array.Easy;

import java.util.ArrayList;

public class UnionOfArrays {
    public static void main(String[] args) {
        int[] num1 = new int[] { -8, -3, -3, -2, 0, 1, 2, 2, 6 };
        int[] num2 = new int[] { -9, -9, 0 };
        // System.out.println("Union of arrays: " + unionOfArrays(num1, num2));
        System.out.println("Union of arrays: " + unionOfArraysSpl(num1, num2, num1.length, num2.length));
    }

    private static ArrayList<Integer> unionOfArrays(int[] num1, int[] num2) {
        int i = 0, j = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (i < num1.length && j < num2.length) {
            /*
             * if the elements at index i in num1 and index j are same place either of the
             * element in the resultant list and update both indexes to go for next element
             * in their respective arrays/lists to avoid duplicacy
             */
            if (num1[i] == num2[j]) {
                list.add(num1[i]);
                i++;
                j++;
            }
            /*
             * if the element in first list is less. add that to resultant list and
             * increment the index of first list
             */
            else if (num1[i] < num2[j]) {
                list.add(num1[i++]);
            }
            /*
             * the other case is when the element in second list is small
             */
            else {
                list.add(num2[j++]);
            }
        }

        /*
         * if any of the lists completes, add the remaining elements of the other list
         * into the resultant list
         */
        while (i < num1.length) {
            list.add(num1[i++]);
        }
        while (j < num2.length) {
            list.add(num2[j++]);
        }
        return list;
    }

    private static ArrayList<Integer> unionOfArraysSpl(int[] arr1, int[] arr2, int n, int m) {
        ArrayList<Integer> union = new ArrayList<>();

        int i = 0, j = 0;
        while (i < n && j < m) {

            if (arr1[i] >= arr2[i]) {
                if (union.size() == 0 || union.get(union.size()-1) != arr2[i]) {
                    union.add(arr2[i]);
                }
                i++;
            } else {
                if (union.size() == 0 || union.get(union.size()-1) != arr1[j]) {
                    union.add(arr1[j]);
                }
                j++;
            }
        }
        
        while (i < n) {
            if (union.size() == 0 || union.get(union.size()-1) != arr1[i]) {
                union.add(arr1[i]);
            }
            i++;
        }
        while(j < m){
            if (union.size() == 0 || union.get(union.size()-1) != arr2[j]) {
                union.add(arr2[j]);
            }
            j++;
        }
        return union;
    }
}
