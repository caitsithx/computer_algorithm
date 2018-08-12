/*
 * Copyright (c) 2012 caitsithx - All rights reserved.
 *
 */
package algorithm.jmsbd;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public class Permutation {

//   private ArrayBasedStack<Character> m_stack = new ArrayBasedStack<>(1000);
   
   public void perm(ArrayList<Character> p_input) {
	
	perm(p_input, new StringBuilder());
   }
   
   public void perm(ArrayList<Character> p_input, StringBuilder p_tmp) {
	if(p_input.size() == 0) {
	   System.out.println(p_tmp.toString());
	}
	
	for (int l_i = 0; l_i < p_input.size(); l_i++) {
	   p_tmp.append(p_input.remove(l_i));
	   perm(p_input, p_tmp);
	   
	   p_input.add(l_i, p_tmp.charAt(p_tmp.length() - 1));
	   p_tmp.deleteCharAt(p_tmp.length() - 1);
	}
   }
   
   @Test
   public void case1() {
	Permutation l_permer = new Permutation();
	ArrayList<Character> l_input = new ArrayList<>();
	l_input.add('1');
	l_input.add('2');
	l_input.add('3');
	l_permer.perm(l_input);
	
	l_input.add('4');
	l_input.add('5');
	l_input.add('6');
	l_permer.perm(l_input);
   }
}
