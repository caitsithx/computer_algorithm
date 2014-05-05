/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */

/*
第6题，腾讯面试题：   
给你10分钟时间，根据上排给出十个数，在其下排填出对应的十个数   
要求下排每个数都是先前上排那十个数在下排出现的次数。   
上排的十个数如下：   
【0，1，2，3，4，5，6，7，8，9】

初看此题，貌似很难，10分钟过去了，可能有的人，题目都还没看懂。   
举一个例子，   
数值: 0,1,2,3,4,5,6,7,8,9   
分配: 6,2,1,0,0,0,1,0,0,0   
0在下排出现了6次，1在下排出现了2次，   
2在下排出现了1次，3在下排出现了0次....   
以此类推..    
 */
package algorithm.puzzle100;

import java.util.ArrayList;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public class N006_CountArrayBuilder {
   ArrayList<Item> m_inner = new ArrayList<Item>();
   int[] l_result = new int[10];
   int m_size;
   int m_sum;
   
   public N006_CountArrayBuilder (int p_size) {
	
	for(int l_i = 0; l_i < p_size; l_i ++) {
	   Item l_item = new Item(l_i, 0);
	   m_inner.add(l_item);
	}
   }
   
   public  void build(int p_size, int p_start, int p_end) {
	
	
	for(int l_i = p_end; l_i >= p_start; l_i --) {
	   
	   int l_sum = 0;
	   
	   int l_seed = l_i;
	   
	   
	   for (int l_i2 = 0; l_i2 < l_result.length; l_i2++) {
		l_result[l_i2] = l_seed;
		
		for (int l_i3 = 1; l_i3 < (p_size - l_seed); l_i3++) {
		   l_result[l_seed] = l_i3;
		}
	   }
	   if(l_i + 1 > p_size) {
		break;
	   }
	   int l_firstNonIdx = p_end - p_start - 1;
	   
	   l_result[p_start] = p_end;
	   l_result[l_i] = 1;
	   
	   
	}
	
   }
   
   class Item {
	private int m_top;
	/**
	 * @param p_top
	 * @param p_bottom
	 */
	public Item(int p_top, int p_bottom) {
	   super();
	   this.m_top = p_top;
	   this.m_bottom = p_bottom;
	}
	/**
	 * @return the top
	 */
	public int getTop() {
	   return this.m_top;
	}
	/**
	 * @param p_top the top to set
	 */
	public void setTop(int p_top) {
	   this.m_top = p_top;
	}
	/**
	 * @return the bottom
	 */
	public int getBottom() {
	   return this.m_bottom;
	}
	/**
	 * @param p_bottom the bottom to set
	 */
	public void setBottom(int p_bottom) {
	   this.m_bottom = p_bottom;
	}
	private int m_bottom;
   }
}
