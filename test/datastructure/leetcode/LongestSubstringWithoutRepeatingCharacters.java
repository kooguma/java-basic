package datastructure.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static algorithms.leetcode.LongestSubstringWithoutRepeatingCharacters.solution;

public class LongestSubstringWithoutRepeatingCharacters {

    @Test
    public void solutionTest() {
        String s = "abcabcbb";
        int actual = solution(s);
        Assert.assertEquals(3, actual);
    }

}
