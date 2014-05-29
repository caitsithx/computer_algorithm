/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
package algorithm.puzzle100;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public class N026_LeftRotate3Swaps {

   public void rotate(char[] p_inputs, int p_space) {
//	int l_realLen = p_inputs.length - 1;
	int l_realSp = p_space % p_inputs.length;
	
	rotate(p_inputs, 0, l_realSp - 1);
	rotate(p_inputs, l_realSp, p_inputs.length - 1);
	
	rotate(p_inputs, 0, p_inputs.length - 1);
   }
   
   public void rotate(char[] p_inputs, int p_start, int p_end) {
	char l_tmp;
	
	for(int l_start = p_start, l_end = p_end; l_start < l_end; l_start++, l_end --) {
	   l_tmp = p_inputs[l_start];
	   p_inputs[l_start] = p_inputs[l_end];
	   p_inputs[l_end] = l_tmp;
	}
   }
   
   @Test
   public void case1() {
	char[] l_inputs = new char[]{'a', 'b', 'c', 'd', '1', '2', '3', '4'};
	rotate(l_inputs, 4);
	
	Assert.assertArrayEquals(new char[]{'1', '2', '3', '4', 'a', 'b', 'c', 'd'}, l_inputs);
   }
   
   @Test
   public void case2() {
	char[] l_inputs = new char[]{'a', 'b', 'c', 'd', '1', '2', '3', '4'};
	rotate(l_inputs, 3);
	
	Assert.assertArrayEquals(new char[]{'d', '1', '2', '3', '4', 'a', 'b', 'c'}, 
		l_inputs);
   }
   
   @Test
   public void case3() {
	char[] l_inputs = new char[]{'a', 'b', 'c', 'd', '1', '2', '3', '4'};
	rotate(l_inputs, 13);
	
	Assert.assertArrayEquals(new char[]{'2', '3', '4', 'a', 'b', 'c', 'd', '1'}, 
		l_inputs);
   }
}
