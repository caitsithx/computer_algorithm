package leetcode.topeasy.linkedlist;

public class DeleteNode {
    public void deleteNode(ListNode node) {
        if(node.next == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
