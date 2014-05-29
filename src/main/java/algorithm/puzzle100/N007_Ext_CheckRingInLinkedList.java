/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */

/**
第7题
微软亚院之编程判断俩个链表是否相交：
给出俩个单向链表的头指针，比如h1，h2，判断这俩个链表是否相交。
为了简化问题，我们假设俩个链表均不带环。
问题扩展：
1.如果链表可能有环列?
2.如果需要求出俩个链表相交的第一个节点列?
 */
package algorithm.puzzle100;

import org.junit.Test;

import algorithm.puzzle100.struct.Node;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public class N007_Ext_CheckRingInLinkedList {

   public Node<Integer> checkRing(Node<Integer> p_list) {
	
	Node<Integer> l_node1 = p_list.getNext();
	Node<Integer> l_node2 = null;
	//init step
	if (l_node1 != null) {
	   if (l_node1.getNext() != null) {
		l_node2 = l_node1.getNext();
	   } else {
		return null;
	   }
	} else {
	   return null;
	}
	
	Node<Integer> l_theSame = null;
	while(l_node1.getNext() != null && l_node2.getNext() != null && l_node2.getNext().getNext() != null) {
	   l_node1 = l_node1.getNext();
	   l_node2 = l_node2.getNext().getNext();
	   
	   //the two indices mets. NOTE: if no shifting, the two racers will always meet.
	   if(l_node1 == l_node2) {
		l_theSame = l_node1;
		break;
	   }
	}
	
	return l_theSame;
   }
   
   @Test
   public void case1()  {
	Node<Integer> l_10 = new Node<Integer>(10, null, null);
	Node<Integer> l_9 = new Node<Integer>(9, null, l_10);
	Node<Integer> l_8 = new Node<Integer>(8, null, l_9);
	Node<Integer> l_7 = new Node<Integer>(7, null, l_8);
	Node<Integer> l_6 = new Node<Integer>(6, null, l_7);
	
	N007_Ext_CheckRingInLinkedList l_checker = new N007_Ext_CheckRingInLinkedList();
	System.out.println(l_checker.checkRing(l_6));
	
	l_10.setNext(l_8);
	System.out.println(l_checker.checkRing(l_6));
   }
}
