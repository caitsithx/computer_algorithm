/*
 * Copyright (c) 2012 caitsithx - All rights reserved.
 *
 */
package algorithm.jmsbd;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public class PermutationEx1 {
   public void perm(ArrayList<Character> p_input) {
	
	perm(p_input, new StringBuilder());
   }
   
   public void perm(ArrayList<Character> p_input, StringBuilder p_tmp) {
	if(p_input.size() == 0) {
	   System.out.println(p_tmp.toString());
	}
	
	for (int l_i = 0; l_i < p_input.size(); l_i++) {
	   if(l_i > 0 && p_input.get(l_i - 1).equals(p_input.get(l_i))) {
		continue;
	   }
	   
	   p_tmp.append(p_input.remove(l_i));
	   perm(p_input, p_tmp);
	   
	   p_input.add(l_i, p_tmp.charAt(p_tmp.length() - 1));
	   p_tmp.deleteCharAt(p_tmp.length() - 1);
	}
   }
   
   @Test
   public void case1() {
	PermutationEx1 l_permer = new PermutationEx1();
	ArrayList<Character> l_input = new ArrayList<>();
	l_input.add('1');
	l_input.add('1');
	l_input.add('2');
	l_permer.perm(l_input);
	
	l_input.add('4');
	l_input.add('5');
//	l_input.add('6');
	l_permer.perm(l_input);
   }
}
