package algorithms.leetcode;

//112 root to leaf 二中是否存在指定sum的路径
public class PathSum1{

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean solution(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == sum;
        int newSum = sum - root.val;
        return solution(root.left, newSum) || solution(root.right, newSum);
    }
}
