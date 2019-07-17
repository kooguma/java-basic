package algorithms.nowcoder;

import common.TreeNode;

import java.util.Stack;

public class InOrderUnRecur {

    public static void solution(TreeNode head) {
        System.out.println("in-order:");
        if (head != null) {
            //empty stack
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head.val + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }
}
