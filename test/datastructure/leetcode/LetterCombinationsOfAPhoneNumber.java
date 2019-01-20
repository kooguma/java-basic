package datastructure.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static algorithms.leetcode.LetterCombinationsOfAPhoneNumber.solution;

public class LetterCombinationsOfAPhoneNumber {

    @Test
    public void solutionTest() {
        String digits = "23";
        List<String> actual = solution(digits);
        List<String> expected = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        Assert.assertEquals(expected, actual);
    }
}
