package lambda.example.chapter4.multipleimplments;

public interface Carriage {

    default String rock(){
        return "... from side to side";
    }
}
