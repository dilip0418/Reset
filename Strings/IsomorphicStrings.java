package Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
    public static void main(String[] args) {
        // String s1 = "egg";
        // String s2 = "add";
        String s1 = "badc";
        String s2 = "baba";
        System.out.println(isIsomorphic(s1, s2));
    }

    
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i), c1 = t.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, c1);
                if (set.contains(c1)) {
                    return false;
                }
                set.add(c1);
            }
        }
        return true;
    }
}
