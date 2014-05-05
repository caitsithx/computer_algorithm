package algorithm.puzzle100;///*
// * Copyright (c) 2012 Caitsithx - All rights reserved.
// *
// * $Revison$
// * $author$
// */
//package algorithm.puzzle100;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Iterator;
//
//import org.junit.Test;
//
//import algorithm.puzzle100.struct.TreeNode;
//
///**
// * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
// *
// */
//public class N022_CardGameBad {
//   private int m_pool = 44;
//
//   private int[] m_c42 = {20, 11, 02};
//
//   private static int[][] UNGUESSIBLE = {
//	{20, 11}, /*{20, 02}, */{11, 11}, {02, 11},
//	{11, 20}, /*{02, 20},*/           {11, 02}
//   };
//
//   private TreeNode m_p1 = new TreeNode(0);
//   //   private TreeNode m_p2 = new TreeNode(0);
//   private ArrayList<int[]> m_p2 = new ArrayList<>();
//
//   public boolean isGuessible1(int p_p1, int p_p2) {
//	return (p_p1 == 2 && p_p2 == 2) || (p_p1 == 20 && p_p2 == 20);
//   }
//
//   public boolean isGuessible2(int p_p1, int p_p2) {
//	boolean l_guessible2 = false;
//	for (int l_i = 0; l_i < m_c42.length && !l_guessible2; l_i++) {
//	   l_guessible2 = isGuessible1(p_p1, m_c42[l_i]) || isGuessible1(p_p2, m_c42[l_i]);
//	}
//	return l_guessible2;
//   }
//
//   @Test
//   public void guess() {
//	for (int l_i = 0; l_i < UNGUESSIBLE.length; l_i++) {
//	   System.out.println(Arrays.toString(UNGUESSIBLE[l_i]) + " guessible: " + 
//		   isGuessible2(UNGUESSIBLE[l_i][0], UNGUESSIBLE[l_i][1]));
//	}
//   }
//
//   public boolean isGoodGuess (int[] p_ps) {
//	int l_a = 4;
//	int l_b = 4;
//	for (int l_i = 0; l_i < p_ps.length; l_i++) {
//	   if(p_ps[l_i] > 10) {
//		int l_tmp = (p_ps[l_i]/10);
//		l_a -= l_tmp;
//
//		l_b -= (p_ps[l_i] - l_tmp * 10);
//	   } else {
//		l_b -= p_ps[l_i];
//	   }
//	}
//
//	return l_a >= 0 && l_b >= 0;
//   }
//
//   private TreeNode searchSon(TreeNode p_parent, int p_value) {
//	TreeNode l_res = p_parent.getLeft();
//
//	while (l_res != null && l_res.getValue() != p_value) {
//	   l_res = l_res.getRight();
//	}
//
//	return l_res;
//   }
//
//   /**
//    * @param p_p1
//    * @param p_p3Node
//    */
//   private void addSon(TreeNode p_p1, TreeNode p_p3Node) {
//	if(p_p1.getLeft() == null) {
//	   p_p1.setLeft(p_p3Node);
//	} else {
//	   TreeNode l_brother = p_p1.getLeft();
//	   while(l_brother.getRight() != null) {
//		l_brother = l_brother.getRight();
//	   }
//
//	   l_brother.setRight(p_p3Node);
//	}
//   }
//
//   public void getCards() {
//	for (int l_i2 = 0; l_i2 < UNGUESSIBLE.length; l_i2++) {
//	   TreeNode l_p2Node = new TreeNode(UNGUESSIBLE[l_i2][0]);
//	   TreeNode l_p3Node = searchSon(m_p1, UNGUESSIBLE[l_i2][1]);
//
//	   //		if(UNGUESSIBLE[l_i2][0] == 11 && UNGUESSIBLE[l_i2][1] == 20) {
//	   //		   System.out.println();
//	   //		}
//
//	   if(l_p3Node == null) {
//		l_p3Node = new TreeNode(UNGUESSIBLE[l_i2][1], l_p2Node, null);
//
//		addSon(m_p1, l_p3Node);
//	   } else {
//		addSon(l_p3Node, l_p2Node);
//	   }
//	}
//
//	for (int l_i2 = 0; l_i2 < UNGUESSIBLE.length; l_i2++) {
//
//	   //		if(UNGUESSIBLE[l_i2][0] == 11 && UNGUESSIBLE[l_i2][1] == 20) {
//	   //		   System.out.println();
//	   //		}
//
//	   TreeNode l_guessBefore = searchSon(m_p1, UNGUESSIBLE[l_i2][1]);
//	   l_guessBefore = l_guessBefore.getLeft();
//	   do {
//		int[] l_tmp = new int[3];
//		l_tmp[0] = UNGUESSIBLE[l_i2][0];
//		l_tmp[2] = UNGUESSIBLE[l_i2][1];
//
//		l_tmp[1] = l_guessBefore.getValue();
//		if(isGoodGuess(l_tmp)) {
//		   System.out.println(Arrays.toString(l_tmp));
//		   m_p2.add(l_tmp);
//		   //		   enqueue(m_p2, l_tmp);
//		}
//		l_guessBefore = l_guessBefore.getRight();
//	   } while (l_guessBefore != null);
//	}
//
//	for (Iterator<int[]> l_iterator = m_p2.iterator(); l_iterator.hasNext();) {
//	   int[] l_candidate = l_iterator.next();
//	   if(isGuessible1(l_candidate[0], l_candidate[1]) 
//		   || isGuessible1(l_candidate[1], l_candidate[2]) 
//		   || isGuessible1(l_candidate[0], l_candidate[2])) {
//		l_iterator.remove();
//	   }
//	}
//
//	if(m_p2.size() == 1) {
//	   System.out.println("successful: " + Arrays.toString(m_p2.get(0)));
//	} else {
//	   System.out.println("failed!");
//	   for (int[] l_candidate : m_p2) {
//		System.out.println(Arrays.toString(l_candidate));
//	   }
//	}
//   }
//
//   //   @Test
//   public void case1() {
//	getCards();
//   }
//
//   /**
//    * @param p_p2
//    * @param p_tmp
//    */
//   private void enqueue(TreeNode p_p2, int[] p_tmp) {
//	TreeNode l_p1 = searchSon(p_p2, p_tmp[0]);
//
//	if(l_p1 != null) {
//	   TreeNode l_p2 = searchSon(l_p1, p_tmp[1]);
//
//	   if(l_p2 != null) {
//		TreeNode l_p3 = searchSon(l_p2, p_tmp[2]);
//
//		if(l_p3 == null) {
//		   l_p3 = new TreeNode(p_tmp[2]);
//
//		   addSon(l_p2, l_p3);
//		}
//	   } else {
//		TreeNode l_p3 = new TreeNode(p_tmp[2]);
//		l_p2 = new TreeNode(p_tmp[1], l_p3, null);
//
//		addSon(l_p1, l_p2);
//	   }
//	} else {
//	   TreeNode l_p3 = new TreeNode(p_tmp[2]);
//	   TreeNode l_p2 = new TreeNode(p_tmp[1], l_p3, null);
//	   l_p1 = new TreeNode(p_tmp[0], l_p2, null);
//
//	   addSon(p_p2, l_p1);
//	}
//   }
//}
