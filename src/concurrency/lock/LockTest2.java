package concurrency.lock;

import concurrency.book1.sample.chapter1.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//TryLock
public class LockTest2 {

    List<Integer> list = new ArrayList<>();
    Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        final LockTest2 test = new LockTest2();
        new Thread(() -> test.insert(Thread.currentThread()), "1").start();
        new Thread(() -> test.insert(Thread.currentThread()), "2").start();
    }

    private void insert(Thread t) {
        if (lock.tryLock()) {
            try {
                System.out.println("线程" + t.getName() + "获得锁");
                for (int i = 0; i < 5; i++) {
                    list.add(i);
                }
            } catch (Exception e) {
                //todo
            } finally {
                System.out.println("线程" + t.getName() + "释放锁");
                lock.unlock();
            }
        } else {
            System.out.println("线程" + t.getName() + "获取锁失败");
        }
    }
}