package algorithms.leetcode;

//29 手动实现除法
public class DivideTwoIntegers {

    public static int solution(int dividend, int divisor) {

        if (divisor == 0 || dividend == Integer.MAX_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int i, total = 0;

        //判断正负号
        boolean sign = ((dividend) < 0) ^ ((divisor < 0));

        //防止溢出
        long did = Math.abs(dividend);
        long dis = Math.abs(divisor);

        while (did >= dis) {

            long mul_dis = dis;
            i = 0;

            while (did >= (mul_dis << 1)) {
                i++;
                mul_dis <<= 1;
            }

            did -= mul_dis;
            total += 1 << i;
        }

        return sign ? -total : total;
    }
}
