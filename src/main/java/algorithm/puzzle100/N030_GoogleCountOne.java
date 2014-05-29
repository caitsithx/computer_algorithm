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

豆沙：让问题回归复杂，接受任意input（d1,d2,d3,...,dn），那么这个结果可以分解为：
1) countOneByX9(dn-1, n-1);
2) （d1,d2,d3,...dn-1)个dn-1，判断dn-1是否等于1；
3）子问题input（d1,d2,d3,...dn-1)；

从外层循环来讲，时间复杂度是O(n)，相比逐个比较O(10^n)进步不小
 */
package algorithm.puzzle100;

import junit.framework.Assert;

import org.junit.Test;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public class N030_GoogleCountOne extends N030_GoogleCountOnebyRange{
   public long countOne(int[] p_inputByDigits, long p_inputVal){
	int l_count = 0;
	
	int l_leadingIdx = p_inputByDigits.length - 1;
	//99999 Max, the rest is from 100000 to p_input
	int l_leadingDigit = p_inputByDigits[l_leadingIdx];
	l_count += countOneByX9(l_leadingDigit - 1, l_leadingIdx);
	
	long l_remainVal = p_inputVal - 
		l_leadingDigit * (long)Math.pow(10, l_leadingIdx);
	
	l_count += (l_leadingDigit == 1 ? 1 : 0) * (l_remainVal + 1);
	
	int l_nextLeadingIdx = l_leadingIdx - 1;
	for (; l_nextLeadingIdx > -1 && p_inputByDigits[l_nextLeadingIdx] == 0; 
		l_nextLeadingIdx--) {
	   //find the next digit != 0
	}
	
	if(l_nextLeadingIdx != -1) {
	   int[] l_remainInputByDigits = new int[l_nextLeadingIdx + 1];
	   System.arraycopy(p_inputByDigits, 0, l_remainInputByDigits, 0, 
		   l_remainInputByDigits.length);
	   l_count += countOne(l_remainInputByDigits, l_remainVal);
	}
	
	return l_count;
   }
   
   @Test
   public void case1_N030_GoogleCountOne() {
	Assert.assertEquals(12, (countOne(new int[]{9, 1}, 19)));
	Assert.assertEquals(20, (countOne(new int[]{9, 9}, 99)));
	Assert.assertEquals(countOneBy9(3), (countOne(new int[]{9, 9, 9}, 999)));
	Assert.assertEquals(countOneBy9(4), (countOne(new int[]{9, 9, 9, 9}, 9999)));
	Assert.assertEquals(countOneByX9(1, 3), (countOne(new int[]{9, 9, 9, 1}, 1999)));
   }
}
