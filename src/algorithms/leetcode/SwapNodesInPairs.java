package algorithms.leetcode;

//24
public class SwapNodesInPairs {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public static ListNode solution1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode p = result;
        ListNode c = head;
        ListNode n = head.next;
        while (head != null && head.next != null) {
            head = head.next.next;
            p.next = n;
            c.next = n.next;
            n.next = c;
            p = c;
            if (c.next == null) {
                break;
            }
            n = c.next.next;
            c = c.next;
        }
        return result.next;
    }

    //2个指针
    public static ListNode solution2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode lead = dummy;

        while (head != null && head.next != null) {
            lead.next = head.next;
            head.next = head.next.next;
            lead.next.next = head;
            //update lead and head
            lead = head;
            head = head.next;
        }

        return dummy.next;
    }

}
