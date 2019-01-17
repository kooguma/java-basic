package datastructure.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static algorithms.leetcode.ThreeSum.*;

public class ThreeSum {

    private int[] nums1 = new int[]{-1, 0, 1, 2, -1, -4};
    private List<List<Integer>> expected;

    @Before
    public void setup() {
        expected = new ArrayList<>();
        expected.add(Arrays.asList(-1, -1, 2));
        expected.add(Arrays.asList(-1, 0, 1));
    }

    @Test
    public void solution1Test() {
        List<List<Integer>> result = solution1(nums1);
        //fixme 子集顺序有问题
        Assert.assertEquals(expected, result);
    }

    @Test
    public void solution2Test() {
        List<List<Integer>> result = solution2(nums1);
        Assert.assertEquals(expected, result);
    }

}
