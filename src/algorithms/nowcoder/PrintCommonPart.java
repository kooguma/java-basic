package algorithms.nowcoder;

//打印两个有序链表的公共部分
public class PrintCommonPart {

    public class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public void solution(Node head1, Node head2) {
        System.out.println("The common part is:");
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                head1 = head1.next;
            } else if (head1.val > head2.val) {
                head2 = head2.next;
            } else {
                System.out.print(head1.val);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }
}
