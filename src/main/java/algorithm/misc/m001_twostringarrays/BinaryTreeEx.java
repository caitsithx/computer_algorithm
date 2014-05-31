package algorithm.misc.m001_twostringarrays;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by lixl on 5/31/14.
 */
public class BinaryTreeEx<T extends Comparable<T>> {
    private Node<T> root;
    private Comparator<T> comparator;
    private ArrayList<T> union = new ArrayList<>();
    private ArrayList<T> insect = new ArrayList<>();
    private ArrayList<T> minus = new ArrayList<>();

    public BinaryTreeEx(Comparator<T> comparator) {
        this.comparator = comparator;
    }


    public BinaryTreeEx() {
        //no comparator
    }

    private int compare(T left, T right) {
        if (comparator != null) {
            return comparator.compare(left, right);
        }

        return left.compareTo(right);
    }

    public void insert(T newVal, int sourceId) {
        if (newVal == null) {
            throw new IllegalArgumentException();
        }

        if (root == null) {
            root = new Node<>(newVal, sourceId);
            return;
        }

        root = insert(newVal, sourceId, root);
    }

    public Node<T> insert(T newVal, int sourceId, Node<T> node) {
        int compRes = compare(newVal, node.value);

        if (compRes == 0) {
            node.duplicate();

            return node;
        } else {
            if (compRes < 0) {
                if (node.left == null) {
                    node.left = new Node<>(newVal, sourceId);
                    node.leftHeight = 1;

                    return node;
                } else {
                    node.left = insert(newVal, sourceId, node.left);

                    //update heights of left and right sub-tree
                    node.leftHeight = 1 + node.left.leftHeight > node.left.rightHeight ?
                        node.left.leftHeight : node.left.rightHeight;

                    //check if rotate needed
                    if (node.leftHeight - node.rightHeight > 1) {
                        if (node.left.leftHeight > node.left.rightHeight) {
                            return rotateWithLeftChild(node);
                        } else {
                            return doubleRotateWithLeftChild(node);
                        }
                    }

                    return node;
                }
            } else {
                if (node.right == null) {
                    node.right = new Node<>(newVal, sourceId);
                    node.rightHeight = 1;

                    return node;
                } else {
                    node.right = insert(newVal, sourceId, node.right);

                    //update heights of left and right sub-tree
                    node.rightHeight = 1 + node.right.rightHeight > node.right.leftHeight ?
                        node.right.rightHeight : node.right.leftHeight;

                    if (node.leftHeight - node.rightHeight > 1) {
                        if (node.right.rightHeight == node.right.leftHeight) {
                            return rotateWithRightChild(node);
                        } else {
                            return doubleRotateWithRightChild(node);
                        }
                    }

                    return node;

                }
            }
        }
    }

    private Node<T> doubleRotateWithRightChild(Node<T> node) {
        node.right = rotateWithLeftChild(node.right);

        return rotateWithRightChild(node);
    }

    private Node<T> rotateWithRightChild(Node<T> node) {
        return null;
    }

    private Node<T> doubleRotateWithLeftChild(Node<T> node) {
        node.left = rotateWithRightChild(node.left);

        return rotateWithLeftChild(node);
    }

    private Node<T> rotateWithLeftChild(Node<T> node) {
        return null;
    }

    public void visit() {
        parentFirstVisit(root);
    }

    private void parentFirstVisit(Node<T> node) {
        if (node == null) {
            return;
        }

        union.add(node.value);
        if (node.count > 1) {
            insect.add(node.value);
        } else {
            minus.add(node.value);
        }

        parentFirstVisit(node.left);
        parentFirstVisit(node.right);
    }

    enum SIDE {
        LEFT, RIGHT, NO
    }

    private class Node<T> {
        private int sourceId = -1;
        private int count = 0;
        private T value;
        private Node<T> left;
        private Node<T> right;

        private int leftHeight = 0;
        private int rightHeight = 0;

        public Node(T newVal, int sourceId) {
            value = newVal;
            count = 1;
            this.sourceId = sourceId;
        }

        public void duplicate() {
            count++;
        }

        public String toString() {
            return value.toString();
        }
    }

    /**
     public boolean find(T val) {
     if(val == null) {
     throw new IllegalArgumentException();
     }

     Node<T> tmp = root;
     int compRes = -1;

     while(tmp != null) {
     compRes = compare(val, tmp.value);
     if (compRes > 0) {
     tmp = tmp.right;
     } else if (compRes < 0) {
     tmp = tmp.left;
     } else {
     return true;
     }
     }

     return false;
     }

     public boolean delete(T val) {
     if(val == null) {
     throw new IllegalArgumentException();
     }

     if(root == null) {
     return false;
     }

     Node<T> tmpParent = null;
     Node<T> tmp = root;
     int compRes = -1;

     boolean leftOrRight = false;
     while(tmp != null) {
     compRes = compare(val, tmp.value);
     if (compRes > 0) {
     tmpParent = tmp;
     tmp = tmp.right;
     leftOrRight = false;
     } else if (compRes < 0) {
     tmpParent = tmp;
     tmp = tmp.left;
     leftOrRight = true;
     } else {
     if(tmpParent == null) {
     root = delete(root);
     } else {
     if(leftOrRight) {
     tmpParent.left = delete(tmp);
     } else {
     tmpParent.right = delete(tmp);
     }
     }
     return true;
     }
     }

     return false;
     }

     private Node<T> delete(Node<T> node) {
     if(node == null) {
     throw new IllegalArgumentException();
     }

     if(node.left != null && node.right != null) {
     Node<T> tmpParent = deleteMin(node.right);
     tmpParent.left = node.left;
     return tmpParent;
     } else {
     //right != null : right; left != null : left; otherwise null;
     return node.right != null ? node.right : node.left;
     }
     }

     private Node<T> deleteMin(Node<T> right) {
     if(right == null) {
     throw new IllegalArgumentException();
     }

     if(right.left == null) {
     return right;
     }

     Node<T> tmpParent = right;
     Node<T> tmp = right.left;
     while(tmp.left != null) {
     tmp = tmp.left;
     }

     if(tmp.right != null) {
     tmpParent.left = tmp.right;
     } else {
     tmpParent.left = null;
     }

     tmp.right = right;

     return tmp;
     }

     **/
}
