//package concurrency.book2.sample.chapter8.kotlin
//
//import java.util.*
//import java.util.concurrent.TimeUnit
//import java.util.function.Consumer
//
//class BasicThreadPool : Thread, ThreadPool {
//
//    private val initSize: Int
//    private val maxSize: Int
//    private val coreSize: Int
//    private var activeCount: Int = 0
//    private val threadFactory: ThreadFactory
//    private val runnableQueue: RunnableQueue
//    private val threadQueue: Queue<ThreadTask> = ArrayDeque()
//
//    @Volatile
//    private var isShutdown = false
//    private val keepAliveTime: Long
//    private val timeUnit: TimeUnit
//
//    companion object {
//        private val DEFAULT_DENY_POLICY: DenyPolicy = DenyPolicy.DiscardDenyPolicy()
//        private val DEFAULT_THREAD_FACTORY: ThreadFactory = DefaultThreadFactory()
//
//        class ThreadTask(val thread: Thread, val internalTask: InternalTask)
//    }
//
//    constructor(initSize: Int, maxSize: Int, coreSize: Int, queueSize: Int) :
//            this(initSize, maxSize, coreSize, queueSize, DEFAULT_THREAD_FACTORY, DEFAULT_DENY_POLICY, 10, TimeUnit.SECONDS)
//
//
//    constructor(initSize: Int, maxSize: Int, coreSize: Int, queueSize: Int,
//                threadFactory: ThreadFactory, denyPolicy: DenyPolicy, keepAliveTime: Long, timeUnit: TimeUnit) {
//        this.initSize = initSize
//        this.maxSize = maxSize
//        this.coreSize = coreSize
//        this.threadFactory = threadFactory
//        this.runnableQueue = LinkedRunnableQueue(queueSize, denyPolicy, this)
//        this.keepAliveTime = keepAliveTime
//        this.timeUnit = timeUnit
//        this.init()
//    }
//
//
//    private fun init() {
//        start()
//        for (i in 0..initSize) {
//            newThread()
//        }
//    }
//
//    private fun newThread() {
//        //创建任务线程
//        val internalTask = InternalTask(runnableQueue)
//        val thread = threadFactory.createThread(internalTask)
//        val threadTask = ThreadTask(thread, internalTask)
//        threadQueue.offer(threadTask)
//        activeCount++
//        thread.start()
//    }
//
//    private fun removeThread() {
//        val threadTask = threadQueue.remove()
//        threadTask.internalTask.stop()
//        this.activeCount--
//    }
//
//    override fun run() {
//        //用于维护线程数量，扩容，回收
//        loop@ while (!isShutdown && isInterrupted) {
//            try {
//                timeUnit.sleep(keepAliveTime)
//            } catch (e: InterruptedException) {
//                isShutdown = true
//                break
//            }
//            synchronized(this) {
//                if (isShutdown) return@loop
//
//                if (runnableQueue.size() > 0 && activeCount < coreSize) {
//                    for (i in initSize..coreSize) {
//                        newThread()
//                    }
//                    //不想直接扩容达到maxSize
//                    return@loop
//                }
//
//                if (runnableQueue.size() > 0 && activeCount < maxSize) {
//                    for (i in coreSize..maxSize) {
//                        newThread()
//                    }
//                }
//
//                if (runnableQueue.size() == 0 && activeCount > coreSize) {
//                    removeThread()
//                }
//            }
//        }
//    }
//
//    override fun execute(runnable: Runnable) {
//        if (this.isShutdown)
//            throw IllegalStateException("The thread pool is destroy")
//        this.runnableQueue.offer(runnable)
//    }
//
//    override fun shutdown() {
//        synchronized(this) {
//            if (isShutdown) return
//            isShutdown = true
//            threadQueue.forEach(Consumer { threadTask ->
//                run {
//                    threadTask.internalTask.stop()
//                    threadTask.thread.interrupt()
//                }
//            })
//            this.interrupt()
//        }
//    }
//
//    override fun getInitSize(): Int {
//        if (isShutdown)
//            throw IllegalStateException("The thread pool is destroy")
//        return initSize
//    }
//
//    override fun getMaxSize(): Int {
//        if (isShutdown)
//            throw IllegalStateException("The thread pool is destroy")
//        return maxSize
//    }
//
//    override fun getCoreSize(): Int {
//        if (isShutdown)
//            throw IllegalStateException("The thread pool is destroy")
//        return coreSize
//    }
//
//    override fun getQueueSize(): Int {
//        if (isShutdown)
//            throw IllegalStateException("The thread pool is destroy")
//        return this.runnableQueue.size()
//    }
//
//    override fun getActiveCount(): Int {
//        synchronized(this) {
//            return activeCount
//        }
//    }
//
//    override fun isShutdown(): Boolean {
//        return isShutdown
//    }
//
//}
//
