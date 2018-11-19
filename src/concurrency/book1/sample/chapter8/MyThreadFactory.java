package concurrency.book1.sample.chapter8;

import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {

    private final String poolName;


    public MyThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    @Override
    public Thread newThread(Runnable r) {
        return null;
    }

}
