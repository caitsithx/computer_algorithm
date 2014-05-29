/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
package adt;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public interface IPriorityQueueEx<T extends IPriorityItem<? super T>> 
extends IPriorityQueue<T>{

   /**
    * @param p_idx
    * @param p_delta
    */
   void increaseP(int p_idx, int p_delta);

   /**
    * @param p_idx
    * @param p_delta
    */
   void decreaseP(int p_idx, int p_delta);
   
   public void delete(int p_idx);
}
