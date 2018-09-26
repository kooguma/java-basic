package concurrency.sample.chapter1_1;

import concurrency.annotations.GuardedBy;
import concurrency.annotations.NotThreadSafe;

@NotThreadSafe
public class Sequence implements ISequence {
    @GuardedBy("this")
    private int nextValue;

    public synchronized int getNext() {
        return nextValue++;
    }

}
