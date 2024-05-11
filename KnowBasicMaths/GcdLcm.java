package KnowBasicMaths;

public class GcdLcm {
    public static void gcdLcm(int a, int b) {
        // bruteforce approach
        int minAB = Math.min(a, b);
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < minAB; i++) {
            if (a % i == 0 && b % i == 0) {
                if (result < i)
                    result = i;
            }
        }
        System.out.println(result + " is the gcd(" + a + " , " + b + ")");
        System.out.println((a * b) / result + " is the lcm(" + a + "," + b + ")");
    }

    public static int gcdLcmUsingEuclid(int a, int b){
        if(a==0)
        {
            return b;
        }   
        else return gcdLcmUsingEuclid(b%a,a);
    }
    public static void main(String[] args) {
        int a = 6, b = 4;
        gcdLcm(a, b);
        System.out.println(gcdLcmUsingEuclid(a, b)+" is the gcd("+a+","+b+") using Euclid's algorithm.");
        System.out.println((a*b)/b+" is the LCM("+a+","+b+")");
    }
}
