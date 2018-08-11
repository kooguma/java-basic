package lambda.answers.chapter2;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;

public class Chapter2 {

    //DateFormatter 类是非线程安全的。使用构造函数创建一个线程安全的 DateFormatter 对象，并输出日期，如"01-Jan-1970'
    public final static ThreadLocal<DateFormatter> formatter
            = ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy")));

}
