package algorithms.leetcode;

//有几条路径？ 437  not root to leaf
public class PathSum3 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static int solution(PathSum2.TreeNode root, int sum) {
        if (root == null) return 0;
        return helper(root, sum) + solution(root.left, sum) + solution(root.right, sum);
    }

    public static int helper(PathSum2.TreeNode root, int sum) {
        int count = 0;
        if (root == null) return 0;
        if (root.val == sum) count++;
        int newSum = sum - root.val;
        if (root.right != null) {
            count += helper(root.right, newSum);
        }
        if (root.left != null) {
            count += helper(root.left, newSum);
        }
        return count;

    }
}
