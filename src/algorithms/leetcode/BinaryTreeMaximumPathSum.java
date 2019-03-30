package algorithms.leetcode;

//二叉树最大值
public class BinaryTreeMaximumPathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 回溯
    public static int solution(TreeNode root) {
        if (root == null) return 0;
        int[] res = new int[]{Integer.MIN_VALUE};
        helper(root,res);
        return res[0];
    }

    public static int helper(TreeNode root, int[] res) {
        if (root == null) return 0;
        int l = Math.max(0, helper(root.left, res));
        int r = Math.max(0, helper(root.right, res));
        int sum = root.val + l + r;
        res[0] = Math.max(res[0],sum); //update res[0]
        return Math.max(l,r) + root.val; // what should I give to my parent ?
    }
}
