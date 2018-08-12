package leetcode.topeasy.array.plusone;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Solution {
    public int[] plusOne(int[] digits) {
        boolean resizeed = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            int tmp = digits[i] + 1;
            if(tmp / 10 == 0) {
                digits[i] = tmp;
                break;
            } else {
                digits[i] = tmp % 10;
            }

            if(i == 0) {
                resizeed = true;
            }
        }

        if(resizeed) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, digits.length);

            return result;
        } else {
            return digits;
        }
    }

    @Test
    public void test() {
        Arrays.stream(new Solution().plusOne(new int[]{1, 2, 3})).forEach(System.out::println);
    }
}