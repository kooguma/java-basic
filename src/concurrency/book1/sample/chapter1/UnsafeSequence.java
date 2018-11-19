package concurrency.book1.sample.chapter1;

import concurrency.book1.annotations.NotThreadSafe;

@NotThreadSafe
public class UnsafeSequence implements ISequence{
    private int nextValue;

    public int getNext() {
        return nextValue++;
    }

}
