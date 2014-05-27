package adt;

import org.junit.Test;

import java.util.Comparator;

/**
 * Created by caitsithx on 14-5-27.
 */
public class TestBinaryTree {
    @Test
    public void testBuild() {
        BinaryTree<Integer> bTree = new BinaryTree<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        int[] vals = {5, 3, 7, 1, 2, 4, 6, 8, 9};

        for(int i = 0; i < vals.length; i ++) {
            bTree.insert(vals[i]);
        }

        System.out.println();
    }

    @Test
    public void testFind() {
        BinaryTree<Integer> bTree = new BinaryTree<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        int[] vals = {5, 3, 7, 1, 2, 4, 6, 8, 9};

        for(int i = 0; i < vals.length; i ++) {
            bTree.insert(vals[i]);
        }

        System.out.println(bTree.find(8));
    }

    @Test
    public void testDelete() {
        BinaryTree<Integer> bTree = new BinaryTree<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        int[] vals = {5, 3, 7, 1, 2, 4, 6, 8, 9};

        for(int i = 0; i < vals.length; i ++) {
            bTree.insert(vals[i]);
        }

        bTree.delete(7);

        System.out.println();
    }

    @Test
    public void testDelete1() {
        BinaryTree<Integer> bTree = new BinaryTree<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        int[] vals = {5, 3, 7, 1, 2, 4, 6, 8, 9};

        for(int i = 0; i < vals.length; i ++) {
            bTree.insert(vals[i]);
        }

        bTree.delete(5);

        System.out.println();
    }
}
