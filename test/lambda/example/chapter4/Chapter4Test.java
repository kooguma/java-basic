package lambda.example.chapter4;

import lambda.demo.SampleData;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static lambda.example.chapter4.Chapter4.printTrackLengthStatistics;
import static org.junit.Assert.assertEquals;

public class Chapter4Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }


    @Test
    public void printTrackLengthStatisticsTest(){
        printTrackLengthStatistics(SampleData.aLoveSupreme);
        assertEquals("Max: 467, Min: 442, Ave: 454.500000, Sum: 909",outContent.toString());
    }
}
