package concurrency.book2.sample.chapter5;

import java.util.LinkedList;

public class EventQueue {

    private final int max;

    static class Event {

    }

    private final LinkedList<Event> eventQueue = new LinkedList<>();
    private final static int DEFAULT_MAX_EVENT = 10;

    public EventQueue() {
        this(DEFAULT_MAX_EVENT);
    }

    public EventQueue(int max) {
        this.max = max;
    }

    public void offer(Event event) {
        synchronized (eventQueue) {
            //队列满阻塞
            if (eventQueue.size() >= max) {
                try {
                    console(" the queue is full");
                    //将执行该语句的线程阻塞
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            console(" the new event is submitted");
            eventQueue.addLast(event);
            //唤醒那些曾经执行monitor的wait方法而进入阻塞的线程
            eventQueue.notify();
        }
    }

    public Event take() {
        synchronized (eventQueue) {
            //队列空
            if (eventQueue.isEmpty()) {
                try {
                    console(" the queue is empty");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Event event = eventQueue.removeFirst();
            this.eventQueue.notify();
            console(" the event " + event + " is handled");
            return event;
        }
    }

    public void console(String message) {
        System.out.printf("%s:%s\n", Thread.currentThread().getName(), message);
    }
}
