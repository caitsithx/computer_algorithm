/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
package adt;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 * @param <T> 
 *
 */
public class LeftSideHeap <T extends IPriorityItem<? super T>> 
implements IPriorityQueueEx<T>{
   Node<T> m_root = null;

   /* (non-Javadoc)
    * @see caitisith.alg.adt.IPriorityQueue#insert(java.lang.Comparable)
    */
   @Override
   public void insert(T p_newItem) {
	if(p_newItem == null) {
	   throw new IllegalArgumentException();
	}

	Node<T> l_newNode = new Node<T>();
	l_newNode.im_item = p_newItem;

	merge(m_root, l_newNode);
   }

   private Node<T> merge(Node<T> p_t1, Node<T> p_t2) {
	if(p_t1 == null) {
	   return p_t2;
	} else if(p_t2 == null) {
	   return p_t1;
	}

	if(p_t1.im_item.compareTo(p_t2.im_item) > 0) {
	   return merge1(p_t2, p_t1);
	}

	return merge1(p_t1, p_t2);
   }

   /**
    * @param p_im_right
    * @param p_t1
    * @return
    */
   private Node<T> merge1(Node<T> p_t1, Node<T> p_t2) {
	if(p_t1.im_left == null) {
	   p_t1.im_left = p_t2;
	} else {
	   p_t1.im_right = merge(p_t1.im_right, p_t2);

	   if(p_t1.im_left.im_npl < p_t1.im_right.im_npl) {
		swapChildren(p_t1);
	   }

	   p_t1.im_npl = p_t1.im_right.im_npl + 1;
	}

	return p_t1;
   }

   /**
    * @param p_t1
    */
   private void swapChildren(Node<T> p_t1) {
	Node<T> l_tmp = p_t1.im_left;
	p_t1.im_left = p_t1.im_right;
	p_t1.im_right = l_tmp;
   }

   @Override
   public T deleteMin() {
	if(m_root == null) {
	   throw new ArrayIndexOutOfBoundsException();
	}
	T l_val =  m_root.im_item;
	m_root = merge(m_root.im_left, m_root.im_right);
	return l_val;
   }

   @Override
   public void increaseP(int p_idx, int p_delta) {
	// TODO Auto-generated method stub

   }

   /* (non-Javadoc)
    * @see caitisith.alg.adt.IPriorityQueueEx#decreaseP(int, int)
    */
   @Override
   public void decreaseP(int p_idx, int p_delta) {
	// TODO Auto-generated method stub

   }

   /* (non-Javadoc)
    * @see caitisith.alg.adt.IPriorityQueueEx#delete(int)
    */
   @Override
   public void delete(int p_idx) {
	// TODO Auto-generated method stub

   }

   private final class Node<T> {
	/**
	 * 
	 */
	protected Node() {
	   // TODO Auto-generated constructor stub
	}

	protected Node<T> im_left;
	protected Node<T> im_right;
	protected int im_npl;
	protected T im_item;
   }

}
