/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */

/*
30.在从1到n的正数中1出现的次数（数组）
题目：输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。
例如输入12，从1到12这些整数中包含1 的数字有1，10，11和12，1一共出现了5次。
分析：这是一道广为流传的google面试题。

豆沙：首先简化一下问题:
1) 限定取值为：9, 99, 999等等，那么input简化为9的个数；
2) 稍微扩展一下input：19, 199, 2999等等，可以利用1)的结果；
 */
package algorithm.puzzle100;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 */
public class N030_GoogleCountOnebyRange {
    protected final static int[] DICT = new int[] {0, 1, 1, 1, 1, 1, 1, 1, 1, 1};

    /**
     * 9: DICT[9]
     * 99: countOneBy9(9) * 10 + DICT[9] * 10^1
     * 999: countOneBy9(99) * 10 + DICT[9] * 10^2
     * ...
     *
     * @param p_NumOf9
     * @return
     */
    public long countOneBy9(int p_NumOf9) {
        if (p_NumOf9 == 0) {
            return 0;
        }

        int l_count = DICT[9];
        int l_yuXiang = DICT[9];
        for (int l_i = 1; l_i < p_NumOf9; l_i++) {
            l_yuXiang *= 10;
            l_count = l_count * 10 + l_yuXiang;
        }

        return l_count;
    }

    /**
     * x9: (x+1) * countOneBy9(  9) + DICT[x] * 10^1
     * x99: (x+1) * countOneBy9( 99) + DICT[x] * 10^2
     * x999: (x+1) * countOneBy9(999) + DICT[x] * 10^3
     *
     * @param p_x
     * @param p_numOfFollowing9
     * @return
     */
    public long countOneByX9(int p_x, int p_numOfFollowing9) {
        if (p_x == 0 && p_numOfFollowing9 == 0) {
            return 0;
        }

        long l_count = (p_x + 1) * countOneBy9(p_numOfFollowing9);
        if (p_x != 0) {
            l_count += DICT[p_x] * ((long) Math.pow(10, p_numOfFollowing9));
        }

        return l_count;
    }

    @Test
    public void case1_N030_GoogleCountOnebyRange() {
        Assertions.assertEquals(1, (countOneBy9(1))); //9
        Assertions.assertEquals(20, (countOneBy9(2))); //99
        Assertions.assertEquals(300, (countOneBy9(3))); //999
    }

    @Test
    public void case2_N030_GoogleCountOnebyRange() {
        Assertions.assertEquals(12, (countOneByX9(1, 1))); //19
        Assertions.assertEquals(160, (countOneByX9(2, 2))); //299
        Assertions.assertEquals(280, (countOneByX9(8, 2))); //899
        Assertions.assertEquals(countOneBy9(3), (countOneByX9(9, 2))); //999
    }
}
