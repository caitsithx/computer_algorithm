/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */

/*
第12题
题目：求1+2+…+n，
要求不能使用乘除法、for、while、if、else、switch、case等关键字
以及条件判断语句（A?B:C）。

豆沙云：不让for就“尾递归”吧！这题的质量不高。
 */
package algorithm.puzzle100;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public class N012_FactorialCalculator {

   /**
    * @param p_n
    */
   public int calculate1(int p_n) {
	if(p_n == 0) {
	   return 0;
	}
	return p_n + calculate1(p_n - 1);
   }
   
   @Test
   public void case1() {
	N012_FactorialCalculator l_calculator = new N012_FactorialCalculator();
	
	Assert.assertEquals(55, l_calculator.calculate1(10));
   }
}
