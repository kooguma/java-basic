package concurrency.Introduction.chapter1_1;

public class Test {

    public static void main(String[] args) {

        UnsafeSequence s1 = new UnsafeSequence();
        Sequence s2 = new Sequence();


        System.out.println("----------unsafe sequence----------");
        MyRunnable r1 = new MyRunnable(s1);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);

//        System.out.println("----------safe sequence----------");
//        MyRunnable r2 = new MyRunnable(s2);
//        Thread t1 = new Thread(r2);
//        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

    }


}
