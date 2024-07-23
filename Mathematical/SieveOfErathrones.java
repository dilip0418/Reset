package Mathematical;

import java.util.Arrays;

public class SieveOfErathrones {
    public static void main(String[] args) {
        int n = 100;
        boolean[] isPrime = getIsPrime(n);

        System.out.println(Arrays.toString(isPrime));
    }

    
    private static boolean[] getIsPrime(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}
