package concurrency.book2.sample.chapter5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

/**
 * 用来解决 Synchronized 的2个缺陷
 * 第一，无法控制阻塞时长
 * 第二，阻塞不可被中断
 */
public class BooleanLock implements Lock {


    private Thread currentThread;

    private boolean locked = false;

    private final List<Thread> blockedList = new ArrayList<>();

    @Override
    public void lock() throws InterruptedException {

        synchronized (this) {
            while (locked) {
                blockedList.add(Thread.currentThread());
                this.wait();
            }
            blockedList.remove(Thread.currentThread());
            this.locked = true;
            currentThread = Thread.currentThread();
        }
    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeoutException {

        synchronized (this) {
            if (mills <= 0) {
                this.lock();
            } else {
                long remainingMills = mills;
                long endMills = System.currentTimeMillis() + remainingMills;
                while (locked) {
                    if (remainingMills <= 0)
                        //当前线程被其他线程唤醒或者在指定的wait时间到了之后还没有获得锁
                        throw new TimeoutException("can not get the lock during " + mills + " ms.");
                    final Thread tempThread = Thread.currentThread();
                    try {
                        //加入阻塞队列
                        if (!blockedList.contains(Thread.currentThread()))
                            blockedList.add(Thread.currentThread());
                        this.wait(remainingMills);
                        //多次wait的过程中remainingMills会重新计算
                        remainingMills = endMills - System.currentTimeMillis();
                    } catch (InterruptedException e) {
                        //如果当前线程在wait时被中断，则从blockedList中将其删除，避免内存泄漏
                        blockedList.remove(tempThread);
                        throw e;
                    }

                }
                //获得该锁
                blockedList.remove(Thread.currentThread());
                this.locked = true;
                this.currentThread = Thread.currentThread();
            }
        }
    }

    @Override
    public void unlock() {

        synchronized (this) {
            //当前线程是否为获得锁的那个线程
            if (currentThread == Thread.currentThread()) {
                //修改锁的状态
                this.locked = false;
                Optional.of(Thread.currentThread().getName() + " release the lock.").ifPresent(System.out::println);
                //通知其他线程再次尝试抢锁
                this.notifyAll();
            }
        }
    }

    @Override
    public List<Thread> getBlockedThreads() {
        return Collections.unmodifiableList(blockedList);
    }
}
