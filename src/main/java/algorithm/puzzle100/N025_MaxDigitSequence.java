/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */

/*
第25题：
写一个函数,它的原形是int continumax(char *outputstr,char *intputstr)
功能：
在字符串中找出连续最长的数字串，并把这个串的长度返回，
并把这个最长数字串付给其中一个函数参数outputstr所指内存。
例如："abcd12345ed125ss123456789"的首地址传给intputstr后，函数将返回9，
outputstr所指的值为123456789
 */
package algorithm.puzzle100;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public class N025_MaxDigitSequence {

   public char[] find(char[] p_inputs) {
	char[] l_result = null;
	int l_maxCount = 0;
	int l_lastCharIdx = 0;
	int l_count = 0;
	
	for (int l_i = 0; l_i < p_inputs.length; l_i++) {
	   if(p_inputs[l_i] >= '0' && p_inputs[l_i] <= '9') {
		l_count ++;
		if(l_count > l_maxCount) {
		   l_maxCount = l_count;
		   l_lastCharIdx = l_i;
		}
	   } else {
		l_count = 0;
	   }
	}
	
	if(l_maxCount > 0) {
	   l_result = new char[l_maxCount];
	   System.arraycopy(p_inputs, l_lastCharIdx - l_maxCount + 1, l_result, 0, l_maxCount);
	}
	
	return l_result;
   }
   
   @Test
   public void case1() {
	N025_MaxDigitSequence l_finder = new N025_MaxDigitSequence();
	char[] l_result = l_finder.find(new char[]{'a', 'b', 'c', 'v', '1', '2', '3', '4', '5', 
		's', 's', 'e', 'w', '5', '4', '5', '4', '6', '4', '7', '7', '7', 's', 'd', 's', '1', 
		'2', '2'});
	
	Assertions.assertArrayEquals(new char[]{'5', '4', '5', '4', '6', '4', '7', '7', '7'}, l_result);
   }
}
