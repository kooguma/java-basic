package concurrency.book2.sample.chapter5;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EventImprovedClient {

    public static void main(String[] args) {
        EventQueueImproved eventQueueImproved = new EventQueueImproved();

        List<Thread> producers = IntStream.range(1, 10)
                .mapToObj(value -> new Thread(() -> {
                    for (; ; ) {
                        eventQueueImproved.offer(new EventQueueImproved.Event());
                    }
                }, "Producer[" + value + "]"))
                .collect(Collectors.toList());

        List<Thread> consumers = IntStream.range(1, 10)
                .mapToObj(value -> new Thread(() -> {
                    for (; ; ) {
                        eventQueueImproved.take();
                    }
                }, "Consumers[" + value + "]"))
                .collect(Collectors.toList());

        producers.forEach(Thread::start);
        consumers.forEach(Thread::start);
    }
}
