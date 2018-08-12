package lambda.example.chapter4.defaultmethod;

public interface Child extends Parent {

    @Override
    default void welcome() {
        message("Child: Hi!");
    }
}
