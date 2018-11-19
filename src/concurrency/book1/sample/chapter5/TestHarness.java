package concurrency.book1.sample.chapter5;

import java.util.concurrent.CountDownLatch;

public class TestHarness {

    public static void main(String args[]) throws InterruptedException {
        TestHarness testHarness = new TestHarness();
        testHarness.timeTasks(10, () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }

    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {

        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        //await 方法等待计数器达到零
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            //countDown 方法递减计数器
                            endGate.countDown();
                        }
                    } catch (InterruptedException ignored) {
                    }
                }
            };

            t.start();
        }

        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }
}
