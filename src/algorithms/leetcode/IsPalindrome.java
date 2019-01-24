package algorithms.leetcode;

//9
public class IsPalindrome {

    //思路: 把数字逆转后判断跟原来的数字是否一样
    public static boolean solution(int x) {
        if (x < 0) return false;
        int r = 0, t = x;
        while (t != 0) {
            r = r * 10 + t % 10;
            t /= 10;
        }
        return r == x;
    }
}
