package datastructure.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static algorithms.leetcode.DivideTwoIntegers.solution;

public class DivideTwoIntegers {

    @Test
    public void solutionTest() {
        int actual = solution(9,3);
        Assert.assertEquals(3,actual);
    }

}
