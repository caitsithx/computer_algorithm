package leetcode.iscirculate;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/articles/linked-list-cycle/#
 */
public class LinkedListCycle {
   class Node {
      private int value;
      private Node next;
   }

   private List<Node> visited = new ArrayList<>();

   public boolean isCirculate(Node linkedList) {
      Node tmp = linkedList;
      while (tmp.next != null) {
         visited.add(tmp);
         tmp = tmp.next;
         if (visited.contains(tmp)) {
            return true;
         }
      }

      return false;
   }

   public boolean isCirculate1(Node linkedList) {
      Node tmp = linkedList;
      Node tmp1 = linkedList;

      do {
         if (tmp1 == null || tmp1.next == null) {
            return true;
         }

         tmp = tmp.next;
         tmp1 = tmp1.next.next;
      } while (tmp1 != tmp);

      return true;
   }
}
