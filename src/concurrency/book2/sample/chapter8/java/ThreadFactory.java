package concurrency.book2.sample.chapter8.java;

@FunctionalInterface
public interface ThreadFactory {

    Thread createThread(Runnable runnable);
}
