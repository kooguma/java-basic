package algorithms.leetcode;

public class CountingBits {

    public static int[] solution(int num) {
        int[] count = new int[num + 1];
        count[0] = 0;
        for (int i = 1; i <= num; i++) {
            count[i] = count[i >> 1] + i & 1;
        }
        return count;
    }
}
