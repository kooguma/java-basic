package lambda.example.chapter4.multipleimplments;

public class MusicalCarriage implements Carriage,Jukebox {


    //javac并不明确应该继承哪个接口的方法，在类中实现rock方法就能解决这个问题
    @Override
    public String rock() {
        //增强的super语法
        //return Jukebox.super.rock();
        return Carriage.super.rock();
    }

}
