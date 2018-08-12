package leetcode.topeasy.string;

import org.junit.jupiter.api.Test;

public class ReverseInteger {
    public int reverse(long x) {
        if (x > 0) {
            return reverse1(x);
        } else {
            return 0-reverse1(Math.abs(x));
        }
    }

    public int reverse1(long x) {
        long val = 0;
        while(x != 0) {
            val *= 10;
            val += (x % 10);
            x /= 10;
        }

        return val > Integer.MAX_VALUE ? 0 : (int)val;
    }

    @Test
    public void test() {
        int x = -2147483648;
        System.out.println(Math.abs(x));
        System.out.println(Math.abs(Integer.MIN_VALUE));
        new ReverseInteger().reverse(-2147483648);
    }
}
