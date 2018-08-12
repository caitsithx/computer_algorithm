package leetcode.topeasy.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static leetcode.topeasy.linkedlist.MergeSorted.stringToListNode;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode revert = null;
        if (fast != null) {
            revert = reverseList(slow.next);
        } else {
            revert = reverseList(slow);
        }

        while (revert != null) {
            if (head.val != revert.val) {
                return false;
            }

            revert = revert.next;
            head = head.next;
        }

        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode newList = null;
        while (head != null) {
            ListNode newNode = head;
            head = head.next;
            if (newList != null) {
                newNode.next = newList;
            } else {
                newNode.next = null;
            }

            newList = newNode;


        }

        return newList;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = stringToListNode(line);

            new IsPalindrome().isPalindrome(l1);
        }
    }
}
