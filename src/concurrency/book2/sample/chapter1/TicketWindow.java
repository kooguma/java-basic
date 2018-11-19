package concurrency.book2.sample.chapter1;

public class TicketWindow extends Thread {

    private final String name;
    private static final int MAX = 50;
    private int index = 1;

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println("柜台: " + name + "当前的号码是: " + (index++));
        }
    }

    public static void main(String[] args) {
        TicketWindow t1 = new TicketWindow("一号柜台");
        TicketWindow t2 = new TicketWindow("二号柜台");
        TicketWindow t3 = new TicketWindow("三号柜台");
        TicketWindow t4 = new TicketWindow("四号柜台");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
