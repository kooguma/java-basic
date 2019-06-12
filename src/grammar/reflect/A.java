package grammar.reflect;

public class A {

    public int intParam;

    public String stringParam;

    public A() {
    }

    public A(int intParam, String stringParam) {

        this.intParam = intParam;
        this.stringParam = stringParam;
    }

    public int getIntParam() {
        return intParam;
    }

    public void setIntParam(int intParam) {
        this.intParam = intParam;
    }

    public String getStringParam() {
        return stringParam;
    }

    public void setStringParam(String stringParam) {
        this.stringParam = stringParam;
    }
}
