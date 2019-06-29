package datastructure.nowcoder;

import algorithms.nowcoder.ReverseBetween;
import common.ListNode;
import datastructure.utils.ListNodeBuilder;
import org.junit.Assert;
import org.junit.Test;

public class ReverseBetweenTest {

    @Test
    public void solutionTest() {
        ListNodeBuilder builder = new ListNodeBuilder();
        ListNode head = builder.append(new int[]{1,2,3,4,5}).build();
        ListNode actualList = ReverseBetween.solution1(head, 2, 4);
        ListNode expectedList = builder.clear().append(new int[]{1,4,3,2,5}).build();
        Assert.assertEquals(expectedList,actualList);
    }
}
