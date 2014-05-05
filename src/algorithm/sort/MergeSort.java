/*
 * Copyright (c) 2012 caitsithx - All rights reserved.
 *
 */
package algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public class MergeSort {

   public void sort(int[] p_array) {
	//check input!

	int[] l_tmp = new int[p_array.length];

	sort(p_array, l_tmp, 0, p_array.length - 1);
   }

   /**
    * @param p_array
    * @param p_tmp
    * @param p_left 
    * @param p_right 
    */
   private void sort(int[] p_array, int[] p_tmp, int p_left, int p_right) {
	int l_middle = (p_left + p_right + 1) / 2;
	if(p_left == p_right) {
	   return;
	} else if(p_left < p_right - 1) {
	   sort(p_array, p_tmp, p_left, l_middle);
	   sort(p_array, p_tmp, l_middle, p_right);	   
	}

	merge(p_array, p_tmp, p_left, l_middle, p_right);
   }

   /**
    * @param p_array
    * @param p_tmp 
    * @param p_left
    * @param p_middle
    * @param p_right
    */
   private void merge(int[] p_array, int[] p_tmp, int p_left, int p_middle, int p_right) {
	int l_idx1 = p_left;
	int l_idx2 = p_middle;
	int l_idx3 = p_left;

	while(l_idx1 < p_middle && l_idx2 <= p_right) {
	   if(p_array[l_idx1] > p_array[l_idx2]) {
		p_tmp[l_idx3++] = p_array[l_idx2++];
	   } else {
		p_tmp[l_idx3++] = p_array[l_idx1++];
	   }
	}

	while(l_idx1 < p_middle) {
	   p_tmp[l_idx3++] = p_array[l_idx1++];
	}

	while(l_idx2 <= p_right) {
	   p_tmp[l_idx3++] = p_array[l_idx2++];
	}

	System.arraycopy(p_tmp, p_left, p_array, p_left, p_right - p_left + 1);
   }

   @Test
   public void case1() {
	int[] l_array = {1, 2, 3, 1, 3, 7};
	int[] l_tmp = new int[l_array.length];
	merge(l_array, l_tmp, 0, (l_array.length)/ 2, l_array.length - 1);

	Assert.assertArrayEquals(new int[]{1, 1, 2, 3, 3, 7}, l_array);
   }

   @Test
   public void case2() {
	int[] l_array = {1, 2, 3, 1, 3, 7};
	sort(l_array);

	Assert.assertArrayEquals(new int[]{1, 1, 2, 3, 3, 7}, l_array);
	
	l_array = new int[]{1, 2, 3, 1, 3, 7, 0};
	sort(l_array);

	Assert.assertArrayEquals(new int[]{0, 1, 1, 2, 3, 3, 7}, l_array);
	
	l_array = new int[]{0};
	sort(l_array);

	Assert.assertArrayEquals(new int[]{0}, l_array);
   }
}
