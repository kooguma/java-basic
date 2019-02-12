package algorithms.leetcode;

//64
public class MinimumPathSum {

    //space O(n*m)
    public static int solution1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; ++i) dp[i][0] = grid[i][0] + dp[i - 1][0];
        for (int i = 1; i < n; ++i) dp[0][i] = grid[0][i] + dp[0][i - 1];
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }

    //space O(n)
    public static int solution2(int[][] grid) {
        int[] dp = new int[grid.length];
        dp[0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) dp[i] = grid[i][0] + dp[i - 1];
        for (int j = 1; j < grid[0].length; j++)
            for (int i = 0; i < grid.length; i++)
                dp[i] = (i == 0 ? dp[i] : Math.min(dp[i], dp[i - 1])) + grid[i][j];
        return dp[grid.length - 1];
    }

    //space O(1)
    public static int solution3(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 & j != 0) grid[i][j] += grid[i][j - 1];
                if (i != 0 & j == 0) grid[i][j] += grid[i - 1][j];
                if (i != 0 & j != 0) {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

}
