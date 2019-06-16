package algorithms.nowcoder;

//反转单链表，基本操作
public class ReverseNode {

    public class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node solution(Node head) {
        Node pre = null;
        Node next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }
}
