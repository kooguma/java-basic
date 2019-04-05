package algorithms.dp;

import java.util.Arrays;
import java.util.Scanner;

public class pw1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        int[] times = new int[n];
        int totalTime;

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        for (int j = 0; j < n; j++) {
            times[j] = sc.nextInt();
        }

        totalTime = sc.nextInt();

        int[][] dp = new int[n + 1][totalTime + 1];

        //题目数量为0
        for (int i = 0; i < totalTime + 1; i++) {
            dp[0][i] = 0;
        }

        //总时间为0
        for (int j = 0; j < n + 1; j++) {
            dp[j][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totalTime; j++) {
                if (times[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - times[i - 1]] + scores[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

      System.out.println(dp[n][totalTime]);

    }
}
