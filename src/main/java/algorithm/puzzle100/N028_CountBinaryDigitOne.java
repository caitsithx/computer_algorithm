/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */

/*
28.整数的二进制表示中1的个数（运算）
题目：输入一个整数，求该整数的二进制表达中有多少个1。
例如输入10，由于其二进制表示为1010，有两个1，因此输出2。
分析：
这是一道很基本的考查位运算的面试题。
包括微软在内的很多公司都曾采用过这道题。
 */
package algorithm.puzzle100;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public class N028_CountBinaryDigitOne {

   public int count(int p_input) {
	int l_count = 0;
	int l_tmp = p_input < 0 ? -p_input : p_input;

	while(l_tmp != 0) {
	   if((l_tmp & 0x01) == 0x01) {
		l_count ++;
	   }

	   l_tmp >>>= 1;//CAREFUL: >> is right shift with sign bit!
	}
	
	return l_count;
   }

   @Test
   public void case1() {
	Assertions.assertEquals(1, count(-1));
	Assertions.assertEquals(1, count(1));
	Assertions.assertEquals(1, count(2));
	Assertions.assertEquals(1, count(4));
	Assertions.assertEquals(1, count(8));
   }
   
   @Test
   public void case2() {
	Assertions.assertEquals(2, count(3));
	Assertions.assertEquals(2, count(6));
	Assertions.assertEquals(2, count(12));
	Assertions.assertEquals(2, count(24));
   }
}
