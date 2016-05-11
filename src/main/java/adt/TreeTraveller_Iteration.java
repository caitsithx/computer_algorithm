package adt;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by caitsithx on 2016/4/26.
 */
public class TreeTraveller_Iteration {

    public static <T> void lnr(TreeNode<T> tree, TreeTraveller.Action<T> action) {
        if (tree == null) {
            throw new IllegalArgumentException();
        }

        ArrayBasedStack<TreeNode<T>> stack = new ArrayBasedStack<>(1000);

        TreeNode<T> node = tree;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                action.onValue(node.getValue());
                node = node.getRight();
            }
        }
    }

    public static <T> void nlr(TreeNode<T> tree, TreeTraveller.Action<T> action) {
        if (tree == null) {
            throw new IllegalArgumentException();
        }

        action.onValue(tree.getValue());

        if (tree.getLeft() != null) {
            nlr(tree.getLeft(), action);
        }

        if (tree.getRight() != null) {
            nlr(tree.getRight(), action);
        }
    }

    public static <T> void lrn(TreeNode<T> tree, TreeTraveller.Action<T> action) {
        if (tree == null) {
            throw new IllegalArgumentException();
        }

        if (tree.getLeft() != null) {
            lrn(tree.getLeft(), action);
        }

        if (tree.getRight() != null) {
            lrn(tree.getRight(), action);
        }

        action.onValue(tree.getValue());

    }

}
