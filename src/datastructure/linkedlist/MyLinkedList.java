package datastructure.linkedlist;

import datastructure.Iterable;
import datastructure.Iterator;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

/**
 * Created by lzz on 2017/3/19.
 */
public class MyLinkedList<T> implements Iterable<T> {

    private int theSize;
    private int modCount = 0;
    private Node<T> beginMarker;
    private Node<T> endMarker;

    private static class Node<T> {
        public T data;
        public Node<T> prev;
        public Node<T> next;

        public Node(T d, Node<T> p, Node<T> n) {
            this.data = d;
            this.prev = p;
            this.next = n;
        }
    }

    public MyLinkedList() {
        clear();
    }

    public void clear() {
        beginMarker = endMarker = new Node<T>(null, null, null);
        beginMarker.next = endMarker;
        endMarker.prev = beginMarker;
        theSize = 0;
        modCount++;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean add(T x) {
        add(size(), x);
        return true;
    }

    public void add(int idx, T x) {
        addBefore(getNode(idx), x);
    }

    public T get(int idx) {
        return getNode(idx).data;
    }

    //先链接，后断开，"又"字型顺序
    private void addBefore(Node<T> p, T x) {
        Node<T> newNode = new Node<T>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }


    private T remove(Node<T> p) {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        modCount++;
        return p.data;
    }

    private Node<T> getNode(int idx) {
        Node<T> p;

        if (idx < 0 || idx > size()) {
            throw new IndexOutOfBoundsException();
        }

        if (idx < size() / 2) {
            p = beginMarker.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = size(); i > idx; i++) {
                p = p.prev;
            }
        }
        return p;

    }


    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }


    /* JAVA 快速失败机制 fail - fast
     * 如果对正在被迭代对集合进行结构上对改变，那么迭代器就不再合法 ConcurrentModificationException
     * 未了避免迭代器给出某一项作为下一项时，出现该项被删除，或者新对一项刚好插入到后面，但调用迭代器但remove 方法时合法的
     * 迭代器概念：http://wiki.jikexueyuan.com/project/java-enhancement/java-thirty.html
     * 关于ConcurrentModificationException ：http://cmsblogs.com/?p=1220
     */
    private class LinkedListIterator implements Iterator<T> {

        private Node<T> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public T next() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(current.prev);
            okToRemove = false;
            expectedModCount++;
        }
    }
}
