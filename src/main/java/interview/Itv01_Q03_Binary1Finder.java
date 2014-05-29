/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
package interview;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public class Itv01_Q03_Binary1Finder {

   public int find(long p_num) {
	int l_bOneCount = 0;
	
	long l_num = p_num > 0 ? p_num : -p_num;
	
	while(l_num != 0) {
	   l_num &= (l_num - 1);
	   
	   l_bOneCount ++;
	}
	
	return l_bOneCount;
   }
   
   @Test
   public void case1() {
	Assert.assertEquals(1, find(1));
	Assert.assertEquals(1, find(2));
	Assert.assertEquals(2, find(3));
	Assert.assertEquals(1, find(4));
	Assert.assertEquals(2, find(5));
	Assert.assertEquals(2, find(6));
	Assert.assertEquals(3, find(7));
	Assert.assertEquals(1, find(8));
	
	Assert.assertEquals(3, find(-7));
   }
   
}
