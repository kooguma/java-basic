package concurrency.book2.sample.chapter2;

public class ThreadConstruction {

    public static void main(String[] args) {

        Thread t1 = new Thread("t1");
        ThreadGroup group = new ThreadGroup("TestGroup");

        Thread t2 = new Thread(group, "t2");
        ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();
        System.out.println("Main Thread belong group: " + mainThreadGroup.getName());
        System.out.println("t1 thread and main thread belong the same group: " + (mainThreadGroup == t1.getThreadGroup()));
        System.out.println("t2 thread group not belong main group: " + (mainThreadGroup == t2.getThreadGroup()));
        System.out.println("t2 thread group belong main TestGroup: " + (group == t2.getThreadGroup()));
    }
}
