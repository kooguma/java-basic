package concurrency.book2.sample.chapter8;

@FunctionalInterface
public interface ThreadFactory {

    Thread createThread(Runnable runnable);
}
