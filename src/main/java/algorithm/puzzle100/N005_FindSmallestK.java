/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */

/*
5.查找最小的k个元素
题目：输入n个整数，输出其中最小的k个。
例如输入1，2，3，4，5，6，7和8这8个数字，则最小的4个数字为1，2，3和4。
 */
package algorithm.puzzle100;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public class N005_FindSmallestK {
   
   public int[] find(int[] p_inputs, int p_k) {
	int[] l_results = new int[p_k];
	l_results[p_k - 1] = p_inputs[0];
	int l_IdxOfMax = p_k - 1;
	for (int l_i = 1; l_i < p_inputs.length; l_i++) {
	   if(l_i < p_k) {
		if(l_results[l_IdxOfMax] < p_inputs[l_i]) {
		   l_results[l_i - 1] = l_results[l_IdxOfMax];
		   l_results[l_IdxOfMax] = p_inputs[l_i];
		} else {
		   l_results[l_i - 1] = p_inputs[l_i];
		}
	   } else {
		if(l_results[l_IdxOfMax] > p_inputs[l_i]) {
		   l_results[l_IdxOfMax] = p_inputs[l_i];
		   
		   int l_tmp = 0;
		   for (int l_i2 = 0; l_i2 < l_IdxOfMax; l_i2++) {
			if(l_results[l_i2] > l_results[l_IdxOfMax]) {
			   l_tmp = l_results[l_IdxOfMax];
			   l_results[l_IdxOfMax] = l_results[l_i2];
			   l_results[l_i2] = l_tmp;
			}
		   }
		}
	   }
	}
	
	return l_results;
   }
   
   @Test
   public void case1() {
	N005_FindSmallestK finder = new N005_FindSmallestK();
	int[] l_results = finder.find(new int[] {100, 2, 3, 4, 1, 90, 8, 2, 10, 22, 3, 1111, 99, 31}, 5);
	System.out.println(Arrays.toString(l_results));
	
	l_results = finder.find(new int[] {1, 2, 0}, 2);
	System.out.println(Arrays.toString(l_results));
	
	l_results = finder.find(new int[] {1, 2, 0}, 3);
	System.out.println(Arrays.toString(l_results));
   }

}
