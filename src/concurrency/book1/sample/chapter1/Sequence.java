package concurrency.book1.sample.chapter1;

import concurrency.book1.annotations.GuardedBy;
import concurrency.book1.annotations.NotThreadSafe;

@NotThreadSafe
public class Sequence implements ISequence {
    @GuardedBy("this")
    private int nextValue;

    public synchronized int getNext() {
        return nextValue++;
    }

}
