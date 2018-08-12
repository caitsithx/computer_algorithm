/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
/*
第17题：
题目：在一个字符串中找到第一个只出现一次的字符。如输入abaccdeff，则输出b。   
分析：这道题是2006年google的一道笔试题。

豆沙云：类似Radius Sort的思想！
 */
package algorithm.puzzle100;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 */
public class N017_FindCharOccuredOnce {

    public void find(byte[] p_inputs) {
        int[] l_charTable = new int[256];
        Arrays.fill(l_charTable, 0);

        for (int l_i = 0; l_i < p_inputs.length; l_i++) {
            l_charTable[p_inputs[l_i]]++;
        }

        for (int l_i = 0; l_i < p_inputs.length; l_i++) {
            if (l_charTable[p_inputs[l_i]] == 1) {
                System.out.print((char) p_inputs[l_i]);
            }
        }
    }

    @Test
    public void case1() {
        N017_FindCharOccuredOnce l_finder = new N017_FindCharOccuredOnce();
        l_finder.find(new byte[] {(byte) 'a', (byte) 'b', (byte) 'c', (byte) 'd', (byte) 'e',
            (byte) 'a', (byte) 'c', (byte) 'f', (byte) 'f'});

    }
}
