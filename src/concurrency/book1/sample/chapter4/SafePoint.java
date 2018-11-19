package concurrency.book1.sample.chapter4;

import concurrency.book1.annotations.GuardedBy;
import concurrency.book1.annotations.ThreadSafe;

@ThreadSafe
public class SafePoint {

    @GuardedBy("this")
    private int x, y;

    private SafePoint(int a[]) {
        this(a[0], a[1]);
    }

    public SafePoint(SafePoint p) {
        this(p.get());
    }

    public SafePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public synchronized int[] get() {
        return new int[]{x, y};
    }

    public synchronized int[] set(int x, int y) {
        return new int[]{x, y};
    }
}
