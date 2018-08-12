package leetcode.topeasy.linkedlist;

import org.junit.jupiter.api.Test;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nth = head;
        ListNode end = head;

        int i = 0;
        while (i < n ) {
            end = end.next;
            i++;
        }


        if (end == null) {
            return head.next;
        }

        while (end.next != null) {
            end = end.next;
            nth = nth.next;
        }

        nth.next = nth.next.next;

        return head;

    }

    @Test
    public void test() {
        new RemoveNthFromEnd().removeNthFromEnd(new ListNode(1), 1);
    }
}
