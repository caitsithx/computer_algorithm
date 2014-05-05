/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */

/*
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

import algorithm.puzzle100.struct.ArrayBasedStack;
import algorithm.puzzle100.struct.Node;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 * 
 */
public class N007_SameSubListInTwoLinkedList {
   public Node checkNoRings(Node p_list1, Node p_list2) {
	Node l_firstSame = null;
	
	ArrayBasedStack<Node> l_stack1 = new ArrayBasedStack<Node>(1000);/*don't provide a big list!!*/
	ArrayBasedStack<Node> l_stack2 = new ArrayBasedStack<Node>(1000);
	
	Node l_tail1 = p_list1;
	l_stack1.push(l_tail1);
	while(l_tail1.getNext() != null) {
	   l_tail1 = l_tail1.getNext();
	   l_stack1.push(l_tail1);
	}
	
	Node l_tail2 = p_list2;
	l_stack2.push(l_tail2);
	while(l_tail2.getNext() != null) {
	   l_tail2 = l_tail2.getNext();
	   l_stack2.push(l_tail2);
	}
	
	if(l_tail1 == l_tail2) {
	   while(l_stack1.size() > 0 && l_stack2.size() > 0) {
		l_tail1 = l_stack1.pop();
		l_tail2 = l_stack2.pop();
		
		if(l_tail2 == l_tail1) {
		   l_firstSame = l_tail2;
		}
	   }
	}
	
	return l_firstSame;
   }
   

   /**
    * @param p_ringNode1
    * @param p_list2
    */
   private boolean checkRing(Node p_ringNode1, Node p_list2) {
	Node l_node2 = p_list2;
	
	while(l_node2.getNext() != null) {
	   l_node2 = l_node2.getNext();
	   
	   if(p_ringNode1 == l_node2) {
		return true;
	   }
	}
	
	return false;
   }

   public boolean check(Node p_list1, Node p_list2) {
	boolean l_yes = false;
	
	N007_Ext_CheckRingInLinkedList l_ringChk = new N007_Ext_CheckRingInLinkedList();
	Node l_ringNode1 = l_ringChk.checkRing(p_list1);
	Node l_ringNode2 = l_ringChk.checkRing(p_list2);
	
	if(l_ringNode1 == null && l_ringNode2 == null) {
	   l_yes = checkNoRings(p_list1, p_list2) != null;
	} else if(l_ringNode1 != null && l_ringNode2 != null) {
	   l_yes = checkRing(l_ringNode1, p_list2);
	} /*else is one with ring, one without, no doubt: false*/
	
	return l_yes;
   }
   
   @Test
   public void case1()  {
	Node l_10 = new Node(10, null, null);
	Node l_9 = new Node(9, null, l_10);
	Node l_8 = new Node(8, null, l_9);
	Node l_7 = new Node(7, null, l_8);
	Node l_6 = new Node(6, null, l_7);
	
	Node l_5 = new Node(5, null, l_7);
	Node l_54 = new Node(54, null, null);
	
	N007_SameSubListInTwoLinkedList l_chk = new N007_SameSubListInTwoLinkedList();
	System.out.println(l_chk.check(l_6, l_5));
	System.out.println(l_chk.check(l_6, l_54));
	
	l_10.setNext(l_8);
	
	System.out.println(l_chk.check(l_6, l_5));
	System.out.println(l_chk.check(l_6, l_54));
   }
   
}
