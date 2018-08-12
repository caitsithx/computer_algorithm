/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */

/*
 29.栈的push、pop序列（栈）
 题目：输入两个整数序列。其中一个序列表示栈的push顺序，
 判断另一个序列有没有可能是对应的pop顺序。
 为了简单起见，我们假设push序列的任意两个整数都是不相等的。 
 比如输入的push序列是1、2、3、4、5，那么4、5、3、2、1就有可能是一个pop系列。
 因为可以有如下的push和pop序列：
 push 1，push 2，push 3，push 4，pop，push 5，pop，pop，pop，pop，
 这样得到的pop序列就是4、5、3、2、1。
 但序列4、3、5、1、2就不可能是push序列1、2、3、4、5的pop序列。
 */
package algorithm.puzzle100;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import adt.ArrayBasedStack;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 * 
 */
public class N029_PushVsPop {

   public boolean judge(int[] p_push, int[] p_pop) {
//	boolean l_yes = false;
	
	ArrayBasedStack<Integer> l_stack = new ArrayBasedStack<>(50);

	int l_pushIdx = 0;
	int l_popIdx = 0;
	
	boolean l_pushOrPop = true;
	for (int l_i = 0; l_i < p_push.length + p_pop.length; l_i++) {
	   if(l_pushIdx == p_push.length) {
		l_pushOrPop = false;
	   } else if(l_pushIdx == 0) {
		l_pushOrPop = true;
	   } else if(p_push[l_pushIdx - 1] == p_pop[l_popIdx]) {
		l_pushOrPop = false;
	   } else {
		l_pushOrPop = true;
	   }
	   
	   if(l_pushOrPop) {
		l_stack.push(p_push[l_pushIdx++]);
	   } else {
		if(l_stack.pop() == p_pop[l_popIdx]) {
		   l_popIdx ++;   
		} else {
		   break;
		}
	   }
	   
	   System.out.println(l_stack);
	   
	}
	
//	if(l_yes) {
//	   for (int l_i = 0; l_yes && l_i < p_pop.length; l_i++) {
//		l_yes = p_push[l_i] == p_pop[p_pop.length - 1 - l_i];
//	   }
//	}
	
	return l_popIdx == p_pop.length;
   }
   
   @Test
   public void case1() {
	Assertions.assertTrue(judge(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1}));
   }
   
   @Test
   public void case2() {
	Assertions.assertFalse(judge(new int[]{1, 2, 3, 4, 5, 6}, new int[]{6, 5, 4, 3, 1, 2}));
   }
   
   @Test
   public void case3() {
	Assertions.assertFalse(judge(new int[]{1, 2, 3, 4, 5}, new int[]{6, 5, 4, 3, 1, 2}));
   }
   
   @Test
   public void case4() {
	Assertions.assertTrue(judge(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3}));
   }
   
   @Test
   public void case5() {
	Assertions.assertTrue(judge(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
   }
}
