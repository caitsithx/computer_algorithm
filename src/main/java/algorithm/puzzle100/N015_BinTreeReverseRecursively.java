/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
/*
第15题：
题目：输入一颗二元查找树，将该树转�?�为它的镜�?，
�?�在转�?��?�的二元查找树中，左�?树的结点都大于�?��?树的结点。
用递归和循环两�?方法完�?树的镜�?转�?�。   
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

import algorithm.puzzle100.struct.TreeNode;
import org.junit.Test;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 */
public class N015_BinTreeReverseRecursively {

    public void reverse(TreeNode p_root) {
        if (p_root == null) {
            return;
        }

        TreeNode l_tmp = p_root.getLeft();
        p_root.setLeft(p_root.getRight());
        p_root.setRight(l_tmp);

        reverse(p_root.getLeft());
        reverse(p_root.getRight());
    }

    @Test
    public void case1() {
        TreeNode l_4 = new TreeNode(4);
        TreeNode l_7 = new TreeNode(7);
        TreeNode l_5 = new TreeNode(5, l_4, l_7);


        TreeNode l_12 = new TreeNode(12);

        TreeNode l_10 = new TreeNode(10, l_5, l_12);

        N015_BinTreeReverseRecursively l_reverse = new N015_BinTreeReverseRecursively();
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

        N015_BinTreeReverseRecursively l_reverse = new N015_BinTreeReverseRecursively();
        l_reverse.reverse(l_10);
        System.out.println(l_10);
    }
}
