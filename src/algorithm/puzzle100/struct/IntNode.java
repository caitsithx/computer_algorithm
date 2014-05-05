/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
package algorithm.puzzle100.struct;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public class IntNode extends Node<Integer> {

   /**
    * @param p_value
    * @param p_previous
    * @param p_next
    */
   public IntNode(Integer p_value, IntNode p_previous, IntNode p_next) {
	super(p_value, p_previous, p_next);
   }
}
