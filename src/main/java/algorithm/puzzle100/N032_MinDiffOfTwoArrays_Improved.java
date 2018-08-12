/*
 * Copyright (c) 2012 caitsithx - All rights reserved.
 *
 */
package algorithm.puzzle100;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import adt.ArrayBasedStack;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public class N032_MinDiffOfTwoArrays_Improved {
   class IntArray {
	int[] im_values;
	int m_sum;

	void init() {
	   if(im_values != null) {
		m_sum = sum(im_values);
	   } else {
		m_sum = 0;
	   }
	}

	void set(int p_idx, int p_val) {
	   m_sum += (p_val - im_values[p_idx]);
	   im_values[p_idx] = p_val;
	}

	void remove(int p_idx) {
	   m_sum -= im_values[p_idx];
	   im_values[p_idx] = 0;
	}
   }

   //   private int[][][] m_results = new int[1000][][];
   private HashMap<Integer, int[][]> m_results = new HashMap<Integer, int[][]>();
   private ArrayBasedStack<Integer> m_stack = new ArrayBasedStack<>(1000);
   private int m_minDiff = -1;

   public void split(int[] p_sortedAllNon0) {
	IntArray l_sortedNon0 = new IntArray();
	l_sortedNon0.im_values = p_sortedAllNon0;
	l_sortedNon0.init();

	IntArray l_maxHalf = new IntArray();
	l_maxHalf.im_values = new int[p_sortedAllNon0.length / 2];
	l_sortedNon0.init();

	int l_maxIdx = l_maxHalf.im_values.length - 1;

	for (int l_i = p_sortedAllNon0.length - 1; l_i >= p_sortedAllNon0.length / 2; l_i--) {
	   if(l_maxIdx <= l_i) {
		l_maxHalf.set(l_maxIdx, p_sortedAllNon0[l_i]);
		m_stack.push(p_sortedAllNon0[l_i]);
		l_sortedNon0.remove(l_i);

		func(l_sortedNon0, l_i - 1, l_maxHalf, l_maxIdx - 1);

		l_sortedNon0.set(l_i, m_stack.pop());
	   } else {
		// can't to build a max sub array
		break;
	   }
	}
   }

   /**
    * @param p_sortedNon0
    * @param p_sortedAllMaxIdx
    * @param p_maxHalf
    * @param p_maxIdx
    */
   private void func(IntArray p_sortedNon0, int p_sortedAllMaxIdx, IntArray p_maxHalf,
	   int p_maxIdx) {
	int l_maxIdx = p_maxIdx;
	if(l_maxIdx == -1) {
	   int l_diff = p_maxHalf.m_sum - p_sortedNon0.m_sum;
	   if(l_diff >= 0) {
		int[][] l_twoArrays = new int[2][];

		l_twoArrays[0] = getMinArray(p_sortedNon0.im_values);
		l_twoArrays[1] = new int[p_maxHalf.im_values.length];
		System.arraycopy(p_maxHalf.im_values, 0, l_twoArrays[1], 0, l_twoArrays[1].length);

		if(m_results.size() == 0) {
		   m_minDiff = l_diff;
		} else {
		   if(m_minDiff > l_diff) {
			m_minDiff = l_diff;
		   }
		}

		m_results.put(l_diff, l_twoArrays);
	   }

	   return;
	}


	//if the max array is enough larger, accelerate the filling with all smallests.
	if(p_maxHalf.m_sum >= p_sortedNon0.m_sum) {
	   if(l_maxIdx <= p_sortedAllMaxIdx) {
		for (int l_i = 0; l_i <= l_maxIdx; l_i++) {
		   p_maxHalf.set(l_i, p_sortedNon0.im_values[l_i]);
		   m_stack.push(p_sortedNon0.im_values[l_i]);
		   p_sortedNon0.remove(l_i);
		}

		func(p_sortedNon0, -1, p_maxHalf, - 1);

		for (int l_i = l_maxIdx; l_i >= 0; l_i--) {
		   p_sortedNon0.set(l_i, m_stack.pop());
		}
	   }
	}
	//else recusiving from the large to the small. 
	else {
	   for (int l_i = p_sortedAllMaxIdx; l_i >= 0; l_i--) {
		if(l_maxIdx <= l_i) {
		   p_maxHalf.set(l_maxIdx, p_sortedNon0.im_values[l_i]);
		   m_stack.push(p_sortedNon0.im_values[l_i]);
		   p_sortedNon0.remove(l_i);

		   func(p_sortedNon0, l_i - 1, p_maxHalf, l_maxIdx - 1);

		   p_sortedNon0.set(l_i, m_stack.pop());
		} else {
		   //failed to build a max sub array
		   break;
		}
	   }
	}
   }

   /**
    * @param p_sortedAllNon0
    * @return
    */
   private int[] getMinArray(int[] p_sortedAllNon0) {
	int[] l_minArray = new int[p_sortedAllNon0.length / 2];

	int l_sortedIdx = 0;
	System.err.println("find Min Array: " + Arrays.toString(p_sortedAllNon0));
	for (int l_i = 0; l_i < l_minArray.length; l_i++, l_sortedIdx++) {
	   while(p_sortedAllNon0[l_sortedIdx] == 0) {
		l_sortedIdx ++;
	   }

	   l_minArray[l_i] = p_sortedAllNon0[l_sortedIdx];
	}

	return l_minArray;
   }

   /**
    * @param p_maxHalf
    * @return
    */
   int sum(int[] p_maxHalf) {
	int l_sum = 0;

	for (int l_i = 0; l_i < p_maxHalf.length; l_i++) {
	   l_sum += p_maxHalf[l_i];
	}

	return l_sum;
   }

   @Test
   public void case1() {
	int[] l_inputs = null;
	l_inputs = new int[]{1, 2, 3, 4, 10, 15, 20, 90, 100, 105};

	split(l_inputs);

	System.out.println("Min Diff: " + m_minDiff);
	System.out.println("Min Array: " + Arrays.toString(m_results.get(m_minDiff)[0]));
	System.out.println("Max Array: " + Arrays.toString(m_results.get(m_minDiff)[1]));
   }

   @Test
   public void case2() {
	int[] l_inputs = null;
	l_inputs = new int[]{1, 2, 3, 4};

	split(l_inputs);

	System.out.println("Min Diff: " + m_minDiff);
	System.out.println("Min Array: " + Arrays.toString(m_results.get(m_minDiff)[0]));
	System.out.println("Max Array: " + Arrays.toString(m_results.get(m_minDiff)[1]));
   }

}
