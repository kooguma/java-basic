package concurrency.book2.sample.chapter1;

public class TickerWindowRunnable implements Runnable {

    private int index = 1;
    private final static int Max = 50;


    @Override
    public void run() {
        while (index <= Max) {
            System.out.println(Thread.currentThread().getName() + "的号码是: " + (index++));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TickerWindowRunnable r = new TickerWindowRunnable();
        Thread t1 = new Thread(r,"一号窗口");
        Thread t2 = new Thread(r,"二号窗口");
        Thread t3 = new Thread(r,"三号窗口");
        Thread t4 = new Thread(r,"四号窗口");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
