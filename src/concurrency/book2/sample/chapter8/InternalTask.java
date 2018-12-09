package concurrency.book2.sample.chapter8;

/**
 * 用于线程池内部，不断从queue中取出某个runnable
 */
public class InternalTask implements Runnable {

    private final RunnableQueue runnableQueue;

    private volatile boolean running = true;

    public InternalTask(RunnableQueue runnableQueue) {
        this.runnableQueue = runnableQueue;
    }

    @Override
    public void run() {

        while (running && !Thread.currentThread().isInterrupted()) {
            try {
                Runnable task = runnableQueue.take();
                task.run();
            } catch (InterruptedException e) {
                running = false;
                break;
            }
        }
    }

    //停止当前任务，主要会在线程的shutdown方法中使用
    public void stop() {
        this.running = false;
    }

}
