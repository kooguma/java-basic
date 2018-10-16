package concurrency.sample.chapter4;

import concurrency.annotations.GuardedBy;

/**
 * Java 监视器模式
 * 对于任何一种锁对象，只要自始至终都使用该锁对象，都可以用来保护对象状态
 */
public class PrivateLock {

    class Widget{

    }

    private final Object myLock = new Object();
    @GuardedBy("myLock") Widget wigget;

    void  someMethod(){
        synchronized (myLock){
            //访问或修Widget状态
        }
    }
}
