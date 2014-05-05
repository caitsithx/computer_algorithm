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
public class BinTreeHeapEx<T extends IPriorityItem<? super T>> 
extends BinTreeHeap<T> implements IPriorityQueueEx<T>{

   /**
    * @param p_max
    */
   public BinTreeHeapEx(int p_max) {
	super(p_max);
   }
   
   @Override
   public void increaseP(int p_idx, int p_delta) {
	T l_item = get(p_idx);
	((IPriorityItem<?>)l_item).increase(p_delta);
	
	pushDown(p_idx);
   }

   @Override
   public void decreaseP(int p_idx, int p_delta) {
	T l_item = get(p_idx);
	((IPriorityItem<?>)l_item).decrease(p_delta);
	
	popUp(p_idx, l_item);
   }
   
   @Override
   public void delete(int p_idx) {
	decreaseP(p_idx, Integer.MAX_VALUE);
	deleteMin();
   }
}
