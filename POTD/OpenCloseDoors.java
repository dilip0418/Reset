package POTD;

/* 
 * Problem statement
There are ‘N’ doors and ‘N’ people in a house. Each person and door has a unique ID ranging from 1 to ‘N’. 
A person can change the status of the door i.e, if the door is open then a person can close the door and vice versa. 
Initially, all the doors are closed and each person wants to change the status of all doors whose ID 
is a multiple of the ID of the person. You need to find out the final status of all the doors.

The answer should be given in a form of a binary string where ‘0’ represents the closed door and ‘1’ represents the open door. For example, the status “close open close” will form a binary string “010”.
 */

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
