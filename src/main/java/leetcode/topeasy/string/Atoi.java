package leetcode.topeasy.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.omg.PortableInterceptor.INACTIVE;

public class Atoi {
    public int myAtoi(String str) {
        int firstNum = 0;
        while (firstNum < str.length()) {
            if(str.charAt(firstNum) == ' ') {
                firstNum++;
            } else if(!isNum(str.charAt(firstNum)) && !isPlus(str.charAt(firstNum))) {
                return 0;
            } else {
                break;
            }
        }

        if(firstNum == str.length()) {
            return 0;
        }

        int endNum = firstNum + 1;
        long result = 0;
        boolean plus = true;
        if(isPlus(str.charAt(firstNum))) {
            plus = str.charAt(firstNum) == '+';
        } else {
            result += (str.charAt(firstNum) - '0');
        }

        while (endNum < str.length()) {
            if (isNum(str.charAt(endNum))) {
                long tmp = result * 10 + (str.charAt(endNum) - '0');

                if(plus) {
                    if (tmp > Integer.MAX_VALUE) {
                        result = Integer.MAX_VALUE;
                        break;
                    } else {
                        result = tmp;
                    }
                } else {
                    if (tmp > (long)Integer.MAX_VALUE + 1) {
                        result = (long)Integer.MAX_VALUE + 1;
                        break;
                    } else {
                        result = tmp;
                    }
                }

                endNum ++;
            } else {
                break;
            }
        }

        if(plus) {
            return (int)result;
        }
        else {
            return -(int)result;
        }
    }

    private boolean isNum(char charAt) {
        return charAt >= '0' && charAt <= '9';
    }

    private boolean isPlus(char charAt) {
        return charAt == '-' || charAt == '+';
    }

    @Test
    public void test() {
        Assertions.assertEquals(2147483647 , new Atoi().myAtoi("9223372036854775808"));
        Assertions.assertEquals(-2147483648 , new Atoi().myAtoi("-9223372036854775808"));


        Assertions.assertEquals(123 , new Atoi().myAtoi("123"));
        Assertions.assertEquals(0 , new Atoi().myAtoi("+0 123"));

        Assertions.assertEquals(123 , new Atoi().myAtoi("+123"));

        Assertions.assertEquals(-123 , new Atoi().myAtoi("-123"));
        Assertions.assertEquals(-1 , new Atoi().myAtoi("   -1  23  "));
        Assertions.assertEquals(-1 , new Atoi().myAtoi("   -1  2a3  "));
        Assertions.assertEquals(0 , new Atoi().myAtoi(" a  -1  2a3  "));


    }

}
