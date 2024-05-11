package KnowBasicMaths;

public class SumOfAllDivisors {
    public static int sumDivisors(int n) {

        int sumDivisors = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                sumDivisors += i;
            }
        }
        return sumDivisors;
    }

    public static int sumOfAllDivisors(int n) {
        // Write your code here.
        int sumOfAllDivisors = 0;
        for (int i = 1; i <= n; i++) {
            sumOfAllDivisors += sumDivisors(i);
        }

        return sumOfAllDivisors;
    }

    public static int sumOfAllDivisors1(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += i * (n / i);
            // ans += sumOfAllDivisors2(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(sumOfAllDivisors1(n));
    }
}
