package datastructure.Tree.binarytree;

/**
 * Created by lzz on 2017/3/26.
 * 二叉查找树
 */
public class MyBinarySearchTree<T extends Comparable<? super T>> {

    private static class BinaryNode<T> {
        T e;
        BinaryNode<T> left;
        BinaryNode<T> right;

        public BinaryNode(T e) {
            this(e, null, null);
        }

        public BinaryNode(T e, BinaryNode<T> left, BinaryNode<T> right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }
    }

    private BinaryNode<T> root;

    public MyBinarySearchTree() {
        this.root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T x) {
        return contains(x, root);
    }

    public T findMin() {
        if (isEmpty()) throw new IllegalStateException("this binary search tree is empty!");
        return findMin(root).e;
    }

    public T findMax() {
        if (isEmpty()) throw new IllegalStateException("this binary search tree is empty!");
        return findMax(root).e;
    }

    public void insert(T x) {
        root = insert(x, root);
    }

    public void remove(T x) {
        root = remove(x, root);
    }

    public void printTree() {
        if (isEmpty()) {
            System.out.println("Empty Tree");
        } else {
            printTree(root);
        }
    }

    public int height() {
        return height(root);
    }

    private boolean contains(T x, BinaryNode<T> t) {
        if (t == null) return false;
        int compareResult = x.compareTo(t.e);
        if (compareResult < 0) {
            return contains(x, t.left);
        } else if (compareResult > 0) {
            return contains(x, t.right);
        } else {
            return true;
        }
    }

    private BinaryNode<T> findMin(BinaryNode<T> t) {
        if (t == null) {
            return null;
        } else if (t.left == null) {
            return t;
        }
        return findMin(t.left);
    }

    private BinaryNode<T> findMax(BinaryNode<T> t) {
        if (t != null) {
            while (t.right != null) {
                t = t.right;
            }
        }
        return t;
    }

    private BinaryNode<T> insert(T x, BinaryNode<T> t) {
        if (t == null) {
            return new BinaryNode<T>(x);
        }
        int compareResult = x.compareTo(t.e);
        if (compareResult < 0) {
            return insert(x, t.left);
        } else if (compareResult > 0) {
            return insert(x, t.right);
        } else {
            return t;
        }
    }

    private BinaryNode<T> remove(T x, BinaryNode<T> t) {
        if (t == null) {
            return t;
        }
        int compareResult = x.compareTo(t.e);
        if (compareResult < 0) {
            t.left = remove(x, t.left);
        } else if (compareResult > 0) {
            t.right = remove(x, t.right);
        } else if (t.left != null && t.right != null) {
            T e = findMin(t.right).e;
            t.right = remove(e, t.right);
        } else {
            t = t.right == null ? t.left : t.right;
        }
        return t;
    }


    private void printTree(BinaryNode<T> t) {
        if (t != null) {
            printTree(t.left);
            System.out.print(t.e);
            printTree(t.right);
        }
    }

    private int height(BinaryNode<T> t) {
        if (t == null) {
            return -1;
        } else {
            return 1 + Math.max(height(t.right), height(t.left));
        }
    }


}
