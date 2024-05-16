package POTD;

import java.util.HashMap;
import java.util.Map;

public class MailingProblem {
    public static void main(String[] args) {
        String keyBoard = "abcdefghijklmnopqrstuvwxyz";
        String s = "abc";
        System.out.println(timeTakenToMail(keyBoard, s));
        System.out.println(timeTakenToMailUsingMaps(keyBoard, s));
    }

    /*
     * Brute force
     * Time Complexity : ~ O(n*m) {n = s.length() & m = keyboard.length()}
     * Space Complexity : O(1)
     */
    public static int timeTakenToMail(String keyboard, String s) {
        // Write your code here.
        int sum = 0;
        int j = 0; // this var is to track the previous char
        /*
         * for every character at index i in s:
         * find the index of that char in keyboard (k)
         * update sum += abs(k - j) // this finds the number of steps to travel from
         * current key to next key.
         */
        for (int i = 0; i < s.length(); i++) {
            for (int k = 0; k < keyboard.length(); k++) {
                if (s.charAt(i) == keyboard.charAt(k)) {
                    sum += Math.abs(k - j);
                    j = k;
                    break;
                }
            }
        }

        return sum;
    }

    // using maps
    private static int timeTakenToMailUsingMaps(String keyboard, String s) {
        Map<Character, Integer> map = new HashMap<>();

        // Store the char at i and i in the keyboard string into a map.
        for (int i = 0; i < keyboard.length(); i++) {
            map.put(keyboard.charAt(i), i);
        }

        /*
         * add the number of steps taken to move from first char in keyboard to reach
         * first char in s.
         */
        int ans = map.get(s.charAt(0));

        /*
         * subsequently updatet the ans by calculating the steps to move from previous
         * char to current char. (use abs diff as we will move back and forth)
         */
        for (int i = 1; i < s.length(); i++) {
            ans += Math.abs(map.get(s.charAt(i)) - map.get(s.charAt(i - 1)));
        }
        return ans;
    }

}
