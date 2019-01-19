package algorithms.leetcode;

//23
public class MergeKSortedList {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public static ListNode solution(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int length = lists.length;
        int interval = 1;
        while (interval < length) {
            for (int i = 0; i < length - interval; i += interval * 2) {
                lists[i] = merge2SortedList(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }

    public static ListNode merge2SortedList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        while (l1 != null || l2 != null) {
            if (l2 == null || (l1 != null) && l1.val <= l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        return dummy.next;
    }
}
