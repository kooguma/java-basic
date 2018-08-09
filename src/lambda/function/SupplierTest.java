package lambda.function;

import java.util.function.Supplier;

public class SupplierTest {

    public static void main(String arg[]){
        Supplier<String> supplier = () -> "test";
        //惰性求值
        System.out.println(supplier.get());
    }

}
