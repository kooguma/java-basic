package algorithms.leetcode;

//19
public class RemoveNthNodeFromEndOfList {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    //one pass
    public static ListNode solution1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }


    /*
        不知道链表长度
        1.边界条件 head = null || k < 1 return head
        2.k--
     */

    public static ListNode solution2(ListNode head, int k) {
        //边界条件
        if (head == null || k < 0) return head;

        ListNode cur = head;

        while (cur != null){
            k--;
            cur = cur.next;
        }

        if(k >= 0) return head;

        cur = head;

        while ( k != 0){
            cur = cur.next;
            k++;
        }

        cur.next = cur.next.next;

        return head;

    }
}
