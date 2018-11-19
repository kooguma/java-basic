package concurrency.book1.sample.chapter4;

import concurrency.book1.annotations.Immutable;

@Immutable
public class Point {

    public final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
