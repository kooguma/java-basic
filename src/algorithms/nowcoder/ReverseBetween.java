package algorithms.nowcoder;

import java.awt.print.Pageable;

//leetcode 92 ReverseBetween 反转部分链表 from to
public class ReverseBetween {

    class ListNode {
        int val;
        ListNode next;
    }

    /*
    条件: 1<=m<=n<=len
     */
    public ListNode solution(ListNode head, int from, int to) {
        //1.先找 front tail
        ListNode cur = head;
        ListNode front = null;
        ListNode tail = null;
        int len = 0;

        while (cur != null) {
            len++;
            front = len == from - 1 ? cur : front;
            tail = len == to + 1 ? cur : tail;
            cur = cur.next;
        }

        cur = front == null ? head : front.next;
        ListNode tmp = cur.next;
        ListNode next = null;

        while (tmp != tail) {
            next = tmp.next;
            tmp.next = cur;
            cur = tmp;
            tmp = next;
        }

        if(front != null){
            front.next = cur;
            return head;
        }

        return cur;
    }

}
