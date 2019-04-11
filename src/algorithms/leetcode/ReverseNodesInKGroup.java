package algorithms.leetcode;


public class ReverseNodesInKGroup {

    /**
     * Given this linked list : 1->2->3->4->5
     * <p>
     * for k = 2, you should return: 2->1->4->3->5
     * for k = 3, you should returnL 3->2->1->4->5
     *
     *
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode solution1(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) return head;
        int count = 0;
        ListNode cur = head;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;

        }

        if (count == k) {
            cur = solution1(cur, k);
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur;
        }

        return head;
    }


    public static ListNode solution2(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode begin = dummy;
        int i = 0;
        while (head != null) {
            i++;
            if (i % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }

    public static ListNode reverse(ListNode begin, ListNode end) {
        ListNode cur = begin.next;
        ListNode next, first;
        ListNode prev = begin;
        first = cur;
        while (cur != end) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        begin.next = prev;
        first.next = cur;
        return first;
    }

    /**
     *
     *  Dummy -> 1 -> 2 -> 3 -> 4 -> 5 k=3
     *      p   c          n
     *
     *  Dummy -> 2 -> 3 -> 1 -> 4 -> 5
     *      p   c     n    start
     *
     *  Dummy -> 3 -> 2 -> 1 -> 4 -> 5
     *      p   c          start
     *          n
     *
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode solution3(ListNode head, int k) {

        if (head == null || head.next == null || k < 2) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode tail = dummy, pre = dummy, temp;

        int count = 0;

        while (true) {
            count = k;
            while (count > 0 && tail != null) {
                count--;
                tail = tail.next;
            }
            if (tail == null) break;

            head = pre.next;

            //插到尾巴后面
            while (pre.next != tail) {
                temp = pre.next;
                pre.next = temp.next;
                temp.next = tail.next;
                tail.next = temp;
            }

            tail = head;
            pre = head;
        }

        return dummy.next;
    }
}
