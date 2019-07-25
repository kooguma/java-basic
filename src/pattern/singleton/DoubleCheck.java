package pattern.singleton;

public class DoubleCheck {

    private static volatile DoubleCheck singleton;

    public static DoubleCheck newInstance(){
        if(singleton == null){
            synchronized (DoubleCheck.class){
                if(singleton == null){
                    //不是原子性操作
                    singleton = new DoubleCheck();
                    return singleton;
                }
            }
        }
        return singleton;
    }
}
