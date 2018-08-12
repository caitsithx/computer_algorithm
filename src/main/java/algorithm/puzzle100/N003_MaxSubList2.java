/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */

/*
3.求子数组的最大和
题目：
输入一个整形数组，数组里有正数也有负数。
数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。
求所有子数组的和的最大值。要求时间复杂度为O(n)。

例如输入的数组为1, -2, 3, 10, -4, 7, 2, -5，和最大的子数组为3, 10, -4, 7, 2，
因此输出为该子数组的和18。
 */
package algorithm.puzzle100;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 */
public class N003_MaxSubList2 {
    private int m_max = Integer.MIN_VALUE;
    private LinkedList<int[]> m_idxList = new LinkedList<>();

    public void getSubList(int[] p_input) {
        //TODO CHECK INPUT

        int[] l_currentSum = {0, 0, 0};

        for (int l_i = 0; l_i < p_input.length; l_i++) {
            l_currentSum[0] += p_input[l_i];
            l_currentSum[2] = l_i;

            if (l_currentSum[0] > m_max) {
                m_max = l_currentSum[0];
                m_idxList.clear();

                int[] l_indices = new int[2];
                System.arraycopy(l_currentSum, 1, l_indices, 0, l_indices.length);
                m_idxList.add(l_indices);
            } else if (l_currentSum[0] == m_max) {
                int[] l_indices = new int[2];
                System.arraycopy(l_currentSum, 1, l_indices, 0, l_indices.length);
                m_idxList.add(l_indices);
            }

            if (l_currentSum[0] < 0) {
                l_currentSum[0] = 0;
                l_currentSum[1] = l_i + 1;
                l_currentSum[2] = l_i + 1;
            }
        }
    }

    @Test
    public void case1() {
        N003_MaxSubList2 l_msl = new N003_MaxSubList2();
        l_msl.getSubList(new int[] {1, -2, 3, 10, -4, 7, 2, -5});
        System.out.println(l_msl.m_max);
        for (int[] l_indices : l_msl.m_idxList) {
            System.out.println(Arrays.toString(l_indices));
        }

        l_msl = new N003_MaxSubList2();
        l_msl.getSubList(new int[] {1, -2, -3, -10, -4, -7, -2, -5});
        System.out.println(l_msl.m_max);
        for (int[] l_indices : l_msl.m_idxList) {
            System.out.println(Arrays.toString(l_indices));
        }

        l_msl = new N003_MaxSubList2();
        l_msl.getSubList(new int[] {-100, -2, -3, -10, -4, -7, -2, -5});
        System.out.println(l_msl.m_max);
        for (int[] l_indices : l_msl.m_idxList) {
            System.out.println(Arrays.toString(l_indices));
        }

        l_msl = new N003_MaxSubList2();
        l_msl.getSubList(new int[] {-1, -2, -3, -10, -4, -7, -2, -5});
        System.out.println(l_msl.m_max);
        for (int[] l_indices : l_msl.m_idxList) {
            System.out.println(Arrays.toString(l_indices));
        }

        l_msl = new N003_MaxSubList2();
        l_msl.getSubList(new int[] {100, 2, 3, 10, 4, 7, 2, 5});
        System.out.println(l_msl.m_max);
        for (int[] l_indices : l_msl.m_idxList) {
            System.out.println(Arrays.toString(l_indices));
        }
    }

}
