package algorithms.leetcode;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int solution(String s) {
        int[] map = new int[256];
        Arrays.fill(map, -1);
        int len = 0, i = -1;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            //上一个char对应对位置
            i = Math.max(i, map[c]);
            //更新char对应对位置
            map[c] = j;
            //跟新len,j-i第一个不重复位置对距离
            len = Math.max(len, j - i);
        }
        return len;
    }
}
