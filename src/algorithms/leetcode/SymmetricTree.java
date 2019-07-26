package algorithms.leetcode;

import common.TreeNode;

//101 二叉树是否中心对称
public class SymmetricTree {

    public boolean solution(TreeNode root) {
        if (root == null) {
            return true;
        }

        return hasSymmetry(root.left, root.right);
    }

    public boolean hasSymmetry(TreeNode T1, TreeNode T2) {
        if (T1 == null && T2 == null) {
            return true;
        }

        if (T1 == null || T2 == null) {
            return false;
        }

        if (T1.val == T2.val) {
            if (hasSymmetry(T1.right, T2.left) && hasSymmetry(T1.left, T2.right)) {
                return true;
            }
        }

        return false;
    }


}
