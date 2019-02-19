package datastructure.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class StringToInteger {

    @Test
    public void solutionTest(){
        int actual = algorithms.leetcode.StringToInteger.solution("9223372036854775808");
        int expected = 2147483647;
        Assert.assertEquals(expected,actual);
    }
}
