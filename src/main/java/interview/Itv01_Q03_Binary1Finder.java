/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
package interview;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

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
	Assertions.assertEquals(1, find(1));
	Assertions.assertEquals(1, find(2));
	Assertions.assertEquals(2, find(3));
	Assertions.assertEquals(1, find(4));
	Assertions.assertEquals(2, find(5));
	Assertions.assertEquals(2, find(6));
	Assertions.assertEquals(3, find(7));
	Assertions.assertEquals(1, find(8));
	
	Assertions.assertEquals(3, find(-7));
   }
   
}
