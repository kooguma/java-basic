package lambda.example.chapter4.defaultmethod;

public class ParentImpl implements Parent {

    private String body;

    @Override
    public void message(String body) {
        this.body = body;
    }

    @Override
    public String getLastMessage() {
        return body;
    }
}
