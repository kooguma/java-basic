package datastructure.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static algorithms.leetcode.ReverseInteger.solution;

public class ReverseInteger {

    @Test
    public void solutionTest() {
        int actual = solution(123);
        int expected = 321;
        Assert.assertEquals(expected, actual);
    }
}
