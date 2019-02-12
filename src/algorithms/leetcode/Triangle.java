package algorithms.leetcode;

import java.util.List;

//120
public class Triangle {

    public static int solution1(List<List<Integer>> triangle) {
        int[] dp = triangle.get(triangle.size() - 1).stream().mapToInt(i -> i).toArray();
        //从倒数第二层开始
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    //dfs todo
    public static int solution2(List<List<Integer>> triangle){
        return 0;
    }
}
