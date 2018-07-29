package leetcode.linkedlist.removenthfromend;

import leetcode.linkedlist.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution1 {
   public ListNode removeNthFromEnd(ListNode head, int n) {
      if(head == null) return null;

      ListNode current = head;
      ListNode current1 = head;
      for (int i = 0; i < n; i++) {
         current1 = current1.next;
      }

      ListNode prev = null;
      while(current1 != null) {
         prev = current;
         current = current.next;
         current1 = current1.next;
      }

      if(prev == null) {
         return current.next;
      } else {
         prev.next = current.next;
         return head;
      }
   }

   public static void main(String[] args) {
      ListNode n1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
      System.out.println(new Solution1().removeNthFromEnd(n1, 2));
   }
}


