package adt;


/**
 * Created by caitsithx on 2016/4/26.
 */
public class TreeTraveller {
    public static interface Action<T> {
        void onValue(T value);
    }

    public static <T> void lnr(TreeNode<T> tree, Action<T> action) {
        if(tree == null) {
            throw new IllegalArgumentException();
        }

        if(tree.getLeft() != null) {
            lnr(tree.getLeft(), action);
        }

        action.onValue(tree.getValue());

        if(tree.getRight() != null) {
            lnr(tree.getRight(), action);
        }
    }

    public static <T> void nlr(TreeNode<T> tree, Action<T> action) {
        if(tree == null) {
            throw new IllegalArgumentException();
        }

        action.onValue(tree.getValue());

        if(tree.getLeft() != null) {
            nlr(tree.getLeft(), action);
        }

        if(tree.getRight() != null) {
            nlr(tree.getRight(), action);
        }
    }

    public static <T> void lrn(TreeNode<T> tree, Action<T> action) {
        if(tree == null) {
            throw new IllegalArgumentException();
        }

        if(tree.getLeft() != null) {
            lrn(tree.getLeft(), action);
        }

        if(tree.getRight() != null) {
            lrn(tree.getRight(), action);
        }

        action.onValue(tree.getValue());

    }

}
