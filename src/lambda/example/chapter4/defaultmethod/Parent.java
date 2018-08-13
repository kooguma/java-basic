package lambda.example.chapter4.defaultmethod;

public interface Parent {


    public void message(String body);

    default void welcome(){
        message("Parent: Hi!");
    }

    public String getLastMessage();
}
