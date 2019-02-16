package algorithms.greedy;

/**
 * 完全背包问题 每种物体有无限件
 * 多重背包问题 每种物体有n[i]件
 * 部分背包问题 每种物体仅有1件，但可以放入部分
 * 0-1背包问题 每种物体仅有1件，可以选择放或不放
 */
public class Backpack {

    /**
     * @param w 物体的重量
     * @param v 物体的价值
     * @param c 背包的容量
     * @return 背包可获得的最大价值
     */
    public static int zeroOnePack1(int[] w, int[] v, int c) {
        int n = w.length;

        int[][] dp = new int[n + 1][c + 1];

        //capacity is 0
        for (int col = 0; col <= c; col++) {
            dp[0][col] = 0;
        }
        //no items
        for (int row = 0; row <= n; row++) {
            dp[row][0] = 0;
        }

        for (int item = 1; item <= n; item++) {
            for (int weight = 1; weight <= c; weight++) {
                if (w[item - 1] <= weight) {
                    dp[item][weight] = Math.max(dp[item - 1][weight - w[item - 1]] + v[item - 1], dp[item - 1][weight]);
                } else {
                    dp[item][weight] = dp[item - 1][weight];
                }
            }
        }

        return dp[n][c];
    }

    /**
     * 部分背包问题
     *
     * @param w 物体的重量
     * @param v 物体的价值
     * @param c 背包的容量
     * @return 每个物体应装入背包的比列
     */
    public static double[] portionPack(int[] w, int[] v, int c) {
        if (w == null || v == null || w.length != v.length) return new double[]{};

        int n = w.length;

        //每个物体装进的比例 大于等于0并且小于等于1
        double[] x = new double[n];

        //计算物体的单位价值
        double[] t = new double[n];

        for (int i = 0; i < n; i++) {
            t[i] = (double) v[i] / w[i];
        }

        //按单位价值降序排序
        t = bubbleSort(t);

        int i; // 第 i 个物体
        for (i = 0; i < n; i++) {
            if (c >= w[i]) {
                x[i] = 1;
                c -= w[i];
            } else {
                break;
            }
        }

        //物品i只有部分被装下
        if (i <= n) {
            x[i] = c / w[i];
        }

        return x;

    }

    private static double[] bubbleSort(double[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            boolean flag = false;
            for (int j = len; j > i; j--) {
                if (array[j - 1] < array[j]) {
                    double tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return array;
    }
}
