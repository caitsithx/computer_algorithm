/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
/*
第11题
求二叉树中节点的最大距离...
如果我们把二叉树看成一个图，
父子节点之间的连线看成是双向的，
我们姑且定义"距离"为两节点之间边的个数。
写一个程序，
求一棵二叉树中相距最远的两个节点之间的距离。
 */
package algorithm.puzzle100;

import adt.TreeNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 */
public class N011_MaxDistanceInBiTreeGraph {

    public int[] getMax(TreeNode p_root) {

        if (p_root.getLeft() == null && p_root.getRight() == null) {
            return new int[] {0, 0};
        } else if (p_root.getLeft() != null && p_root.getRight() != null) {
            int[] l_left = getMax(p_root.getLeft());
            int[] l_right = getMax(p_root.getRight());

            int l_maxCurrent = l_left[1] + l_right[1] + 2;
            l_maxCurrent = l_maxCurrent > l_left[0] ? l_maxCurrent : l_left[0];
            l_maxCurrent = l_maxCurrent > l_right[0] ? l_maxCurrent : l_right[0];

            int l_maxBranch = (l_left[1] > l_right[1] ? l_left[1] : l_right[1]) + 1;

            return new int[] {l_maxCurrent, l_maxBranch};
        }

        TreeNode l_subTreeRoot = p_root.getLeft() != null ? p_root.getLeft() : p_root.getRight();

        return getMaxSingleSubTree(l_subTreeRoot);
    }

    private int[] getMaxSingleSubTree(TreeNode p_subRoot) {
        int[] l_right = getMax(p_subRoot);

        int l_maxCurrent = l_right[1] + 1;
        l_maxCurrent = l_maxCurrent > l_right[0] ? l_maxCurrent : l_right[0];
        int l_maxBranch = l_right[1] + 1;
        return new int[] {l_maxCurrent, l_maxBranch};
    }

    @Test
    public void case1() {
        TreeNode l_4 = new TreeNode(4);
        TreeNode l_7 = new TreeNode(7);
        TreeNode l_5 = new TreeNode(5, l_4, l_7);


        TreeNode l_12 = new TreeNode(12);

        TreeNode l_10 = new TreeNode(10, l_5, l_12);

        N011_MaxDistanceInBiTreeGraph l_MaxGetter = new N011_MaxDistanceInBiTreeGraph();
        System.out.println(Arrays.toString(l_MaxGetter.getMax(l_10)));
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

        N011_MaxDistanceInBiTreeGraph l_MaxGetter = new N011_MaxDistanceInBiTreeGraph();
        System.out.println(Arrays.toString(l_MaxGetter.getMax(l_10)));
    }
}
