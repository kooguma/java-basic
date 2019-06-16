package algorithms.nowcoder;

public class ReverseDulNode {

    public class DulNode {
        int value;
        DulNode pre;
        DulNode next;

        public DulNode(int value) {
            this.value = value;
        }
    }

    public DulNode solution(DulNode head) {
        DulNode pre = null;
        DulNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }

        return pre;
    }
}
