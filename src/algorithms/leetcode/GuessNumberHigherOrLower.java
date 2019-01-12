package algorithms.leetcode;

//return the number your pick
public class GuessNumberHigherOrLower {

    public static int solution(int n) {
        int st = 1, ed = n, mid;
        while (st < ed) {
            mid = st + (ed - st) / 2;
            if (guess(mid) < 0) {
                //the number is too large
                ed = mid - 1;
            } else if (guess(mid) == 0) {
                return mid;
            } else {
                st = mid + 1;
            }
        }
        return st;
    }

    public static int guess(int mid) {
        double i = Math.random();
        if (i <= 0.3) {
            return -1;
        } else if (i <= 0.6) {
            return 0;
        } else {
            return 1;
        }
    }
}
