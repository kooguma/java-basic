package datastructure.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static algorithms.leetcode.RemoveDuplicatesFromSortedArray.solution;


public class RemoveDuplicatesFromSortedArray {

    @Test
    public void solutionTest() {
        int[] nums = new int[]{1, 1, 2};
        int actual = solution(nums);
        Assert.assertEquals(2, actual);
    }
}

