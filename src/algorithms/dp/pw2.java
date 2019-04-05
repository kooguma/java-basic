package algorithms.dp;

import java.util.Scanner;

public class pw2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int map[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int dp[][] = new int[n--][m--];
        dp[n][m] = map[n][m] > 0 ? 1 : -map[n][m] + 1;

        for (int j = m - 1; j >= 0; j--) {
            dp[n][j] = Math.max(dp[n][j + 1] - map[n][j], 1);
        }

        int right = 0, down = 0;

        for (int i = n - 1; i >= 0; i--) {
            dp[i][m] = Math.max(dp[i + 1][m] - map[i][m], 1);
            for (int j = m -1; j >= 0; j--) {
                right = Math.max(dp[i][j+1]-map[i][j],1);
                down = Math.max(dp[i+1][j] - map[i][j],1);
                dp[i][j] = Math.min(right,down);
            }
        }

        System.out.println(dp[0][0]);
    }
}
