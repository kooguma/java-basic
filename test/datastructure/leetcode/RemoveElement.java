package datastructure.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class RemoveElement {


    @Test
    public void solutionTest() {
        int[] array = new int[]{3, 2, 2, 3};
        int actual = algorithms.leetcode.RemoveElement.solution(array,3);
        Assert.assertEquals(2,actual);
    }

}
