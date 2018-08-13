package lambda.example.chapter4;

import lambda.example.chapter4.multipleimplments.MusicalCarriage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MultiImplementsTest {


    @Test
    public void rockTest(){
        MusicalCarriage carriage = new MusicalCarriage();
        assertEquals("... from side to side", carriage.rock());
    }
}
