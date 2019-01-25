package datastructure.leetcode;

import org.junit.Assert;
import org.junit.Test;
import static algorithms.leetcode.ZigZagConversion.solution;
public class ZigZagConversion {

    @Test
    public void solutionTest(){
        String actual = solution("PAYPALISHIRING",3);
        String expected = "PAHNAPLSIIGYIR";
        Assert.assertEquals(expected,actual);
    }
}
