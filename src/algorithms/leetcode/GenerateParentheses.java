package algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static List<String> solution(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        helper(res, "", n, n);
        return res;
    }

    public static void helper(List<String> res, String s, int l, int r) {
        if (l > r) {
            return;
        }

        if (l == 0 && r == 0) {
            res.add(s);
            return;
        }

        if (l > 0) {
            helper(res, s + "(", l - 1, r);
        }

        if (r > 0) {
            helper(res, s + ")", l, r - 1);
        }
    }
}
