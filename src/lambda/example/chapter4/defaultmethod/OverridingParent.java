package lambda.example.chapter4.defaultmethod;

public class OverridingParent extends ParentImpl {

    @Override
    public void welcome() {
        message("Class Parent: Hi!");
    }
}
