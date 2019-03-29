package algorithms.leetcode;


public class ReverseNodesInKGroup {

    /**
     * Given this linked list : 1->2->3->4->5
     * <p>
     * for k = 2, you should return: 2->1->4->3->5
     * for k = 3, you should returnL 3->2->1->4->5
     * <p>
     * 1->2->3->4->5  k=2
     * count = 0 , cur = 1
     * count = 1 , cur = 2
     * 3->4->5
     * count = 0 , cur = 3
     * count = 1 , cur = 4
     * count = 2 , cur = 5
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode solution(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) return head;
        int count = 0;
        ListNode cur = head;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;

        }

        if (count == k) {
            cur = solution(cur, k);
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


}
