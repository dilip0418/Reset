package Array.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        // Write your code here.
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(i!=0 && nums[i] == nums[i-1]) continue;
            for (int j = i+1; j < n; j++) {
                if(j != i+1 && nums[j] == nums[j-1]) continue;
                int k = j+1, l = n-1;
                while(k < l){
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum == target){
                        List<Integer> temp = Arrays.asList(nums[i] , nums[j] , nums[k] , nums[l]);
                        ansList.add(temp);
                        k++;
                        l--;
                        while(k < l && nums[k] == nums[k+1] ) k++;
                        while(k < l && nums[l] == nums[l-1] ) l--;
                    }
                    else if(sum > target){
                        l--;
                    }
                    else{
                        k++;
                    }
                }
            }
        }
        return ansList;
    }

    public static void main(String[] args) {
        // int[] arr = new int[] { -2,-1,-1,1,1,2,2};
        int[] arr = new int[] { 1, -3, 4, 0, 2, -3, 5};
        int target = 0;

        for (List<Integer> list : fourSum(arr, target)) {
            System.out.println(list);
        }
    }
}
