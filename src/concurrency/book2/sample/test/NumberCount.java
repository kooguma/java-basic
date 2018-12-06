package concurrency.book2.sample.test;

public class NumberCount implements Runnable {

    //线程标记
    int flag = 1;
    //自增数字
    int number = 1;

    @Override
    public void run() {
        //每个线程要运行5轮
        for (int i = 0; i < 5; i++) {
            print(Thread.currentThread().getName());
        }

    }

    public synchronized void print(String name) {
        int num = Integer.parseInt(name);
        while (num != flag) {
            //没有轮到该线程则阻塞
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("线程" + num + ":" + number++);
        }

        //此线程打印完5哥连续数字，然后运算标记使下一个线程进入
        flag = flag % 3 + 1;
        //唤醒本线程以外的其它线程
        this.notifyAll();
    }

    public static void main(String[] args) {

        NumberCount c = new NumberCount();

        Thread thread1 = new Thread(c, "1");
        Thread thread2 = new Thread(c, "2");
        Thread thread3 = new Thread(c, "3");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
