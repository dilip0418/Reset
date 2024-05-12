package POTD;

import java.util.Arrays;

public class OpenCloseDoors {
    public static String doorStatus(int n) {
        // Write your code here.
        char[] doors = new char[n];
        Arrays.fill(doors, '0');
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j % i == 0) {
                    if (doors[j - 1] == '0') {
                        doors[j - 1] = '1';
                    } else if (doors[j - 1] == '1') {
                        doors[j - 1] = '0';
                    }
                }
            }
        }
        return new String(doors);
    }

    public static void main(String[] args) {
        System.out.println(doorStatus(2));
    }
}
