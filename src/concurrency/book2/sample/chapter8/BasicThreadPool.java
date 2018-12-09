package concurrency.book2.sample.chapter8;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class BasicThreadPool extends Thread implements ThreadPool {

    //初始化线程数量
    private final int initSize;
    //线程池最大线程数量
    private final int maxSize;
    //线程池核心线程数量
    private final int coreSize;
    //当前活跃的线程数量
    private int activeCount;
    //创建线程所需要的工厂
    private final ThreadFactory threadFactory;
    //任务队列
    private final RunnableQueue runnableQueue;
    //线程池是否已经被 shutdown
    private volatile boolean isShutdown = false;
    //工作线程队列
    private final Queue<ThreadTask> threadQueue = new ArrayDeque<>();

    private final static DenyPolicy DEFAULT_DENY_POLICY = new DenyPolicy.DiscardDenyPolicy();

    private final static ThreadFactory DEFAULT_THREAD_FACTORY = new DefaultThreadFactory();

    private final long keepAliveTime;

    private final TimeUnit timeUnit;


    public BasicThreadPool(int initSize, int maxSize, int coreSize, int queueSize) {
        this(initSize, maxSize, coreSize, DEFAULT_THREAD_FACTORY, queueSize, DEFAULT_DENY_POLICY, 10, TimeUnit.SECONDS);
    }


    public BasicThreadPool(int initSize, int maxSize, int coreSize, ThreadFactory threadFactory, int queueSize, DenyPolicy denyPolicy, long keepAliveTime, TimeUnit timeUnit) {
        this.initSize = initSize;
        this.maxSize = maxSize;
        this.coreSize = coreSize;
        this.threadFactory = threadFactory;
        this.runnableQueue = new LinkedRunnableQueue(queueSize, denyPolicy, this);
        this.keepAliveTime = keepAliveTime;
        this.timeUnit = timeUnit;
        this.init();
    }

    private void init() {
        start();
        for (int i = 0; i < initSize; i++) {
            newThread();
        }
    }

    private void newThread() {
        //创建任务线程，并且启动
        InternalTask internalTask = new InternalTask(runnableQueue);
        Thread thread = this.threadFactory.createThread(internalTask);
        ThreadTask threadTask = new ThreadTask(thread, internalTask);
        threadQueue.offer(threadTask);
        this.activeCount++;
        thread.start();
    }

    private void removeThread() {
        //从线程池中移除某个线程
        ThreadTask threadTask = threadQueue.remove();
        threadTask.internalTask.stop();
        this.activeCount--;
    }

    @Override
    public void run() {
        //用于维护线程数量，比如扩容、回收等工作
        while (!isShutdown && !isInterrupted()) {
            try {
                timeUnit.sleep(keepAliveTime);
            } catch (InterruptedException e) {
                isShutdown = true;
                break;
            }
            synchronized (this) {
                if (isShutdown)
                    break;
                //当前的队列中有任务尚未处理完成，并且activeCount<coreSize则继续扩容
                if (runnableQueue.size() > 0 && activeCount < coreSize) {
                    for (int i = initSize; i < coreSize; i++) {
                        newThread();
                    }
                    //不想容器直接扩容达到maxSize
                    continue;
                }
                //当前的队列中有任务尚未处理完成，并且activeCount<MaxSize则继续扩容
                if (runnableQueue.size() > 0 && activeCount < maxSize) {
                    for (int i = coreSize; i < maxSize; i++) {
                        newThread();
                    }
                }
                //如果任务队列中没有任务，则需要回收，回收至coreSize即可
                if (runnableQueue.size() == 0 && activeCount > coreSize) {
                    removeThread();
                }
            }
        }
    }

    @Override
    public void execute(Runnable runnable) {
        if (this.isShutdown)
            throw new IllegalStateException("The thread pool is destroy");
        //提交任务知识简单地往任务队列中插入Runnable
        this.runnableQueue.offer(runnable);
    }

    @Override
    public void shutdown() {
        synchronized (this) {
            if (isShutdown) return;
            isShutdown = true;
            threadQueue.forEach(threadTask -> {
                threadTask.internalTask.stop();
                threadTask.thread.interrupt();
            });
            this.interrupt();
        }
    }

    @Override
    public int getInitSize() {
        if (isShutdown)
            throw new IllegalStateException("The thread pool is destroy");
        return this.initSize;
    }

    @Override
    public int getMaxSize() {
        if (isShutdown)
            throw new IllegalStateException("The thread pool is destroy");
        return this.maxSize;
    }

    @Override
    public int getCoreSize() {
        if (isShutdown)
            throw new IllegalStateException("The thread pool is destroy");
        return this.coreSize;
    }

    @Override
    public int getQueueSize() {
        if (isShutdown)
            throw new IllegalStateException("The thread pool is destroy");
        return this.runnableQueue.size();
    }

    @Override
    public int getActiveCount() {
        synchronized (this) {
            return this.activeCount;
        }
    }

    @Override
    public boolean isShutDown() {
        return this.isShutdown;
    }

    private static class ThreadTask {

        Thread thread;
        InternalTask internalTask;

        public ThreadTask(Thread thread, InternalTask internalTask) {
            this.thread = thread;
            this.internalTask = internalTask;
        }

    }
}
