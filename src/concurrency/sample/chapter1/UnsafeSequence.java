package concurrency.sample.chapter1;

import concurrency.annotations.NotThreadSafe;

@NotThreadSafe
public class UnsafeSequence implements ISequence{
    private int nextValue;

    public int getNext() {
        return nextValue++;
    }

}
