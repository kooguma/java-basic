package concurrency.book2.sample.chapter8.kotlin

import java.util.concurrent.atomic.AtomicInteger

class DefaultThreadFactory : ThreadFactory {

    private companion object {
        val GROUP_COUNTER: AtomicInteger = AtomicInteger()
        val group:ThreadGroup = ThreadGroup("MyThreadPool-" + GROUP_COUNTER.getAndIncrement())
        val COUNTER = AtomicInteger(0)
    }

    override fun createThread(runnable: Runnable): Thread {
        return Thread(group,runnable,"thread-pool-" + COUNTER.getAndIncrement())
    }
}