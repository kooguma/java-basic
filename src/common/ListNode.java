package common;

import java.util.Objects;

public class ListNode {

    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return this.toString().equals(o.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, next);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(value);
        sb.append(",");
        while (next != null) {
            sb.append(next.value);
            if (next.next != null) {
                sb.append(",");
            }
            next = next.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
