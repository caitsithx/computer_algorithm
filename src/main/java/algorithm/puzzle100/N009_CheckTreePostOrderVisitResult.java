/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */

/*
第9题
判断整数序列是不是二元查找树的后序遍历结果
题目：输入一个整数数组，判断该数组是不是某二元查找树的后序遍历的结果。
如果是返回true，否则返回false。
例如输入5、7、6、9、11、10、8，由于这一整数序列是如下树的后序遍历结果：
  8
  / \
  6 10
  / \ / \
  5 7 9 11
因此返回true。
如果输入7、4、6、5，没有哪棵树的后序遍历的结果是这个序列，因此返回false。

 */
package algorithm.puzzle100;

import adt.TreeNode;
import algorithm.puzzle100.struct.IntTreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 */
public class N009_CheckTreePostOrderVisitResult {

    public IntTreeNode convert(int[] p_inputs, int p_start, int p_end) {
        IntTreeNode l_root = new IntTreeNode(p_inputs[p_end]);

        if (p_start == p_end) {
            return l_root;
        }

        int l_splitter = p_end - 1;
        for (; l_splitter >= p_start; l_splitter--) {
            if (p_inputs[l_splitter] <= l_root.getValue()) {
                break;
            }
        }

        if (p_start <= l_splitter) {
            IntTreeNode l_leftSub = convert(p_inputs, p_start, l_splitter);

            if (l_leftSub.getValue() >= l_root.getValue()) {
                throw new IllegalArgumentException();
            }

            l_root.setLeft(l_leftSub);
        }

        if (l_splitter <= p_end - 1) {
            IntTreeNode l_rightSub = convert(p_inputs, l_splitter + 1, p_end - 1);

            if (l_rightSub.getValue() <= l_root.getValue()) {
                throw new IllegalArgumentException();
            }

            l_root.setRight(l_rightSub);
        }

        return l_root;
    }

    @Test
    public void case1() {
        N009_CheckTreePostOrderVisitResult l_checker = new N009_CheckTreePostOrderVisitResult();

        int[] l_inputs = null;
        TreeNode l_root = null;
        l_inputs = new int[] {5, 7, 6, 9, 11, 10, 8};
        l_root = l_checker.convert(l_inputs, 0, l_inputs.length - 1);
        System.out.println(l_root);
    }
}
