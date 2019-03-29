package concurrency.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 可重入性 Test
public class LockTest1 {

    private List<Integer> list = new ArrayList<>();
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        final LockTest1 test = new LockTest1();

        new Thread(()->{
            test.insert(Thread.currentThread());
        },"1").start();

        new Thread(()->{
            test.insert(Thread.currentThread());
        },"2").start();
    }

    public void insert(Thread t) {
        lock.lock();
        try {
            System.out.println("线程" + t.getName() + "获得了锁");
        } catch (Exception e) {
            for (int i = 0 ; i < 5 ; i ++){
                list.add(i);
            }
        } finally {
            lock.unlock();
            System.out.println("线程"+t.getName()+"释放了锁");
        }
    }

}
