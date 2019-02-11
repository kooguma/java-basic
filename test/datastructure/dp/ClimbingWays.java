package datastructure.dp;

import org.junit.Test;

import java.util.HashMap;

import static algorithms.dp.ClimbingWays.solution1;
import static algorithms.dp.ClimbingWays.solution2;
import static algorithms.dp.ClimbingWays.solution3;

public class ClimbingWays {

    private static final int n = 1000;

    @Test(timeout = 1000)
    public void solution1Test() {
        solution1(n);
    }

    @Test(timeout = 1000)
    public void solution2Test() {
        solution2(n, new HashMap<>());
    }

    @Test(timeout = 1000)
    public void solution3Test() {
        solution3(n);
    }
}
