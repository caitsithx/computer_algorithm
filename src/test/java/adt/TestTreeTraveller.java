package adt;

import org.junit.jupiter.api.Test;

/**
 * Created by caitsithx on 2016/4/26.
 */
public class TestTreeTraveller {
    private TreeNode<String> tree;

    public TestTreeTraveller() {
        tree = new TreeNode<String>("root");
        tree.setLeft(new TreeNode("root_left"));
        tree.setRight(new TreeNode("root_right"));

        tree.getLeft().setLeft(new TreeNode("root_left_left"));
        tree.getLeft().setRight(new TreeNode("root_left_right"));

        tree.getRight().setLeft(new TreeNode("root_right_left"));
        tree.getRight().setRight(new TreeNode("root_right_right"));

    }

    @Test
    public void testLnr() {
        TreeTraveller.lnr(tree, System.out::println);
    }

    @Test
    public void testLnr_iter() {
        TreeTraveller_Iteration.lnr(tree, System.out::println);
    }

    @Test
    public void testNlr() {
        TreeTraveller.nlr(tree, System.out::println);
    }

    @Test
    public void testLrn() {
        TreeTraveller.lrn(tree, System.out::println);
    }
}
