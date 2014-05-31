/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
package adt;

/**
 * @param <T>
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 */
public interface IPriorityQueue<T extends Comparable<? super T>> {

    public void insert(T p_newItem);

    public T deleteMin();
}
