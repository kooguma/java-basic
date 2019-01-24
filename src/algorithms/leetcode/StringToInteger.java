package algorithms.leetcode;

//8
public class StringToInteger {

    /**
     * 需要考虑的问题：
     * 边界条件
     * 多余空格
     * 正负号处理
     * 溢出问题
     * 非法输入
     *
     * @param str
     * @return
     */
    public static int solution(String str) {
        if (str == null || str.trim().length() == 0 ) return 0;
        str = str.trim();
        char firstChar = str.charAt(0);
        int sign = 1;
        int start = 0;
        //防止越界
        long res = 0;
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }
        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) (res * sign);
            }
            res = res * 10 + str.charAt(i) - '0';
            //越界判断
            if (sign == 1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && res > Integer.MAX_VALUE) return Integer.MIN_VALUE;
        }
        return (int) (sign * res);
    }
}
