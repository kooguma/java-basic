package concurrency.sample.chapter8;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 定制线程行为：
 * 指定名字
 * 自定义 UncaughtExceptionHandler 向 Logger 写入信息
 * 维护统计信息（多少个线程呗创建和销毁）
 * 在线程被创建或者种植时把调试消息写入日志
 */
public class MyAppThread extends Thread {

    public static final String DEFAULT_NAME = "MyAppThread";

    private static volatile boolean debugLifecycle = false;

    private static final AtomicInteger created = new AtomicInteger();

    private static final AtomicInteger alive = new AtomicInteger();

    private static final Logger log = Logger.getAnonymousLogger();

    public MyAppThread(Runnable r) {
        super(r, DEFAULT_NAME);
    }

    public MyAppThread(Runnable r, String name) {
        super(r, name + "-" + created.incrementAndGet());
        setUncaughtExceptionHandler((t, e) -> {
            log.log(Level.SEVERE, "UNCAUGHT in thread " + t.getName(), e);
        });
    }

    public void run() {
        boolean debug = debugLifecycle;
        if (debug) log.log(Level.FINE, "Created " + getName());
        try {
            alive.incrementAndGet();
            super.run();
        } finally {
            alive.decrementAndGet();
            if (debug) log.log(Level.FINE, "Exiting " + getName());
        }
    }

    public static int getThreadsCreated() {
        return created.get();
    }

    public static int getThreadsAlive() {
        return alive.get();
    }

    public static boolean getDebug() {
        return debugLifecycle;
    }

    public static void setDebug(boolean b) {
        debugLifecycle = b;
    }
}
