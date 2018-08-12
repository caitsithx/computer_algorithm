package leetcode.topeasy.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 0) return "";
        String current = "1";
        for (int i = 2; i < n + 1; i++) {
            int ch = -1;
            int count = 0;
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < current.length(); j++) {
                if (ch == -1) {
                    ch = current.charAt(j);
                    count = 1;
                } else if(ch == current.charAt(j)) {
                    count ++;
                } else {
                    stringBuilder.append(count).append((char)ch);
                    ch = current.charAt(j);
                    count = 1;
                }

                if(j == current.length() - 1) {
                    stringBuilder.append(count).append((char)ch);
                }
            }
            current = stringBuilder.toString();
        }

        return current;
    }

    @Test
    public void test() {
//        Assertions.assertEquals("1", new CountAndSay().countAndSay(1));
//        Assertions.assertEquals("11", new CountAndSay().countAndSay(2));
//        Assertions.assertEquals("21", new CountAndSay().countAndSay(3));
        Assertions.assertEquals("1211", new CountAndSay().countAndSay(4));
        Assertions.assertEquals("111221", new CountAndSay().countAndSay(5));

    }
}
