package lambda.example.chapter1;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static lambda.example.chapter1.Chapter1.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Chapter1Test {

    private List<Integer> intArray;
    private List<String> strArray;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setup() {
        intArray = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        strArray = Arrays.asList("123", "456", "789");
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void predicateBiggerTest() {
        List<Integer> actual = predicateBigger(intArray, 8);
        List<Integer> expected = Arrays.asList(9, 10);
        assertEquals(expected, actual);
    }

    @Test
    public void predicateSmallerTest() {
        List<Integer> actual = predicateSmaller(intArray, 3);
        List<Integer> expected = Arrays.asList(1, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void predicateBiggerAndSmallerTest() {
        List<Integer> actual = predicateBiggerAndSmaller(intArray, 3, 8);
        List<Integer> expected = Arrays.asList(4, 5, 6, 7);
        assertEquals(expected, actual);
    }

    @Test
    public void predicateBiggerOrSmallerTest() {
        List<Integer> actual = predicateBiggerOrSmaller(intArray, 3, 8);
        List<Integer> expected = Arrays.asList(1, 2, 9, 10);
        assertEquals(expected, actual);
    }

    @Test
    public void consumerToUpperThenToLowerTest() {
        List<String> array = Arrays.asList("a", "b", "c", "d");
        consumerToUpperThenToLower(array);
        assertEquals("AaBbCcDd",outContent.toString());
    }

    @Test
    public void functionAndThenTest() {
        assertEquals("bread", functionAndThen("seed"));
    }

    @Test
    public void functionComposeTest() {
        assertEquals("bread", functionCompose("seed"));
    }

    @Test
    public void supplierTest() {
        assertEquals("supplier", supplier(() -> "supplier"));
    }

    @Test
    public void unaryOperatorTest() {
        List<Integer> actual = unaryOperator(intArray);
        List<Integer> expected = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        assertEquals(expected, actual);
    }

    @Test
    public void binaryOperatorTest() {
        List<Integer> actual = binaryOperator(intArray);
        List<Integer> expected = Arrays.asList(1, 4, 9, 16, 25, 36, 49, 64, 81, 100);
        assertEquals(expected, actual);
    }

    @Test
    public void toXXXFunctionTest() {
        double[] actual = toXXXFunction(strArray);
        double[] expected = new double[]{123.0, 456.0, 789.0};
        assertArrayEquals(expected, actual, 0);
    }

    @Test
    public void XXXFunctionTest() {
        String actual = XXXFunction(123);
        assertEquals("123.0", actual);
    }
}
