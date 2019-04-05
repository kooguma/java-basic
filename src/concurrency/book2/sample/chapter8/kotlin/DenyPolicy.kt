//package concurrency.book2.sample.chapter8.kotlin
//
//interface DenyPolicy {
//
//    fun reject(runnable: Runnable, pool: ThreadPool)
//
//    class DiscardDenyPolicy:DenyPolicy{
//        override fun reject(runnable: Runnable, pool: ThreadPool) {
//            // do nothing
//        }
//
//    }
//
//    class AbortDenyPolicy:DenyPolicy{
//        override fun reject(runnable: Runnable, pool: ThreadPool) {
//        }
//    }
//
//    class RunnerDenyPolicy:DenyPolicy{
//        override fun reject(runnable: Runnable, pool: ThreadPool) {
//
//        }
//
//    }
//}