package BinarySearch;

import java.util.Arrays;

public class SplitArrayLargestSum {
    private static int getSum(int[] arr, int currentSum){
        int sum = 0, subArrays = 1;

        for(int i = 0; i < arr.length; i++){
            if(sum + arr[i] <= currentSum){
                sum += arr[i];
            }else{
                sum = arr[i];
                subArrays++;
            }
        }
        return subArrays;
    }

    private static int bs(int[] arr, int n, int k){
        if(k > n) return -1;

        int high = Arrays.stream(arr).map(i->i).sum();
        if(k == 1) return high;

        int low = Arrays.stream(arr).max().getAsInt();

        while(low <= high){
            int mid = low + (high - low)/2;

            if(getSum(arr, mid) > k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
    public static int splitArray(int[] nums, int k) {
        return bs(nums, nums.length, k);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,2,5,10,8};
        int k = 2;
        System.out.println(splitArray(nums, k));
    }
}
