/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
/*
第16题：
题目（微软）：
输入一颗二元树，从上往下按层打印树的每个结点，同一层中按照从左往右的顺序打印。   
例如输入
  8
  / \
 6 10
/ \ / \
5 7 9 11
输出8 6 10 5 7 9 11。
 */
package algorithm.puzzle100;

import adt.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 */
public class N016_BinTreePrinter {

    public void print(TreeNode p_root) {


        LinkedList<TreeNode> l_queue = new LinkedList<>();
        l_queue.add(p_root);

        while (l_queue.size() > 0) {
            TreeNode l_node = l_queue.poll();
            System.out.print(l_node.getValue());

            if (l_node.getLeft() != null)
                l_queue.add(l_node.getLeft());

            if (l_node.getRight() != null)
                l_queue.add(l_node.getRight());

            if (l_queue.size() > 0) {
                System.out.print(',');
            }
        }

    }

    @Test
    public void case1() {
        TreeNode l_4 = new TreeNode(4);
        TreeNode l_7 = new TreeNode(7);
        TreeNode l_5 = new TreeNode(5, l_4, l_7);


        TreeNode l_12 = new TreeNode(12);

        TreeNode l_10 = new TreeNode(10, l_5, l_12);

        N016_BinTreePrinter l_reverse = new N016_BinTreePrinter();
        l_reverse.print(l_10);

        System.out.println();
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

        N016_BinTreePrinter l_reverse = new N016_BinTreePrinter();
        l_reverse.print(l_10);

        System.out.println();
    }
}
