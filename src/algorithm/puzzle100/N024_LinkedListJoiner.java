/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */

/*
第24题：
链表操作，
（2）合并链表: 2个递增有序的单链表，请你把它两个合并成一个有序的单链表
 */
package algorithm.puzzle100;

import java.util.Comparator;

import org.junit.Test;

import algorithm.puzzle100.struct.Node;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public class N024_LinkedListJoiner {

   @Test
   public void case1() {
	Node<Integer> l_14 = new Node<Integer>(10, null, null);
	Node<Integer> l_10 = new Node<Integer>(10, null, l_14);
	Node<Integer> l_9 = new Node<Integer>(9, null, l_10);
	Node<Integer> l_8 = new Node<Integer>(8, null, l_9);
	Node<Integer> l_7 = new Node<Integer>(7, null, l_8);
	Node<Integer> l_6 = new Node<Integer>(6, null, l_7);
	
	Node<Integer> l_13 = new Node<Integer>(13, null, null);
	Node<Integer> l_11 = new Node<Integer>(11, null, l_13);
	Node<Integer> l_4 = new Node<Integer>(4, null, l_11);
	Node<Integer> l_3 = new Node<Integer>(3, null, l_4);
	Node<Integer> l_2 = new Node<Integer>(2, null, l_3);
	
	LinkedListJoiner<Integer> l_reverser = new LinkedListJoiner<>();
	Node<Integer> l_tmp = l_reverser.reverse(l_6, l_2, new Comparator<Integer>() {
	   
	   @Override
	   public int compare(Integer p_o1, Integer p_o2) {
		//TODO check
		
		return p_o1.compareTo(p_o2);
	   }
	});
	
	
	
	do {
	   System.out.println(l_tmp);
	   l_tmp = l_tmp.getNext();
	} while(l_tmp != null);
   }

}

class LinkedListJoiner<T> {
   public Node<T> reverse(Node<T> p_linkedList, Node<T> p_linkedList1, Comparator<T> p_comparator) {
	if(p_linkedList == null) {
	   return p_linkedList1;
	}
	
	if(p_linkedList1 == null) {
	   return p_linkedList;
	}
	
	Node<T> l_result = null;
	
	Node<T> l_list1 = p_linkedList;
	Node<T> l_list2 = p_linkedList1;
	
	
	Node<T> l_current = null;
	while(l_list1 != null || l_list2 != null) {
	   Node<T> l_addedOne = null;
	   
	   if(l_list1 == null ||
		   (l_list2 != null && p_comparator.compare(l_list1.getValue(), l_list2.getValue()) > 0)) {
		l_addedOne = l_list2;
		l_list2 = l_list2.getNext();
	   } else {
		l_addedOne = l_list1;
		l_list1 = l_list1.getNext();
	   }
	   
	   if(l_result == null) {
		l_result = l_addedOne;
		l_current = l_result;
	   } else {
		l_current.setNext(l_addedOne);
		l_current = l_current.getNext();
	   }
	   
	   l_addedOne = l_addedOne.getNext();
	   l_current.setNext(null);
	}

	return l_result;
   }
}
