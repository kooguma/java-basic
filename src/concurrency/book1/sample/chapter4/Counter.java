package concurrency.book1.sample.chapter4;

import concurrency.book1.annotations.GuardedBy;
import concurrency.book1.annotations.ThreadSafe;

@ThreadSafe
public final class Counter {

    @GuardedBy("this")
    private long value = 0;

    public synchronized long getValue() {
        return value;
    }

    public synchronized long increment() {
        if (value == Long.MAX_VALUE) {
            throw new IllegalStateException("counter overflow");
        }
        return ++value;
    }
}
