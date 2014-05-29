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
public interface IPriorityItem<T> extends Comparable<T>{

   public void increase(int p_delta);
   public void decrease(int p_delta);
   
   public int getPriority();
}
