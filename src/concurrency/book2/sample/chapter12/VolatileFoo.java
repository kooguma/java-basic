package concurrency.book2.sample.chapter12;

import java.util.concurrent.TimeUnit;

public class VolatileFoo {

    final static int MAX = 5;
    static volatile int init_value = 0;

    public static void main(String[] args) {
        //启动一个Reader线程，当发现local_value和init_value不同时，则输出init_value
        new Thread(() -> {
            int localValue = init_value;
            while (init_value != localValue) {
                System.out.printf("The init_value is update to [%d]\n", init_value);
                localValue = init_value;
            }
        }, "Reader").start();
        //启动Updater线程，主要用于对init_value的修改，当local_value>=5时，结束生命周期
        new Thread(() -> {
            int localValue = init_value;
            while (localValue < MAX){
                System.out.printf("The init_value will be changed to [%d]\n",++localValue);
                init_value = localValue;
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Updater").start();
    }
}
