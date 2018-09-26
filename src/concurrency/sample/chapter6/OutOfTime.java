package concurrency.sample.chapter6;

import java.util.Timer;
import java.util.TimerTask;

import static java.util.concurrent.TimeUnit.SECONDS;


/**
 * Timer的另一个问题是，如果TimerTask抛出一个未检查的异常，那么Timer将表现出糟糕的行为。
 * Timer线程并不捕获异常，因此当TimerTask抛出未检查的异常时将终止定时线程。
 * 这种情况下，Timer也不会回复线程的执行，二回错误的认为整个Timer都被取消了。
 * 因此，已经被调度但尚未执行的TimerTask将不会再执行，新的任务也不能被调度。
 */
public class OutOfTime {

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new ThrowTask(), 1);
        SECONDS.sleep(1);
        timer.schedule(new ThrowTask(), 1);
        SECONDS.sleep(5);

    }

    public static class ThrowTask extends TimerTask {

        @Override
        public void run() {
            throw new RuntimeException();
        }
    }
}
