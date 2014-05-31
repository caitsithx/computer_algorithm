/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
package algorithm.puzzle100.util;

import algorithm.puzzle100.struct.Node;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 */
public class BinarySearchTreeUtiler {

    /**
     * @param p_binarySearchTree
     * @param p_visitListener
     */
    public void midOrderVisit(Node p_binarySearchTree, IVisitListener p_visitListener) {
        //TODO CHECK INPUT
        NODE_TYPE l_type;

        if (p_binarySearchTree.getPrevious() != null) {
            midOrderVisit(p_binarySearchTree.getPrevious(), p_visitListener);
            l_type = NODE_TYPE.LEFT_LEAF;
        } else {
            l_type = NODE_TYPE.ROOT;
        }

        p_visitListener.visit(p_binarySearchTree, NODE_TYPE.ROOT);

        if (p_binarySearchTree.getNext() != null) {
            midOrderVisit(p_binarySearchTree.getNext(), p_visitListener);
        } else {

        }
    }

    public enum NODE_TYPE {
        LEFT_LEAF,
        ROOT,
        RIGH_LEAF
    }

    public interface IVisitListener {
        void visit(Node p_currentVisitingNode, NODE_TYPE p_type);
    }
}
