/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
/*
第15题：
题目：输入一颗二元查找树，将该树转换为它的镜像，
即在转换后的二元查找树中，左子树的结点都大于右子树的结点。
用递归和循环两种方法完成树的镜像转换。   
例如输入：
  8
  / \
  6 10
 /\ /\
5 7 9 11
输出：
  8
  / \
 10 6
 /\ /\
11 9 7 5
定义二元查找树的结点为：
struct BSTreeNode // a node in the binary search tree (BST)
{
  int m_nValue; // value of node
  BSTreeNode *m_pLeft; // left child of node
  BSTreeNode *m_pRight; // right child of node
};

 */
package algorithm.puzzle100;

import org.junit.Test;

import algorithm.puzzle100.struct.ArrayBasedStack;
import algorithm.puzzle100.struct.TreeNode;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public class N015_BinTreeReverseByLoop {

   public void reverse(TreeNode p_root) {
	while(p_root == null) {
	  return;
	}
	
	ArrayBasedStack<TreeNode> l_list = new ArrayBasedStack<TreeNode>(10000);
	l_list.push(p_root);
	while(l_list.size() > 0) {
	   TreeNode l_node = l_list.pop();
	   while(l_node != null) {
		TreeNode l_left = l_node.getLeft();
		if(l_node.getRight() != null) {
		   l_list.push(l_node.getRight());
		}
		
		swap(l_node);
		l_node = l_left;
	   }
	}
	
   }
   
   /**
    * @param p_node
    */
   private void swap(TreeNode p_node) {
	TreeNode l_tmp = p_node.getLeft();
	p_node.setLeft(p_node.getRight());
	p_node.setRight(l_tmp);
   }

   @Test
   public void case1() {
	TreeNode l_4 = new TreeNode(4);
	TreeNode l_7 = new TreeNode(7);
	TreeNode l_5 = new TreeNode(5, l_4, l_7);


	TreeNode l_12 = new TreeNode(12);

	TreeNode l_10 = new TreeNode(10, l_5, l_12);

	N015_BinTreeReverseByLoop l_reverse = new N015_BinTreeReverseByLoop();
	l_reverse.reverse(l_10);
	System.out.println(l_10);
   }
   
   @Test
   public void case2() {
	TreeNode l_4 = new TreeNode(4);
	TreeNode l_7 = new TreeNode(7);
	TreeNode l_5 = new TreeNode(5, l_4, l_7);

	TreeNode l_15 = new TreeNode(15);
	TreeNode l_14 = new TreeNode(14, null, l_15);

	TreeNode l_16 = new TreeNode(16);
	TreeNode l_11 = new TreeNode(11, l_16, null);
	TreeNode l_12 = new TreeNode(12, l_14, l_11);

	TreeNode l_10 = new TreeNode(10, l_5, l_12);

	N015_BinTreeReverseByLoop l_reverse = new N015_BinTreeReverseByLoop();
	l_reverse.reverse(l_10);
	System.out.println(l_10);
   }
}
