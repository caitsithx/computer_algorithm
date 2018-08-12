/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 * 
 *
 * $Revison$
 * $author$
 */

/************************************************************
 1.把二元查找树转变成排序的双向链表
 题目：
 输入一棵二元查找树，将该二元查找树转换成一个排序的双向链表。
 要求不能创建任何新的结点，只调整指针的指向。

 10
 / \
 6 14
 / \ / \
 4 8 12 16

 转换成双向链表
 4=6=8=10=12=14=16。

 首先我们定义的二元查找树 节点的数据结构如下：
 struct BSTreeNode
 {
 int m_nValue; // value of node
 BSTreeNode *m_pLeft; // left child of node
 BSTreeNode *m_pRight; // right child of node
 };
 ************************************************************/
package algorithm.puzzle100;

import adt.TreeNode;
import org.junit.jupiter.api.Test;


/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 */
public class N001_BinSearchTreeToDualLinkedList {
    private TreeNode m_currentInList = null;

    /**
     * very simple by mid-order visit.
     *
     * @param p_current
     * @param p_left
     * @return
     */
    public TreeNode[] transform(TreeNode p_current) {
        TreeNode l_leftMost = null;
        TreeNode l_rightMost = null;

        TreeNode[] l_leftSubTreeMosts = null;
        if (p_current.getLeft() != null) {
            l_leftSubTreeMosts = transform(p_current.getLeft());

            if (l_leftSubTreeMosts != null) {
                l_leftMost = l_leftSubTreeMosts[0];

                if (l_leftSubTreeMosts[1] != null) {
                    l_leftSubTreeMosts[1].setRight(p_current);
                    p_current.setLeft(l_leftSubTreeMosts[1]);
                }
            }
        } else {
            l_leftMost = p_current;
        }


        TreeNode[] l_rightSubTreeMosts = null;
        if (p_current.getRight() != null) {
            l_rightSubTreeMosts = transform(p_current.getRight());

            if (l_rightSubTreeMosts != null) {
                if (l_rightSubTreeMosts[0] != null) {
                    l_rightSubTreeMosts[0].setLeft(p_current);
                    p_current.setRight(l_rightSubTreeMosts[0]);
                }

                l_rightMost = l_rightSubTreeMosts[1];
            }
        } else {
            l_rightMost = p_current;
        }


        return new TreeNode[] {l_leftMost, l_rightMost};
    }

    @Test
    public void case1() {
        N001_BinSearchTreeToDualLinkedList l_transformer = new N001_BinSearchTreeToDualLinkedList();

        TreeNode l_four = new TreeNode(4);
        TreeNode l_eight = new TreeNode(8);
        TreeNode l_six = new TreeNode(6, l_four, l_eight);

        TreeNode l_twelve = new TreeNode(12);
        TreeNode l_sixteen = new TreeNode(16);
        TreeNode l_fourteen = new TreeNode(14, l_twelve, l_sixteen);

        TreeNode l_ten = new TreeNode(10, l_six, l_fourteen);

        l_transformer.transform(l_ten);

        TreeNode l_starter = l_six;

        System.out.print(l_starter.getValue());
        while (l_starter.getRight() != null) {
            l_starter = l_starter.getRight();
            System.out.print("->" + l_starter.getValue());
        }

        System.out.println();

        System.out.print(l_starter.getValue());
        while (l_starter.getLeft() != null) {
            l_starter = l_starter.getLeft();
            System.out.print("->" + l_starter.getValue());
        }
    }
}
