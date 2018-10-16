package concurrency.sample.chapter1;

public class MyRunnable implements Runnable {
    private final static int sCount = 1000000;

    private ISequence mSequence;
    private int mCount;

    public MyRunnable(ISequence sequence) {
        this.mSequence = sequence;
        this.mCount = sCount;
    }

    public MyRunnable(ISequence sequence, int count) {
        this.mSequence = sequence;
        this.mCount = count;
    }

    @Override
    public void run() {
        if (mSequence != null) {
            for (int i = 0; i < mCount; i++) {
                System.out.println("thread_id : " + Thread.currentThread().getId() + " next_value = " + mSequence.getNext());
            }
        }
    }
}
