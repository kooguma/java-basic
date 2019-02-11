package algorithms.leetcode;

//10
public class RegularExpressionMatching {

    public static boolean solution(String source, String pattern) {
        if (source == null || pattern == null) return false;
        boolean[][] dp = new boolean[pattern.length() + 1][source.length() + 1];
        //初始化
        dp[0][0] = true;
        //初始化第0列,除了[0][0]全为false，毋庸置疑，因为空串p只能匹配空串，其他都无能匹配
        for (int i = 1; i <= source.length(); i++) {
            dp[i][0] = false;
        }
        //初始化第0行，只有X*能匹配空串，如果有*，它的真值一定和p[0][j-2]的相同（略过它之前的符号）
        //012 01234
        //aab c*aab => dp[0][2] = dp[0][0] = true
        for (int j = 1; j <= pattern.length(); j++) {
            if (j > 1 && pattern.charAt(j - 1) == '*' && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }

        for (int i = 1; i <= source.length(); i++) {
            for (int j = 1; j <= pattern.length(); j++) {
                if (pattern.charAt(j - 1) == source.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (pattern.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (pattern.charAt(j - 1) == '*') {
                    if (pattern.charAt(j - 2) != source.charAt(i) && pattern.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        //3种情况合并  ; 3. X* => empty
                        //1. X* => single X  (aa a*)
                        //2. X* => multi X (aaa a*) 合并之前的a
                        //3. X* => empty (baab bc*abb)
                        dp[i][j] = (dp[i][j - 1] || dp[i - 1][j] || dp[i][j - 2]);
                    }
                }
            }
        }

        return dp[pattern.length()][source.length()];
    }
}
