package algorithms.nowcoder;

import common.TreeNode;

public class IsAVL {

    public static boolean solution(TreeNode head) {
        boolean res[] = new boolean[1];
        res[0] = true;
        getHeight(head, 1, res);
        return res[0];
    }

    public static int getHeight(TreeNode head, int level, boolean[] res) {
        //退出条件
        if (head == null) return level;

        int lh, rh;

        lh = getHeight(head.left, level + 1, res);
        //左子树退出条件
        if (!res[0]) {
            return level;
        }

        rh = getHeight(head.left, level + 1, res);
        //右子树退出条件
        if (!res[0]) {
            return level;
        }

        if (Math.abs(lh - rh) > 1) {
            res[0] = false;
        }

        return Math.max(lh, rh);

    }


}
