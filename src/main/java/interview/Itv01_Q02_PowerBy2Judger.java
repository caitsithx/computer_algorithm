/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
package interview;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public class Itv01_Q02_PowerBy2Judger{ 


   public boolean judge(int p_num) {
	int l_num = p_num > 0 ? p_num : -p_num;
	return (l_num & (l_num - 1)) == 0;
   }


   @Test
   public void case1() {
	Assertions.assertTrue(judge(-1));
	Assertions.assertTrue(judge(1));
	Assertions.assertTrue(judge(2));
	Assertions.assertTrue(judge(4));
	Assertions.assertTrue(judge(8));
	Assertions.assertTrue(judge(16));
	Assertions.assertTrue(judge(32));
	
	Assertions.assertFalse(judge(3));
	Assertions.assertFalse(judge(6));
	Assertions.assertFalse(judge(7));
   }
}