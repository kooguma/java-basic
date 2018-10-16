package concurrency.sample.chapter4;

import concurrency.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ThreadSafe
public class ListHelper<E> {

    public List<E> list
            = Collections.synchronizedList(new ArrayList<>());

    public boolean putIfAbsent(E x) {
        synchronized (list) {
            boolean absent = !list.contains(x);
            if (absent)
                list.add(x);
            return absent;
        }
    }
}
