/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */

/*
第24题：
链表操作，
（1）.单链表就地逆置，
 */
package algorithm.puzzle100;

import org.junit.jupiter.api.Test;

import algorithm.puzzle100.struct.Node;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public class N024_ReverseLinkedList {

   @Test
   public void case1() {
	Node<Integer> l_10 = new Node<Integer>(10, null, null);
	Node<Integer> l_9 = new Node<Integer>(9, null, l_10);
	Node<Integer> l_8 = new Node<Integer>(8, null, l_9);
	Node<Integer> l_7 = new Node<Integer>(7, null, l_8);
	Node<Integer> l_6 = new Node<Integer>(6, null, l_7);
	
	LinkedListReverser<Integer> l_reverser = new LinkedListReverser<>();
	l_reverser.reverse(l_6);
	
	Node<Integer> l_tmp = l_10;
	
	do {
	   System.out.println(l_tmp);
	   l_tmp = l_tmp.getNext();
	} while(l_tmp != null);
   }

}

class LinkedListReverser<T> {
   public void reverse(Node<T> p_linkedList) {
	Node<T> l_tmp = p_linkedList;
	Node<T> l_next = l_tmp.getNext();
	l_tmp.setNext(null);
	while(l_tmp != null) {
	   Node<T> l_nextNext = null;
	   if(l_next != null) {
		l_nextNext = l_next.getNext();
		l_next.setNext(l_tmp);
	   }
	   
	   l_tmp = l_next;
	   l_next = l_nextNext;
	}

   }
}
