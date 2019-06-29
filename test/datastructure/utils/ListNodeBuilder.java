package datastructure.utils;

import common.ListNode;

public class ListNodeBuilder {

    private ListNode head;
    private ListNode cur;

    public ListNodeBuilder append(int[] values) {
        for (int value : values) {
            appendValue(value);
        }
        return this;
    }

    public ListNodeBuilder append(int value) {
        appendValue(value);
        return this;
    }

    private void appendValue(int value) {
        ListNode node = new ListNode(value);
        if (head == null) {
            head = node;
            cur = head;
        } else {
            cur.next = node;
            cur = cur.next;
        }
    }

    public ListNodeBuilder clear(){
        head = null;
        cur = null;
        return this;
    }

    public ListNode build() {
        return head;
    }
}
