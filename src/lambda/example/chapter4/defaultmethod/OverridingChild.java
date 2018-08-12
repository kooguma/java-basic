package lambda.example.chapter4.defaultmethod;

public class OverridingChild extends OverridingParent implements Child {
    @Override
    public void message(String body) {

    }

    @Override
    public String getLastMessage() {
        return null;
    }

    @Override
    public void welcome() {

    }
}
