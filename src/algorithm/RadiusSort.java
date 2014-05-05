/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
package algorithm;

import java.util.ArrayList;

import org.junit.Test;

import algorithm.util.MathUtil;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public class RadiusSort {
//   private int getDigit(int p_input, int p_radius, int p_idx) {
//	return (p_input / ((int)Math.pow(p_radius, p_idx))) % p_radius;
//   }

   public void sort(Integer[] p_inputs, int p_maxDigits, int p_radius) {
	ArrayList[] l_buf = new ArrayList[p_radius + 1];
	
	for (int l_i = 0; l_i < p_inputs.length; l_i++) {
	   int l_idx = (int)MathUtil.getDigit(p_inputs[l_i], p_radius, p_maxDigits);
	   
	   if(l_buf[l_idx] == null) {
		l_buf[l_idx] = new ArrayList<Integer>();
	   }
	   l_buf[l_idx].add(p_inputs[l_i]);
	}
	
	for (int l_i = 0; l_i < l_buf.length; l_i++) {
	   if(l_buf[l_i] != null) {
		int l_bufSize = l_buf[l_i].size();
		if(l_bufSize == 1) {
		   System.out.println(l_buf[l_i].get(0));
		} else {
		   Integer[] l_subInputs = new Integer[l_bufSize];
		   ((ArrayList<Integer>)l_buf[l_i]).toArray(l_subInputs);
		   sort(l_subInputs, p_maxDigits - 1, p_radius);
		}
	   }
	}
   }
   
   @Test
   public void case1() {
	RadiusSort l_sorter = new RadiusSort();
	l_sorter.sort(new Integer[]{1, 4, 55, 63, 999, 245, 123, 44, 22, 33}, 
		3, 10);
   }
   
   @Test
   public void case2() {
	RadiusSort l_sorter = new RadiusSort();
	l_sorter.sort(new Integer[]{4, 8, 15, 64, 256, 1023, 453, 44, 23, 546, 1024}, 
		5, 4);
   }
}
