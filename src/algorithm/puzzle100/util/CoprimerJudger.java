/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
package algorithm.puzzle100.util;

import org.junit.Test;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public class CoprimerJudger {

   public static boolean judge(long p_num1, long p_num2) {
	long l_max = p_num1, l_min = p_num2, l_tmp;
//	if(p_num1 > p_num2) {
//	   l_max = p_num1;
//	   l_min = p_num2;
//	} else {
//	   l_max = p_num2;
//	   l_min = p_num1;
//	}
	
	while (l_min != 0) {
	   l_tmp = l_min;
	   l_min = l_max % l_min;
	   l_max = l_tmp;
	}
	
	return l_max == 1;
   }
   
   @Test
   public void case1() {
	System.out.println(CoprimerJudger.judge(1000, 999));
	System.out.println(CoprimerJudger.judge(900, 600));
	System.out.println(CoprimerJudger.judge(200, 888));
	System.out.println(CoprimerJudger.judge(2, 3));
	System.out.println(CoprimerJudger.judge(11, 888));
   }
}
