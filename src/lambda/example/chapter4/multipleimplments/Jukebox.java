package lambda.example.chapter4.multipleimplments;

public interface Jukebox {

    default String rock(){
        return "... all over the word!";
    }
}
