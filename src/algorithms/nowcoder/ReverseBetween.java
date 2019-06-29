package algorithms.nowcoder;

import common.ListNode;

//leetcode 92 ReverseBetween 反转部分链表 from to
public class ReverseBetween {

    /*
    条件: 1<=m<=n<=len
     */
    public static ListNode solution1(ListNode head, int from, int to) {
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

        //边界条件
        if (from > to || from < 1 || to > len) {
            return head;
        }

        //2.反转链表
        ListNode pre = front == null ? head : front.next;
        ListNode newHead = pre.next;
        pre.next = tail;
        ListNode next = null;

        while (newHead != tail) {
            next = newHead.next;
            newHead.next = pre;
            pre = newHead;
            newHead = next;
        }

        if (front != null) {
            front.next = pre;
            return head;
        }

        return pre;

    }

    public static ListNode solution2(ListNode head, int from, int to) {
        int len = 0;
        ListNode node1 = head;
        ListNode fpre = null;
        ListNode tpos = null;

        while (node1 != null) {
            len++;
            fpre = len == from - 1 ? node1 : fpre;
            tpos = len == to + 1 ? node1 : tpos;
            node1 = node1.next;
        }

        if (from > to || from < 1 || to > len) {
            return head;
        }

        node1 = fpre == null ? head : fpre.next;
        ListNode node2 = node1.next;
        node1.next = tpos;
        ListNode next = null;

        while (node2 != tpos){
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }

        if( fpre != null){
            fpre.next = node1;
            return head;
        }

        return node1;
    }
}
