package algorithms.leetcode;

public class ReverseInteger {

    public static int solution(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            //如果溢出了，那溢出后的值做反向操作会和之前的值不一样
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }
}
