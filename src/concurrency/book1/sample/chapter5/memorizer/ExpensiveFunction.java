package concurrency.book1.sample.chapter5.memorizer;

import java.math.BigInteger;

public class ExpensiveFunction implements Computable<String,BigInteger>{

    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        //long time compute
        return new BigInteger(arg);
    }

}
