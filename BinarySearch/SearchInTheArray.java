package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchInTheArray {
    public static int binarySearch(ArrayList<Integer> arr, int target, int left, int right) {
        int firstPos = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            /*
             * As the question has "less than equal to all the elements" and also has
             * repition of items check this condition like below : since in normal
             * binarySearchAlgo it's like arr[mid] == target
             */
            if (arr.get(mid) <= target) {
                firstPos = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return firstPos;
    }

    public static ArrayList<Integer> searchInTheArray(ArrayList<Integer> arr, ArrayList<Integer> queries, int n,
            int q) {
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        for (Integer query : queries) {
            int pos = binarySearch(arr, query, 0, n - 1);
            int sum = 0;
            for (int i = 0; i <= pos; i++) {
                sum += arr.get(i);
            }
            ans.add(sum);
        }
        return ans;

    }

    public static void main(String[] args) {
        int n = 5, q = 3;
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 5));
        ArrayList<Integer> queries = new ArrayList<>(Arrays.asList(1, 2, 5));
        System.out.println(searchInTheArray(arr, queries, n, q));
    }
}

/*
 * URL to the problem:
 * https://www.codingninjas.com/studio/problems/search-in-the-array_1116099?
 * utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&
 * leftPanelTabValue=SUBMISSION&customSource=studio_nav
 */