package algorithms.leetcode;

public class LongestPalindromic {

    public static String manacher(String s) {
        char[] t = preProcess(s);
        int[] p = new int[t.length];
        int n = t.length ,mid = 0, right = 0;
        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * mid - i;
            if (right > i)
                p[i] = Math.min(right - i, p[mirror]);
            while (t[i + (1 + p[i])] == t[i - (1 + p[i])]) //while 最多循环n步
                p[i]++;
            //expand past R
            //adjust center
            if (i + p[i] > right) {
                mid = i;
                right = i + p[i];
            }
        }
        int length = 0;
        int center = 0;
        for (int i = 1; i < n - 1; i++) {
            if (p[i] > length) {
                length = p[i];
                center = i;
            }
        }
        //其实位置是中间位置减去半径再除以2
        //中心算在内不用减1，不算在内要减1
        return s.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
    }


    //预处理
    public static char[] preProcess(String s) {
        char[] t = new char[s.length() * 2 + 3];
        t[0] = '$';
        t[s.length() * 2 + 2] = '@';
        for (int i = 0; i < s.length(); i++) {
            t[2 * i + 1] = '#';
            t[2 * i + 2] = s.charAt(i);
        }
        t[s.length() * 2 + 1] = '#';
        return t;
    }


}
