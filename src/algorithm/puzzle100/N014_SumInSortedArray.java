/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
/*
第14题：
题目：输入一个已经按升序排序过的数组和一个数字，
在数组中查找两个数，使得它们的和正好是输入的那个数字。
要求时间复杂度是O(n)。如果有多对数字的和等于输入的数字，输出任意一对即可。
例如输入数组1、2、4、7、11、15和数字15。由于4+11=15，因此输出4和11。
 */
package algorithm.puzzle100;

import org.junit.Test;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public class N014_SumInSortedArray {

   public void findTwoNumbers(int[] p_inputs, int p_sum) {
	int l_begin = 0;
	int l_end = p_inputs.length - 1;
	
	int l_sum = 0;
	while(l_begin < l_end) {
	   l_sum = p_inputs[l_begin] + p_inputs[l_end];
	   if(p_sum == l_sum) {
		System.out.println(l_begin + ":" + l_end);
		l_begin ++;
		l_end --;
	   } else if(l_sum < p_sum) {
		l_begin ++;
	   } else {
		l_end --;
	   }
	}
   }
   
   @Test
   public void case1() {
	int[] l_inputs = new int[]{1, 2, 4, 7, 11, 15};
	int l_sum = 15;
	
	N014_SumInSortedArray l_finder = new N014_SumInSortedArray();
	l_finder.findTwoNumbers(l_inputs, l_sum);
	
	System.out.println();
   }
   
   @Test
   public void case2() {
	int[] l_inputs = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	int l_sum = 9;
	
	N014_SumInSortedArray l_finder = new N014_SumInSortedArray();
	l_finder.findTwoNumbers(l_inputs, l_sum);
	
	System.out.println();
   }
}
