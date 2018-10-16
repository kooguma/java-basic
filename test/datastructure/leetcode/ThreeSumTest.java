package datastructure.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static algorithms.leetcode.ThreeSum.*;

public class ThreeSumTest {

    private int[] nums1 = new int[]{-2, -2, -1, -1, 0, 1, 1, 2, 2};

    @Test
    public void solution1Test() {
        List<Tuple> result = solution1(nums1);
        List<Tuple> expected = new ArrayList<>();
        expected.add(new Tuple(-2, 0, 2));
        expected.add(new Tuple(-1, 0, 1));
        Assert.assertEquals(expected, result);
    }

    @Test
    public void solution2Test() {
        List<List<Integer>> result = solution2(nums1);
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(-2);
        list1.add(0);
        list1.add(2);
        expected.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(-1);
        list2.add(0);
        list2.add(1);
        expected.add(list2);
        Assert.assertEquals(expected, result);
    }

}
