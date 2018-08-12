/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
/*
题目：定义Fibonacci数列如下：   
  / 0 n=0
f(n)= 1 n=1
  \ f(n-1)+f(n-2) n=2
输入n，用最快的方法求该数列的第n项。
分析：在很多C语言教科书中讲到递归函数的时候，都会用Fibonacci作为例子。

豆沙云：把算过的记录下来！
 */
package algorithm.puzzle100;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 */
public class N019_FastFibonacci {
    static BigDecimal MINUS_ONE = BigDecimal.valueOf(-1);
    private BigDecimal[] m_buffer = null;

    public BigDecimal calculateSlow(int p_n) {
        switch (p_n) {
            case 0:
                return BigDecimal.valueOf(0);
            case 1:
                return BigDecimal.valueOf(1);
            default:
                return calculateSlow(p_n - 1).add(calculateSlow(p_n - 2));
        }
    }

    public BigDecimal calculate(int p_n) {
        m_buffer = new BigDecimal[p_n + 1];
        Arrays.fill(m_buffer, MINUS_ONE);

        m_buffer[0] = BigDecimal.valueOf(0);
        m_buffer[1] = BigDecimal.valueOf(1);

        return fastCalculate(p_n);
    }

    /**
     * @param p_n
     * @return
     */
    private BigDecimal fastCalculate(int p_n) {
        if (m_buffer[p_n].compareTo(MINUS_ONE) != 0) {
            return m_buffer[p_n];
        }

        m_buffer[p_n] = fastCalculate(p_n - 2).add(fastCalculate(p_n - 1));

        return m_buffer[p_n];
    }

    @Test
    public void case1() {
        N019_FastFibonacci l_fb = new N019_FastFibonacci();

        System.out.println(l_fb.calculate(10));
        System.out.println(l_fb.calculate(9));
        System.out.println(l_fb.calculate(1000));
        System.out.println(l_fb.calculateSlow(10));
    }
}
