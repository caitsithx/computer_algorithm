/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
/*
第18题：
题目：n个数字（0,1,…,n-1）形成一个圆圈，从数字0开始，
每次从这个圆圈中删除第m个数字（第一个为当前数字本身，第二个为当前数字的下一个数字）。
当一个数字删除后，从被删除数字的下一个继续删除第m个数字。
求出在这个圆圈中剩下的最后一个数字。
July：我想，这个题目，不少人已经 见识过了。

 */
package algorithm.puzzle100;

import org.junit.Test;

import algorithm.puzzle100.struct.IntNode;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public class N018_LastInCircle {
   public void findLast(int[] p_inputs, int p_m) {
	
	IntNode l_head = new IntNode(p_inputs[0], null, null);
	IntNode l_tmp = l_head;
	for (int l_i = 1; l_i < p_inputs.length; l_i++) {
	   IntNode l_tmp1 = new IntNode(p_inputs[l_i], l_tmp, null);
	   l_tmp.setNext(l_tmp1);
	   l_tmp = l_tmp1;
	}
	
	l_tmp.setNext(l_head);
	l_head.setPrevious(l_tmp);
	
	findLast(l_head, p_m);
   }

   public void findLast(IntNode p_node, int p_m) {
	IntNode l_current = p_node;
	int l_count = 1;
	while (l_current.getNext() != l_current) {
	   if(l_count % p_m == 0) {
		IntNode p_previous = (IntNode) l_current.getPrevious();
		IntNode p_next = (IntNode) l_current.getNext();
		p_previous.setNext(p_next);
		p_next.setPrevious(p_previous);

		l_count = 1;
	   }
	   else {
		l_count ++;
	   }

	   l_current = (IntNode) l_current.getNext();
	}
	
	System.out.println(l_current);
   }
   
//   @Test
//   public void case1() {
//	N018_LastInCircle l_finder = new N018_LastInCircle();
//	l_finder.findLast(new int[]{1, 2, 3} , 2);
//   }
   
   
//   @Test
//   public void case2() {
//	N018_LastInCircle l_finder = new N018_LastInCircle();
//	l_finder.findLast(new int[]{1, 2, 3} , 3);
//   }
   
//   @Test
//   public void case4() {
//	N018_LastInCircle l_finder = new N018_LastInCircle();
//	l_finder.findLast(new int[]{1, 2, 3} , 1);
//   }
   
   
   @Test
   public void case5() {
	N018_LastInCircle l_finder = new N018_LastInCircle();
	l_finder.findLast(new int[]{1, 2, 3, 4} , 5);
   }
   
//   @Test
//   public void case6() {
//	N018_LastInCircle l_finder = new N018_LastInCircle();
//	l_finder.findLast(new int[]{1, 2, 3, 4} , 2);
//   }
   
}
