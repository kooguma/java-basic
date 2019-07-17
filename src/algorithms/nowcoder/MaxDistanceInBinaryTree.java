package algorithms.nowcoder;

import common.TreeNode;

public class MaxDistanceInBinaryTree {

    public int solution(TreeNode root){
        int[] record = new int[1];
        return posOrder(root,record);
    }

    public int posOrder(TreeNode head,int[] record){
        if(head == null){
            record[0] = 0;
            return 0;
        }
        int lmax = posOrder(head.left,record);
        int maxfromLeft = record[0];
        int rmax = posOrder(head.right,record);
        int maxFromRight = record[0];
        int curNodeMax = maxfromLeft + maxFromRight + 1;
        record[0] = Math.max(maxfromLeft,maxFromRight) + 1;
        return Math.max(Math.max(lmax,rmax),curNodeMax);
    }
}
