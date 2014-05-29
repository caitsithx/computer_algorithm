/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */

/*
第10题
翻转句子中单词的顺序。
题目：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
句子中单词以空格符隔开。为简单起见，标点符号和普通字母一样处理。
例如输入“I am a student.”，则输出“student. a am I”。
 */

package algorithm.puzzle100;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

import algorithm.puzzle100.struct.ArrayBasedStack;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public class N010_SentenceReverse {

   public void inputAndReverse(char[] p_input) throws IOException {
	ArrayBasedStack<Integer> l_startStack = new  ArrayBasedStack<>(10000);
	ArrayBasedStack<Integer> l_endStack = new  ArrayBasedStack<>(10000);



	boolean l_flag = true;

	for (int l_i = 0; l_i < p_input.length; l_i++) {

	   if(p_input[l_i] == ' ') {
		if(!l_flag) {
		   l_endStack.push(l_i - 1);
		   l_flag = true;
		}
	   } else {
		if(l_flag) {
		   l_startStack.push(l_i);
		   l_flag = false;
		}
	   }
	}

	l_endStack.push(p_input.length - 1);

	System.out.println("input is: " + Arrays.toString(p_input));

	while(l_startStack.size() > 0) {
	   int l_start = l_startStack.pop();
	   int l_end = l_endStack.pop();

	   for (int l_i = l_start; l_i <= l_end; l_i++) {
		System.out.print(p_input[l_i]);
	   }

	   if(l_startStack.size() > 0)
		System.out.print(' ');
	}
   }

   @Test
   public void test() throws IOException {
	String l_inputStr = new String("I am 豆SHA冰棒.  Good night!");
	this.inputAndReverse(l_inputStr.toCharArray());
   }
}
