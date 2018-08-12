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
 */
package algorithm.puzzle100;

import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public class N030_GoogleCountOneBad {

   public long countOne(int[] p_input){
	int l_maxIdx = p_input.length - 1;
	int[] l_dict = new int[] {0, 1, 1, 1, 1, 1, 1, 1, 1, 1};
	
	long l_count = 0;
	int l_1Before = 0;
	for (int l_i = l_maxIdx; l_i >= 1; l_i--) {
	   l_count += l_dict[p_input[l_i] - 1] * (long)Math.pow(10, l_i - 1);
	   l_count += (l_i - 1) * (l_dict[9] * (long)Math.pow(10, l_i - 2) * (p_input[l_i] - 1));
	   
	   l_count += l_1Before * p_input[l_i] * (long)Math.pow(10, l_i - 1);
	   
	   l_1Before += (p_input[l_i] == 1 ? 1 : 0);
	}
	
	return l_count;
   }
   
   @Test
   public void case1() {
	System.out.println(countOne(new int[]{0, 1, 0}));
   }
}
