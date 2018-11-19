package concurrency.book1.sample.chapter5;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String args[]) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(2) {

            @Override
            public void await() throws InterruptedException {
                super.await();
                System.out.println(Thread.currentThread().getName() + " count down is ok");
            }
        };

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " is done");
                countDownLatch.countDown();
            }
        },"thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " is done");
                countDownLatch.countDown();
            }
        },"thread2");


        thread1.start();
        thread2.start();

        //await 方法等待计数器达到零
        countDownLatch.await();
    }
}
