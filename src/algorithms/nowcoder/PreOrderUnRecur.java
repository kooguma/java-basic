package algorithms.nowcoder;

import common.TreeNode;

import java.util.Stack;

public class PreOrderUnRecur {

    public static void solution(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.val + "");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }

            }
            System.out.println();
        }
    }
}
