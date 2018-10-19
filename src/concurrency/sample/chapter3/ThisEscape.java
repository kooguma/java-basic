package concurrency.sample.chapter3;

public class ThisEscape {

    //当ThisEscape发布EventListener时，也隐含的发布了ThisEscape实例本身
    //内部类EventListener会自动的持有对外部类ThisEscape对引用
    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener() {
            @Override
            public void onEvent(Event e) {
                //ThisEscape未构造完成，但被发布了
                ThisEscape.this.doSomething(e);
            }
        });
    }

    public void doSomething(Event e){

    }
}
