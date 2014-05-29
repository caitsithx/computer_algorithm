/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */

/*
2.设计包含min函数的栈。
定义栈的数据结构，要求添加一个min函数，能够得到栈的最小元素。
要求函数min、push以及pop的时间复杂度都是O(1)。
 */
package algorithm.puzzle100;

import org.junit.Test;

import algorithm.puzzle100.struct.ArrayBasedStack;
import algorithm.puzzle100.struct.IStack;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public class N002_MinOfStack {
   
   /**
    * @param p_root
    * @param p_newNode
    */
//   private void add(TreeNode p_root, TreeNode p_newNode) {
//	if(p_root.getValue() < p_newNode.getValue()) {
//	   if(p_root.getRight() != null) {
//		add(p_root.getRight(), p_newNode);
//	   } else {
//		p_root.setRight(p_newNode);
//	   }
//	} else if (p_root.getValue() > p_newNode.getValue()) {
//	   if(p_root.getLeft() != null) {
//		add(p_root.getLeft(), p_newNode);
//	   } else {
//		p_root.setLeft(p_newNode);
//	   }
//	}
//   }
   
   @Test
   public void case1() {
	int[] l_input = new int[] {10, 5, 3, 18, 6, 2};
	
	MyStack l_myStk = new MyStack(l_input.length);
	for (int l_i : l_input) {
	   l_myStk.push(l_i);
	}
	
	System.out.println(l_myStk);
	System.out.println(l_myStk.getMin());
	System.out.println();
	for(int l_i = 0; l_i < l_input.length; l_i ++) {
	   System.out.println(l_myStk.getMin());
	   l_myStk.pop();
	}
   }

   static class MyStack implements IStack<Integer> {
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	   return m_store.toString() + "\n" + m_helper.toString();
	}

	ArrayBasedStack<Integer> m_store;
	ArrayBasedStack<Integer> m_helper;

	public MyStack(int p_size) {
	   m_store = new ArrayBasedStack<Integer>(p_size);
	   m_helper = new ArrayBasedStack<Integer>(p_size);
	}

	public boolean isEmpty() {
	   return m_store.isEmpty();
	}
	
	public int getMin() {
	   return m_store.get(m_helper.get(m_helper.size() - 1));
	}

	public Integer pop() {
	   m_helper.pop();
	   return m_store.pop();
	}

	public boolean push(Integer p_value) {
	   if(m_store.size() == 0) {
		m_helper.push(0);
	   } else {
		int l_minIdx = m_helper.get(m_store.size() - 1);
		if(m_store.get(l_minIdx) > p_value){
		   m_helper.push(m_store.size());
		} else {
		   m_helper.push(l_minIdx);
		}
	   }
	   
	   return m_store.push(p_value);
	}
   }
}
