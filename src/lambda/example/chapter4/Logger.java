package lambda.example.chapter4;

import java.util.function.Supplier;

public class Logger {

    private boolean debug = true;

    public boolean isDebugEnable() {
        return debug;
    }

    public void debug(String message) {
        if (isDebugEnable()) {
            System.out.println(message);
        }
    }

    private String expensiveOperation() {
        return "";
    }

    public void example() {
        Logger logger = new Logger();
        if (logger.isDebugEnable()) {
            logger.debug("Look at this: " + expensiveOperation());
        }
    }

    //with lambda
    public void debug(Supplier<String> message) {
        if (isDebugEnable()) {
            debug(message.get());
        }
    }


    public void exampleWithLambda() {
        Logger logger = new Logger();
        logger.debug(() -> "Look at this: " + expensiveOperation());
    }

}
