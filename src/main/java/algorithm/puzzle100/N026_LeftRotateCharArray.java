/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */

/*
 26.左旋转字符串
 题目：
 定义字符串的左旋转操作：把字符串前面的若干个字符移动到字符串的尾部。
 如把字符串abcdef左旋转2位得到字符串cdefab。请实现字符串左旋转的函数。
 要求时间对长度为n的字符串操作的复杂度为O(n)，辅助内存为O(1)。
 */
package algorithm.puzzle100;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 * 
 */
public class N026_LeftRotateCharArray {

   public void leftRotate(Character[] p_inputs, int p_space) {
	int l_realLen = p_inputs.length - 1;
	int l_realSp = p_space % l_realLen;
	
	int l_start = 1;
	int l_current = l_start;
	
	Character l_tmpForSwap = p_inputs[l_current];
	p_inputs[l_current] = null;
	for (int l_i = 0; l_i < l_realLen; l_i++) {
	   int l_next = l_current - l_realSp;
	   if(l_next <= 0) {
		l_next = l_realLen + l_next;
	   }
	   
	   if(l_next == 0) {
		throw new IllegalStateException();
	   }
	   
	   if(p_inputs[l_next] != null) {
		p_inputs[l_start] = p_inputs[l_next];
		p_inputs[l_next] = l_tmpForSwap;
		l_tmpForSwap = p_inputs[l_start];
		p_inputs[l_start] = null;
		l_current = l_next;
	   } else {
		p_inputs[l_next] = l_tmpForSwap;
		if(l_start < p_space && l_i < l_realLen - 1) {
		   l_start ++;
		   l_current = l_start;
		   l_tmpForSwap = p_inputs[l_current];
		   p_inputs[l_current] = null;
		}
	   }
	}
   }
   
   @Test
   public void case1() {
	Character[] l_inputs = new Character[]{null, 'a', 'b', 'c', 'd', '1', '2', '3', '4'};
	leftRotate(l_inputs, 4);
	
	Assert.assertArrayEquals(new Character[]{null, '1', '2', '3', '4', 'a', 'b', 'c', 'd'}, 
		l_inputs);
   }
   
   @Test
   public void case2() {
	Character[] l_inputs = new Character[]{null, 'a', 'b', 'c', 'd', '1', '2', '3', '4'};
	leftRotate(l_inputs, 3);
	
	Assert.assertArrayEquals(new Character[]{null, 'd', '1', '2', '3', '4', 'a', 'b', 'c'}, 
		l_inputs);
   }
   
   @Test
   public void case3() {
	Character[] l_inputs = new Character[]{null, 'a', 'b', 'c', 'd', '1', '2', '3', '4'};
	leftRotate(l_inputs, 13);
	
	Assert.assertArrayEquals(new Character[]{null, '2', '3', '4', 'a', 'b', 'c', 'd', '1'}, 
		l_inputs);
   }
}
