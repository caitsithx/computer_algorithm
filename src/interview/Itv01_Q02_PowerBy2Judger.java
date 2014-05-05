/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
package interview;

import junit.framework.Assert;

import org.junit.Test;

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
	Assert.assertTrue(judge(-1));
	Assert.assertTrue(judge(1));
	Assert.assertTrue(judge(2));
	Assert.assertTrue(judge(4));
	Assert.assertTrue(judge(8));
	Assert.assertTrue(judge(16));
	Assert.assertTrue(judge(32));
	
	Assert.assertFalse(judge(3));
	Assert.assertFalse(judge(6));
	Assert.assertFalse(judge(7));
   }
}