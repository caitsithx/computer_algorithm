/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */

/*
4.在二元树中找出和为某一值的所有路径
题目：输入一个整数和一棵二元树。
从树的根结点开始往下访问一直到叶结点所经过的所有结点形成一条路径。
打印出和与输入整数相等的所有路径。
例如 输入整数22和如下二元树
  10   
  / \   
  5 12   
  / \   
  4 7
则打印出两条路径：10, 12和10, 5, 7。

二元树节点的数据结构定义为：

struct BinaryTreeNode // a node in the binary tree
{
int m_nValue; // value of node
BinaryTreeNode *m_pLeft; // left child of node
BinaryTreeNode *m_pRight; // right child of node
};

 */
package algorithm.puzzle100;

import algorithm.puzzle100.struct.ArrayBasedStack;
import algorithm.puzzle100.struct.TreeNode;
import org.junit.Test;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 */
public class N004_BinTreeGetRouteBySum {
    ArrayBasedStack<Integer> m_routeStack = new ArrayBasedStack<Integer>(1000);


    public void getRoutes(TreeNode p_root, int p_currentSum) {
        //	TreeNode l_cloned = new TreeNode(p_root.getValue());

        int l_sumForSubTree = p_currentSum - p_root.getValue();

        if (l_sumForSubTree == 0 && p_root.getLeft() == null && p_root.getRight() == null) {
            for (int l_i = 0; l_i < m_routeStack.size(); l_i++) {
                System.out.print(m_routeStack.get(l_i));
                System.out.print(',');
            }
            System.out.print(p_root.getValue());
            System.out.println();
        } else if (l_sumForSubTree > 0) {
            if (l_sumForSubTree > p_root.getValue()) {
                if (p_root.getRight() != null) {
                    m_routeStack.push(p_root.getValue());
                    getRoutes(p_root.getRight(), l_sumForSubTree);
                    m_routeStack.pop();
                }
            }

            if (p_root.getLeft() != null) {
                m_routeStack.push(p_root.getValue());
                getRoutes(p_root.getLeft(), l_sumForSubTree);
                m_routeStack.pop();
            }
        } /*else if(l_sumForSubTree < 0) {
     l_cloned = null;
	}*/
    }

    @Test
    public void case1() {
        TreeNode l_4 = new TreeNode(4);
        TreeNode l_7 = new TreeNode(7);
        TreeNode l_5 = new TreeNode(5, l_4, l_7);


        TreeNode l_12 = new TreeNode(12);

        TreeNode l_10 = new TreeNode(10, l_5, l_12);

        N004_BinTreeGetRouteBySum l_router = new N004_BinTreeGetRouteBySum();
        l_router.getRoutes(l_10, 22);
    }
}
