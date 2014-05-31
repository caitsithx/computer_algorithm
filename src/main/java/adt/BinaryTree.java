package adt;

import java.util.Comparator;

/**
 * Created by caitsithx on 14-5-27.
 */
public class BinaryTree<T> {
    private Node<T> root;
    private Comparator<T> comparator;

    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void insert(T newVal) {
        if (newVal == null) {
            throw new IllegalArgumentException();
        }

        if (root == null) {
            root = new Node<>(newVal);
            return;
        }

        Node<T> tmp = root;
        int compRes = -1;

        while (tmp != null) {
            compRes = comparator.compare(newVal, tmp.value);
            if (compRes > 0) {
                if (tmp.right == null) {
                    tmp.right = new Node<>(newVal);
                    break;
                }
                tmp = tmp.right;
            } else if (compRes < 0) {
                if (tmp.left == null) {
                    tmp.left = new Node<>(newVal);
                    break;
                }
                tmp = tmp.left;
            } else {
                tmp.count++;
                break;
            }
        }
    }

    public boolean find(T val) {
        if (val == null) {
            throw new IllegalArgumentException();
        }

        Node<T> tmp = root;
        int compRes = -1;

        while (tmp != null) {
            compRes = comparator.compare(val, tmp.value);
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
        if (val == null) {
            throw new IllegalArgumentException();
        }

        if (root == null) {
            return false;
        }

        Node<T> tmpParent = null;
        Node<T> tmp = root;
        int compRes = -1;

        boolean leftOrRight = false;
        while (tmp != null) {
            compRes = comparator.compare(val, tmp.value);
            if (compRes > 0) {
                tmpParent = tmp;
                tmp = tmp.right;
                leftOrRight = false;
            } else if (compRes < 0) {
                tmpParent = tmp;
                tmp = tmp.left;
                leftOrRight = true;
            } else {
                if (tmpParent == null) {
                    root = delete(root);
                } else {
                    if (leftOrRight) {
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
        if (node == null) {
            throw new IllegalArgumentException();
        }

        if (node.left != null && node.right != null) {
            Node<T> tmpParent = deleteMin(node.right);
            tmpParent.left = node.left;
            return tmpParent;
        } else {
            //right != null : right; left != null : left; otherwise null;
            return node.right != null ? node.right : node.left;
        }
    }

    private Node<T> deleteMin(Node<T> right) {
        if (right == null) {
            throw new IllegalArgumentException();
        }

        if (right.left == null) {
            return right;
        }

        Node<T> tmpParent = right;
        Node<T> tmp = right.left;
        while (tmp.left != null) {
            tmp = tmp.left;
        }

        if (tmp.right != null) {
            tmpParent.left = tmp.right;
        } else {
            tmpParent.left = null;
        }

        tmp.right = right;

        return tmp;
    }

    private class Node<T> {
        private int count = 0;
        private T value;
        private Node<T> left;
        private Node<T> right;

        public Node(T newVal) {
            value = newVal;
            count = 1;
        }

        public String toString() {
            return value.toString();
        }
    }

}
