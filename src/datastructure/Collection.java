package datastructure;

/**
 * Created by lzz on 2017/3/11.
 *
 */
public interface Collection<T> extends Iterable {
    int size();

    boolean isEmpty();

    void clear();

    boolean contains(T x);

    boolean add(T x);

    void add(int idx, T x);

    T remove(int idx);

    Iterator<T> iterator();
}
