/*
 * Copyright (c) 2012 caitsithx - All rights reserved.
 *
 */
package algorithm.ms.itv.book;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public class N002_CakeSwap {
   private int[] m_indices = null;
   private int m_top = -1;
   private int m_swapCount = 0;
   
   public void swapCleverly(int[] p_cakes) {
	m_indices = new int[p_cakes.length];
	m_top = m_indices.length - 1;
	m_swapCount = 0;
	
	//init
	for (int l_i = 0; l_i < m_indices.length; l_i++) {
	   m_indices[p_cakes[l_i]] = l_i;
	}
	
	int l_current = m_top;
	while(l_current > 0) {
	   if(m_indices[l_current] != m_top - l_current) {
		int l_end = detectAsendingBlock(l_current);
		
		if(l_end == m_indices.length) {
		   if(m_indices[l_current] != m_top) {
			swapUpAndDown(p_cakes, m_indices[l_current]);
		   } else {
			swapDown(p_cakes);
		   }
		} else {
		   swapBlock(p_cakes, l_end, l_current);
		}
	   }
	   l_current --;
	}
   }
   
   public void swapOneByOne(int[] p_cakes) {
	m_indices = new int[p_cakes.length];
	m_top = m_indices.length - 1;
	m_swapCount = 0;
	
	//init
	for (int l_i = 0; l_i < m_indices.length; l_i++) {
	   m_indices[p_cakes[l_i]] = l_i;
	}

	int l_current = m_top;
	while(l_current > 0) {
	   if(m_indices[l_current] != m_top - l_current) {
		if(m_indices[l_current] != m_top) {
		   swapUpAndDown(p_cakes, m_indices[l_current]);
		} else {
		   swapDown(p_cakes);
		}
	   }
	   l_current --;
	}
   }
   
   /**
    * @param p_cakes
    * @param p_end
    * @param p_current
    */
   private void swapBlock(int[] p_cakes, int p_end, int p_current) {
	swap(p_cakes, m_indices[p_end], m_top);
	//update indices
	for (int l_i = p_end; l_i <= m_top; l_i++) {
	   m_indices[p_cakes[l_i]] = l_i;
	}
	
	int l_idx = m_indices[p_current];
	swap(p_cakes, l_idx, m_top);
	//update indices
	for (int l_i = l_idx; l_i <= m_top; l_i++) {
	   m_indices[p_cakes[l_i]] = l_i;
	}
	
	int l_dest = m_top - p_cakes[m_top];
	swap(p_cakes, l_dest, m_top);
	//update indices
	for (int l_i = l_dest; l_i <= m_top; l_i++) {
	   m_indices[p_cakes[l_i]] = l_i;
	}
   }
   
   /**
    * @param p_current
    * @return
    */
   private int detectAsendingBlock(int p_current) {
	int l_i = p_current;
	
	boolean l_asending = false;
	if(m_indices[l_i - 1] == (m_indices[l_i] - 1)) {
	   l_asending = true;
	} /*else if(m_indices[l_i - 1] == (m_indices[l_i] + 1)) {
	   l_asending = false;
	} */else {
	   return m_indices.length;
	}
	
	for (; l_i >=1; l_i--) {
	   if(/*l_asending && */m_indices[l_i - 1] != (m_indices[l_i] - 1)) {
		break;
	   } /*else if(!l_asending && m_indices[l_i - 1] != (m_indices[l_i] + 1)) {
		break;
	   }*/
	}
	
	return p_current - l_i > 0 ? l_i : m_indices.length;
   }

   /**
    * @param p_cakes
    */
   private void swapDown(int[] p_cakes) {
	int l_dest = m_top - p_cakes[m_top];
	swap(p_cakes, l_dest, m_top);	
	
	//update indices
	for (int l_i = l_dest; l_i <= m_top; l_i++) {
	   m_indices[p_cakes[l_i]] = l_i;
	}
   }

   /**
    * @param p_cakes
    * @param p_i
    */
   private void swapUpAndDown(int[] p_cakes, int p_current) {
	int l_dest = m_top - p_cakes[p_current];
	
	swap(p_cakes, p_current, m_top);
	swap(p_cakes, l_dest, m_top);
	
	//update indices
	for (int l_i = l_dest; l_i <= m_top; l_i++) {
	   m_indices[p_cakes[l_i]] = l_i;
	}
   }

   /**
    * @param p_cakes
    * @param p_i
    * @param p_top
    */
   private void swap(int[] p_cakes, int p_current, int p_top) {
	//swap
	for(int l_i = p_current, l_j = p_top; l_i < l_j; l_i ++, l_j --) {
	   int l_tmp = p_cakes[l_i];
	   p_cakes[l_i] = p_cakes[l_j];
	   p_cakes[l_j] = l_tmp;
	}
	
	m_swapCount ++;
	System.out.println(Arrays.toString(p_cakes));
   }
   
//   @Test
   public void case1() {
	N002_CakeSwap l_swaper = new N002_CakeSwap();
	int[] l_cakes = null;
	l_cakes = new int[]{0, 2, 1};
	l_swaper.swapOneByOne(l_cakes);
	System.out.println("swap count: " + l_swaper.m_swapCount);
	System.out.println(Arrays.toString(l_cakes));
	
	l_cakes = new int[]{0, 2, 1, 3, 4};
	l_swaper.swapOneByOne(l_cakes);
	System.out.println("swap count: " + l_swaper.m_swapCount);
	System.out.println(Arrays.toString(l_cakes));
	
	
	l_cakes = new int[]{0, 2, 1, 3, 4, 5, 6, 7};
	l_swaper.swapOneByOne(l_cakes);
	System.out.println("swap count: " + l_swaper.m_swapCount);
	System.out.println(Arrays.toString(l_cakes));
	
	l_cakes = new int[]{0, 2, 1, 3, 4, 7, 6, 5};
	l_swaper.swapOneByOne(l_cakes);
	System.out.println("swap count: " + l_swaper.m_swapCount);
	System.out.println(Arrays.toString(l_cakes));
	
	l_cakes = new int[]{0, 2, 1, 8, 3, 7, 6, 5, 4};
	l_swaper.swapOneByOne(l_cakes);
	System.out.println("swap count: " + l_swaper.m_swapCount);
	System.out.println(Arrays.toString(l_cakes));
   }
   
   @Test
   public void case2() {
	N002_CakeSwap l_swaper = new N002_CakeSwap();
	int[] l_cakes = null;
//	l_cakes = new int[]{0, 2, 1};
//	l_swaper.swapCleverly(l_cakes);
//	System.out.println("swap count: " + l_swaper.m_swapCount);
//	System.out.println(Arrays.toString(l_cakes));
//	
//	l_cakes = new int[]{0, 2, 1, 3, 4};
//	l_swaper.swapCleverly(l_cakes);
//	System.out.println("swap count: " + l_swaper.m_swapCount);
//	System.out.println(Arrays.toString(l_cakes));
//	
//	
//	l_cakes = new int[]{0, 2, 1, 3, 4, 5, 6, 7};
//	l_swaper.swapCleverly(l_cakes);
//	System.out.println("swap count: " + l_swaper.m_swapCount);
//	System.out.println(Arrays.toString(l_cakes));
	
//	l_cakes = new int[]{0, 2, 1, 5, 6, 7, 3, 4};
//	l_swaper.swapCleverly(l_cakes);
//	System.out.println("swap count: " + l_swaper.m_swapCount);
//	System.out.println(Arrays.toString(l_cakes));
//	System.out.println();
	
//	l_cakes = new int[]{0, 2, 1, 5, 6, 7, 3, 4};
//	l_swaper.swapOneByOne(l_cakes);
//	System.out.println("swap count: " + l_swaper.m_swapCount);
//	System.out.println(Arrays.toString(l_cakes));
//	
//	l_cakes = new int[]{0, 2, 1, 8, 3, 7, 6, 5, 4};
//	l_swaper.swapOneByOne(l_cakes);
//	System.out.println("swap count: " + l_swaper.m_swapCount);
//	System.out.println(Arrays.toString(l_cakes));
	
	l_cakes = new int[]{6, 4, 2, 3, 1, 5, 0, 7};
	l_swaper.swapCleverly(l_cakes);
	System.out.println("swap count: " + l_swaper.m_swapCount);
	System.out.println(Arrays.toString(l_cakes));
	System.out.println();
	
	l_cakes = new int[]{6, 4, 2, 3, 1, 5, 0, 7};
	l_swaper.swapOneByOne(l_cakes);
	System.out.println("swap count: " + l_swaper.m_swapCount);
	System.out.println(Arrays.toString(l_cakes));
	System.out.println();
   }
}
