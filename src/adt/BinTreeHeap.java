/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
package adt;

import java.util.Arrays;


/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 * @param <T> 
 *
 */
public class BinTreeHeap<T extends Comparable<? super T>> implements IPriorityQueue<T> {
   protected int m_size = 0;
   private T[] m_internal;
   
   /**
    * @param p_max
    */
   @SuppressWarnings("unchecked")
   public BinTreeHeap(int p_max) {
	m_internal = (T[]) new Comparable[p_max];
   }
   
   /**
    * @param p_max
    */
   @SuppressWarnings("unchecked")
   public BinTreeHeap(T[] p_items) {
	m_internal = (T[]) new Comparable[p_items.length + 1];
	
	buildHeap(p_items);
   }
   
   /**
    * @param p_items
    */
   private void buildHeap(T[] p_items) {
	for (int l_i = 0; l_i < p_items.length; l_i++) {
	   m_internal[l_i + 1] = p_items[l_i];
	}
	
	for (int l_i = m_internal.length / 2; l_i >= 1; l_i --) {
	   pushDown(l_i);
	}
   }

   private void checkIndex(int p_idx) {
	if(p_idx < 1 || p_idx > m_size) {
	   throw new ArrayIndexOutOfBoundsException();
	}
   }
   
   protected T get(int p_idx) {
	checkIndex(p_idx);
	
	return m_internal[p_idx];
   }

   @Override
   public void insert(T p_newItem) {
	popUp(++m_size, p_newItem);
   }
   
   public boolean isEmpty() {
	return m_size == 0;
   }
   
   @Override
   public T deleteMin() {
	if(isEmpty()) {
	   throw new ArrayIndexOutOfBoundsException();
	}
	
	T l_min = m_internal[1];
	m_internal[1] = m_internal[m_size --];
	
	pushDown(1);
	
	return l_min;
   }
   
   protected void popUp(int p_index, T p_newItem) {
	int l_i = p_index;
	
	for (; l_i / 2 > 0 && p_newItem.compareTo(m_internal[l_i / 2]) < 0; l_i /= 2) {
	   m_internal[l_i] = m_internal[l_i / 2];
	}
	
	m_internal[l_i] = p_newItem;
   }
   
   protected void pushDown(int p_index) {
	int l_i = p_index;
	T l_tmp = m_internal[p_index];
	
	for (; l_i * 2 < m_size; ) {
	   int l_leftChildIdx = l_i * 2;
	   if(l_leftChildIdx + 1 < m_size 
		   && m_internal[l_leftChildIdx + 1].compareTo(m_internal[l_leftChildIdx]) < 0) {
		l_leftChildIdx ++;
	   } 
	   
	   if(m_internal[l_leftChildIdx].compareTo(l_tmp) < 0) {
		m_internal[l_i] = m_internal[l_leftChildIdx];
	   } else {
		break;
	   }
	   
	   l_i = l_leftChildIdx;
	}
	
	m_internal[l_i] = l_tmp;
   }
   
   @Override
   public String toString() {
	return Arrays.toString(this.m_internal);
   }

}
