package algorithms.nowcoder;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

//二叉树层序遍历
public class LevelOrderUnRecur {


    public static void solution(TreeNode root){
        if(root == null)
            return;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode cur;
        while (!queue.isEmpty()){
            cur = queue.peek();
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
            queue.poll();
        }
    }
}
