package concurrency.book2.sample.chapter8;

public class RunnableDenyException extends RuntimeException {

    public RunnableDenyException(String message) {
        super(message);
    }
}
