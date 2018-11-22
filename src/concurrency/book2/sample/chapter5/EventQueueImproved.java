package concurrency.book2.sample.chapter5;

import java.util.LinkedList;

public class EventQueueImproved {

    static class Event {
    }

    private final int max;
    private final static int DEFAULT_MAX_EVENT = 10;
    private final LinkedList<Event> eventQueue = new LinkedList<>();

    public EventQueueImproved() {
        this(DEFAULT_MAX_EVENT);
    }

    public EventQueueImproved(int max) {
        this.max = max;
    }

    public void offer(Event event) {
        synchronized (eventQueue) {
            while (eventQueue.size() >= max) {
                try {
                    console("the queue is full");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            eventQueue.notifyAll();
            eventQueue.addLast(event);
            console("the new event is submit");
        }
    }

    public Event take() {
        synchronized (eventQueue) {
            while (eventQueue.isEmpty()) {
                try {
                    console("the queue is empty");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Event event = eventQueue.removeLast();
            eventQueue.notifyAll();
            console("the event " + event + " is handled");
            return event;
        }
    }

    public void console(String message) {
        System.out.printf("%s:%s\n", Thread.currentThread().getName(), message);
    }
}
