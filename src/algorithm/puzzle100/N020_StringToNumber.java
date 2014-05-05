/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
/*
 第20题：
 题目：输入一个表示整数的字符串，把该字符串转换成整数并输出。
 例如输入字符串"345"，则输出整数345。
 */
package algorithm.puzzle100;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 * 
 */
public class N020_StringToNumber {
   public long transform(char[] p_chars) {
	long l_sum = 0;

	if (p_chars[0] == '-' || p_chars[0] == '+') {
	   //
	} else {
	   checkChar(p_chars[0]);
	   l_sum = p_chars[0] - '0';
	}

	for (int l_i = 1; l_i < p_chars.length; l_i++) {
	   checkChar(p_chars[l_i]);
	   l_sum = (p_chars[l_i] - '0') + l_sum * 10;
	}

	if (p_chars[0] == '-') {
	   l_sum = -l_sum;
	}

	return l_sum;
   }

   private void checkChar(char p_char) {
	if (p_char < '0' || p_char > '9') {
	   throw new IllegalArgumentException();
	}
   }

   @SuppressWarnings("nls")
   @Test
   public void case1() {
	N020_StringToNumber l_transform = new N020_StringToNumber();
	System.out.println(l_transform.transform("12345".toCharArray()));

	System.out.println(l_transform.transform("12345222".toCharArray()));

	System.out.println(l_transform.transform("-12345222".toCharArray()));
	System.out.println(l_transform.transform("+12345222".toCharArray()));

	IllegalArgumentException l_ex = null;
	try {
	   l_transform.transform("a12345".toCharArray());
	} catch (IllegalArgumentException l_ex1) {
	   l_ex = l_ex1;
	}

	Assert.assertNotNull(l_ex);
   }
}
