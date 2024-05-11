package BinarySearch;

public class PowerOfN {

    public static double helper(double x,  long n, double ans){
        while(n > 0){
            if((n&1) == 0)
            ans *= helper(x*x, n/2, ans);
            else
            ans *= x*helper(x*x,n/2, ans);
        }
        return ans;
    }
    
    private static double power(double x, long n){
        if(n == 1) return x;
        if(n == 0) return 1;
        
        return n < 0 ? 1/helper(x, Math.abs(n),1.0) : helper(x, Math.abs(n),1.0);
    }
    public static void main(String[] args) {
        System.out.println("Hello World");
		int x = 2, n = 10;
		System.out.println("The value of "+x+" to the power of "+n+" is:"+power(x, n));
    }
}
