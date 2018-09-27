package datastructure.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static algorithms.leetcode.TwoSum.*;

public class TwoSumTest {

    @Test
    public void test1() {
        int[] sums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = solution1(sums, target);
        int[] expected = new int[]{0, 1};
        Assert.assertArrayEquals(expected, result);
    }
}
