package algorithms.dp;

import java.util.Map;

/*
题目：
有一座高度是10级台阶的楼梯，从下往上走，每跨一步只能向上1级或者2级台阶。要求用程序来求出一共有多少种走法。
*/
public class ClimbingWays {

    //递归法
    public static int solution1(int n) {
        if (n < 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        return solution1(n - 1) + solution1(n - 2);
    }

    //备忘录法
    public static int solution2(int n, Map<Integer, Integer> map) {
        if (n < 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int value = solution2(n - 1, map) + solution2(n - 2, map);
            map.put(n, value);
            return value;
        }
    }

    //动态规划
    public static int solution3(int n) {
        if (n < 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int a = 1;
        int b = 2;
        int temp = 0;

        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }

        return temp;
    }
}
