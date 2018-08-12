/*
 * Copyright (c) 2012 caitsithx - All rights reserved.
 *
 */
package algorithm.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public class QuickSort {

   private int median3(int[] p_array, int p_left, int p_middle, int p_right) {
	if(p_array[p_left] > p_array[p_middle]) {
	   swap(p_array, p_left, p_middle);
	}
	if(p_array[p_left] > p_array[p_right]) {
	   swap(p_array, p_left, p_right);
	}
	if(p_array[p_middle] > p_array[p_right]) {
	   swap(p_array, p_middle, p_right);
	}
	
	return p_array[p_middle];
   }
   
   public void sort(int[] p_array) {
	sort(p_array, 0, p_array.length - 1);
   }

   /**
    * @param p_array
    * @param p_left
    * @param p_right
    */
   private void sort(int[] p_array, int p_left, int p_right) {
	if(p_left == p_right) {
	   return;
	} else if(p_left == p_right - 1) {
	   if(p_array[p_left] > p_array[p_right]) {
		swap(p_array, p_left, p_right);
	   }
	   
	   return;
	}
	
	int l_middle = (p_left + p_right + 1) / 2;
	int l_pivot = median3(p_array, p_left, l_middle, p_right);
	swap(p_array, l_middle, p_right - 1);
	
	int l_idx1 = p_left;
	int l_idx2 = p_right - 1;
	
	for(;;) {
	   while(p_array[++l_idx1] < l_pivot) {}
	   while(p_array[--l_idx2] > l_pivot) {}
	   
	   if(l_idx1 < l_idx2) {
		swap(p_array, l_idx1, l_idx2);
	   } else {
		break;
	   }
	}
	
	swap(p_array, l_idx1, p_right - 1);
	
	if(p_left < l_idx1 - 1) {
	   sort(p_array, p_left, l_idx1 - 1);
	}
	
	if(l_idx1 + 1 < p_right) {
	   sort(p_array, l_idx1 + 1, p_right);
	}
   }

   /**
    * @param p_array
    * @param p_idx1
    * @param p_idx2
    */
   private void swap(int[] p_array, int p_idx1, int p_idx2) {
	int l_tmp = p_array[p_idx1];
	p_array[p_idx1] = p_array[p_idx2];
	p_array[p_idx2] = l_tmp;
   }
   
   @Test
   public void case1() {
	int[] l_input = {1, 2, 3, 4, 5, 6};
	Assertions.assertEquals(4, median3(l_input, 0, (l_input.length) / 2, l_input.length - 1));
   }
   
   @Test
   public void case2() {
	int[] l_array = {1, 2, 3, 1, 3, 7};
	sort(l_array);

	Assertions.assertArrayEquals(new int[]{1, 1, 2, 3, 3, 7}, l_array);
	
	l_array = new int[]{1, 2, 3, 1, 3, 7, 0};
	sort(l_array);

	Assertions.assertArrayEquals(new int[]{0, 1, 1, 2, 3, 3, 7}, l_array);
	
	l_array = new int[]{0};
	sort(l_array);

	Assertions.assertArrayEquals(new int[]{0}, l_array);
	
	l_array = new int[]{0, 3, 1};
	sort(l_array);

	Assertions.assertArrayEquals(new int[]{0, 1, 3}, l_array);
   }
}
