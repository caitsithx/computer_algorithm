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
public class Solution {
   public ListNode removeNthFromEnd(ListNode head, int n) {
      if(head == null) return null;

      ListNode current = head;
      int count = 0;
      while(current != null) {
         count ++;
         current = current.next;
      }

      int index = count - n;

      ListNode prev = null;
      current = head;

      for (int i = 0; i <= count; i++) {
         if(i == index) {
            if (prev == null) {
               return current.next;
            } else {
               prev.next = current.next;
               return head;
            }
         }

         prev = current;
         current = current.next;
      }

      return null;
   }

   public static void main(String[] args) {
      ListNode n1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
      System.out.println(new Solution().removeNthFromEnd(n1, 2));
   }
}


