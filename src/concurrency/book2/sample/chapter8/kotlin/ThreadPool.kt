package concurrency.book2.sample.chapter8.kotlin

interface ThreadPool {

    fun execute(runnable: Runnable)
    fun shutdown()
    fun getInitSize():Int
    fun getMaxSize():Int
    fun getCoreSize():Int
    fun getQueueSize():Int
    fun getActiveCount():Int
    fun isShutdown():Boolean
}