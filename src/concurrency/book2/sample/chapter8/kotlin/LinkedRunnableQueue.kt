package concurrency.book2.sample.chapter8.kotlin

import java.util.*

/**
 * 主要用于存放提交的Runnable，该Runnable是一个BlockedQueue
 * @param limit
 * @param denyPolicy
 * @param threadPool
 */
class LinkedRunnableQueue(private val limit: Int,
                          private var denyPolicy: DenyPolicy,
                          private var threadPool: ThreadPool) : RunnableQueue {

    private var runnableList: LinkedList<Runnable> = LinkedList()

    private val lock = java.lang.Object()

    override fun offer(runnable: Runnable) {
        synchronized(lock) {
            if (runnableList.size > limit) {
                denyPolicy.reject(runnable, threadPool)
            } else {
                runnableList.add(runnable)
                lock.notifyAll()
            }
        }
    }

    override fun take(): Runnable {
        synchronized(lock) {
            while (runnableList.isEmpty()) {
                try {
                    lock.wait()
                } catch (e: InterruptedException) {
                    throw e
                }
            }
        }
        return runnableList.removeFirst()
    }

    override fun size(): Int {
        synchronized(lock) {
            return runnableList.size
        }
    }
}