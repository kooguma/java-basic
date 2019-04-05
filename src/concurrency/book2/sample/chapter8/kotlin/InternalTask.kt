//package concurrency.book2.sample.chapter8.kotlin
//
//class InternalTask(private val runnableQueue: RunnableQueue) : Runnable {
//
//
//    @Volatile
//    private var running: Boolean = true
//
//    override fun run() {
//
//        while (running && !Thread.currentThread().isInterrupted) {
//            try {
//                val task = runnableQueue.take()
//                task.run()
//            } catch (e: InterruptedException) {
//                running = false
//                break
//            }
//        }
//    }
//
//    fun stop() {
//        this.running = false
//    }
//}