package algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

//输出所有路径 root to leaf
public class PathSum2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> solution(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(root, sum, path, res);
        return res;
    }

    public static void helper(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            //叶子节点
            if (root.val == sum) {
                res.add(new ArrayList<>(path));

            }
            return;
        }
        int newSum = sum - root.val;
        if (root.right != null) {
            helper(root.left, newSum, path, res);
            //没找到，回到上个节点
            path.remove(path.size() - 1);
        }
        if (root.left != null) {
            helper(root.right, newSum, path, res);
            //没找到，回到上个节点
            path.remove(path.size() - 1);
        }
    }
}
