package leetcode.topeasy.linkedlist;

public class Reverse {
    public ListNode reverseList(ListNode head) {
        ListNode newList = null;
        while (head!= null) {
            ListNode newNode = new ListNode(head.val);
            if(newList != null) {
                newNode.next = newList;
            }

            newList = newNode;

            head = head.next;
        }

        return newList;
    }
}
