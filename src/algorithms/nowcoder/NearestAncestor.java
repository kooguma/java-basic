package algorithms.nowcoder;

import common.TreeNode;

public class NearestAncestor {


    //后续遍历
    public TreeNode solution(TreeNode head, TreeNode o1, TreeNode o2){

        if( head == null || o1 == null || o2 == null){
            return head;
        }

        TreeNode left = solution(head.left,o1,o2);
        TreeNode right = solution(head.right,o1,o2);

        if (left != null && right != null){
            return head;
        }

        return left != null ? left : right;
    }
}
