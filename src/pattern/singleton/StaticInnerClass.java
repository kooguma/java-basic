package pattern.singleton;

public class StaticInnerClass {


    private StaticInnerClass() {
    }

    private static class Holder{
        public static StaticInnerClass singleton = new StaticInnerClass();
    }

    public StaticInnerClass newInstance(){
        return Holder.singleton;
    }
}
