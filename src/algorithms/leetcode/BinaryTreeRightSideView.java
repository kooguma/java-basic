package algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

    /**
     * Input: [1,2,3,null,5,null,4]
     * Output: [1, 3, 4]
     * Explanation:
     * <p>
     * 1            <---
     * /   \
     * 2     3         <---
     * \     \
     * 5     4       <---
     * <p>
     * res.size = 1 level =1
     * res.size = 2 level =2
     **/

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> solution(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, 1, res);
        return res;
    }

    private void helper(TreeNode root, int level, List<Integer> res) {
        if (root == null) return;
        if (res.size() == level) {
            res.add(root.val);
        }
        helper(root.right, level + 1, res);
        helper(root.left, level + 1, res);
    }
}
