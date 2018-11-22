package concurrency.book2.sample.chapter5;

public class TestWait {


    private  void testWait() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void testNotify() {
        this.notify();
    }

    public static void main(String[] args) {
        TestWait wait = new TestWait();
        //IllegalMonitorStateException
        wait.testWait();
    }

}
