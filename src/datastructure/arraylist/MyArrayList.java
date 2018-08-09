package datastructure.arraylist;

import datastructure.Collection;
import datastructure.Iterator;

import java.util.NoSuchElementException;

/**
 * Created by kumaj on 2017/3/11.
 * 1.基础数组、数组容量、当前项数
 * 2.改变数组容量 ensureCapacity
 * 3.get set
 * 4.size isEmpty clear remove add
 * 5.iterator
 */
public class MyArrayList<T> implements Collection<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private int theSize;
    private T[] theItems;

    public MyArrayList() {
        clear();
    }

    @Override
    public void clear() {
        theSize = 0;
        ensureCapacity(theSize);
    }

    @Override
    public int size() {
        return theSize;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    public T get(int idx) {
        if (idx < 0 || idx > size())
            throw new ArrayIndexOutOfBoundsException();
        return theItems[idx];
    }

    public T set(int idx, T newVal) {
        if (idx < 0 || idx > size())
            throw new ArrayIndexOutOfBoundsException();
        T oldItem = theItems[idx];
        theItems[idx] = newVal;
        return oldItem;
    }

    @Override
    public boolean contains(T x) {
        for (int i = 0; i < size(); i++) {
            if (theItems[i].equals(x)) return true;
        }
        return false;
    }

    @Override
    public boolean add(T x) {
        add(size(), x);
        return true;
    }

    @Override
    public void add(int idx, T x) {
        if (theItems.length == size())
            ensureCapacity(size() * 2 + 1);
        for (int i = theSize; i > idx; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[idx] = x;
        theSize++;
    }

    @Override
    public T remove(int idx) {
        T removedItem = theItems[idx];
        for (int i = idx; i < size(); i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize--;
        return removedItem;
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity(int newCapacity) {
        // TODO: 2017/3/11 System.arrayCopy ()
        if (newCapacity < theSize)
            return;
        T[] old = theItems;
        theItems = (T[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }


    private class ArrayListIterator implements Iterator<T> {

        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }
}
