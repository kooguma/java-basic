package algorithms.leetcode;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//leetcode 515  二叉树每行最大的数
public class FindLargestValueInEachTreeRow {

    public static List<Integer> solution(TreeNode root){
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                max = Math.max(max, cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            result.add(max);
            max = Integer.MIN_VALUE;
        }
        return result;
    }
}
