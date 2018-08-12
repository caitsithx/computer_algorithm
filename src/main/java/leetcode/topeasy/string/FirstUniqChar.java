package leetcode.topeasy.string;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {
    public int firstUniqChar(String s) {
        Map<Character, Boolean> uniques = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (uniques.containsKey(current)) {
                uniques.put(current, Boolean.FALSE);
            } else {
                uniques.put(current, Boolean.TRUE);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (uniques.get(current))  {
                return i;
            }
        }

        return -1;
    }
}
