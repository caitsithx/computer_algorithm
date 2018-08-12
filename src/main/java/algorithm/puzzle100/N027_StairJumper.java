/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
/*
27.跳�?�阶问题
题目：一个�?�阶总共有n级，如果一次�?�以跳1级，也�?�以跳2级。
求总共有多少总跳法，并分�?算法的时间�?�?�度。

这�?�题最近�?常出现，包括MicroStrategy等比较�?视算法的公�?�都
曾先�?�选用过个这�?�题作为�?�试题或者笔试题。
 */
package algorithm.puzzle100;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * (n/2 + i) * ..... (n/2 - i + 1) / (2n)!
 *
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 */
public class N027_StairJumper {

    /**
     * @param p_stairCount
     * @return
     */
    public BigDecimal list(int p_stairCount) {
        BigDecimal l_total = new BigDecimal(0);

        if (p_stairCount == 1) {
            return BigDecimal.valueOf(1);
        }

        if (p_stairCount == 2) {
            return BigDecimal.valueOf(2);
        }

        int l_countTwo = p_stairCount / 2;
        int l_countOne = p_stairCount - l_countTwo * 2;


	/*
   * (n/2 + i) * .... * (n/2 - i + 1) / (2i)!
	 */
        if (l_countOne == 0) {
            BigDecimal l_fenZi = BigDecimal.valueOf(1);
            BigDecimal l_fenMu = BigDecimal.valueOf(1);
            for (int l_i = 0; l_i <= p_stairCount / 2; l_i++) {
                l_fenZi = l_i > 0 ? BigDecimal.valueOf(p_stairCount / 2 + l_i).multiply(l_fenZi)
                    .multiply(BigDecimal.valueOf(p_stairCount / 2 - l_i + 1)) : l_fenZi;
                l_fenMu = l_i > 0 ? BigDecimal.valueOf(l_i * 2)
                    .multiply(BigDecimal.valueOf(l_i * 2 - 1)).multiply(l_fenMu) : l_fenMu;
                l_total = l_total.add(l_fenZi.divide(l_fenMu));
            }
        }
  /*
   * (n/2 + i + 1) * .... * (n/2 - i + 1) / (2i + 1)!
	 */
        else if (l_countOne == 1) {
            BigDecimal l_fenZi = BigDecimal.valueOf(p_stairCount / 2 + 1);
            BigDecimal l_fenMu = BigDecimal.valueOf(1);
            for (int l_i = 0; l_i <= p_stairCount / 2; l_i++) {
                l_fenZi = l_i > 0 ? BigDecimal.valueOf(p_stairCount / 2 + l_i + 1).multiply(l_fenZi)
                    .multiply(BigDecimal.valueOf(p_stairCount / 2 - l_i + 1)) : l_fenZi;
                l_fenMu = l_i > 0 ? BigDecimal.valueOf(l_i * 2 + 1)
                    .multiply(BigDecimal.valueOf(l_i * 2)).multiply(l_fenMu) : l_fenMu;
                l_total = l_total.add(l_fenZi.divide(l_fenMu));
            }
        }

        return l_total;
    }

    @Test
    public void case1() {
        Assertions.assertEquals(BigDecimal.valueOf(1), list(1));
        Assertions.assertEquals(BigDecimal.valueOf(2), list(2));
        Assertions.assertEquals(BigDecimal.valueOf(3), list(3));
        Assertions.assertEquals(BigDecimal.valueOf(5), list(4));
        Assertions.assertEquals(BigDecimal.valueOf(8), list(5));
        Assertions.assertEquals(BigDecimal.valueOf(13), list(6));
        Assertions.assertEquals(BigDecimal.valueOf(21), list(7));
        Assertions.assertEquals(BigDecimal.valueOf(34), list(8));
        Assertions.assertEquals(BigDecimal.valueOf(55), list(9));
    }
}
