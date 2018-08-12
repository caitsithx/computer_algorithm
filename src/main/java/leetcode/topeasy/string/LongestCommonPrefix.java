package leetcode.topeasy.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        int end = 0;
        while (true) {
            if (strs[0].length() == end) {
                break;
            }

            char ch = strs[0].charAt(end);
            boolean cont = true;
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() == end || strs[i].charAt(end) != ch) {
                    cont = false;
                    break;
                }
            }

            if (!cont) {
                break;
            } else {
                end++;
            }
        }

        return strs[0].substring(0, end);
    }

    @Test
    public void test() {
        Assertions.assertEquals("fl",
                new LongestCommonPrefix().longestCommonPrefix(new String[]{"fly", "flower"}));
        Assertions.assertEquals("flo",
                new LongestCommonPrefix().longestCommonPrefix(new String[]{"flo", "flower"}));

        Assertions.assertEquals("",
                new LongestCommonPrefix().longestCommonPrefix(new String[]{"abc", "flower"}));
    }
}
