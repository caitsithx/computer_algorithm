package leetcode.topeasy.string;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> dict = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            if(dict.containsKey(s.charAt(i))) {
                dict.put(s.charAt(i), dict.get(s.charAt(i)) + 1);
            } else {
                dict.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (dict.containsKey(t.charAt(i))) {
                int newCount = dict.get(t.charAt(i)) - 1;
                if(newCount == 0) {
                    dict.remove(t.charAt(i));
                } else {
                    dict.put(t.charAt(i), newCount);
                }
            } else {
                return false;
            }
        }

        return dict.isEmpty();
    }
}
