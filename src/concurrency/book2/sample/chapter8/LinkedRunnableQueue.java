package concurrency.book2.sample.chapter8;

import java.util.LinkedList;

public class LinkedRunnableQueue implements RunnableQueue {

    //任务队列的最大容量，在构造时传入
    private final int limit;

    //拒绝策略
    private final DenyPolicy depolicy;

    //存放任务的队列
    private final LinkedList<Runnable> runnableList = new LinkedList<>();

    private final ThreadPool threadPool;

    public LinkedRunnableQueue(int limit, DenyPolicy depolicy, ThreadPool threadPool) {
        this.limit = limit;
        this.depolicy = depolicy;
        this.threadPool = threadPool;
    }

    @Override
    public void offer(Runnable runnable) {
        synchronized (runnableList) {
            if (runnableList.size() >= limit) {
                //无法容纳新的任务拒绝策略
                depolicy.reject(runnable, threadPool);
            } else {
                //将任务加入到队尾，并且唤醒阻塞中的线程
                runnableList.addLast(runnable);
                runnableList.notifyAll();
            }
        }
    }

    @Override
    public Runnable take() throws InterruptedException {
        synchronized (runnableList) {
            while (runnableList.isEmpty()) {
                try {
                    //如果任务队列中没有可执行任务，则当前线程将会挂起，进入monitor wait set中等待唤醒
                    runnableList.wait();
                } catch (InterruptedException e) {
                    throw e;
                }
            }
        }
        //从任务队列头部移除一个任务
        return runnableList.removeFirst();
    }


    @Override
    public int size() {
        synchronized (runnableList){
            return runnableList.size();
        }
    }
}
