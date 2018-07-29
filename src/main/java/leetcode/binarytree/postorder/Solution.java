package leetcode.binarytree.postorder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import leetcode.binarytree.TreeNode;

public class Solution {
   class Container {
      TreeNode node;
      boolean left;
      boolean right;

      public Container(TreeNode current) {
         node = current;
      }

      public String toString() {
         return node.toString();
      }
   }

   public List<Integer> postorderTraversal(TreeNode root) {
      if (root == null) {
         return Collections.emptyList();
      }

      TreeNode current = root;
      Deque<Container> history = new ArrayDeque<>();
      List<Integer> result = new ArrayList<>();
      while (current != null || !history.isEmpty()) {
         while (current != null) {
            history.push(new Container(current));
            current = current.left;
         }

         while (!history.isEmpty() && history.peek().node.right == null) {
            Container tmp = history.pop();
            result.add(tmp.node.val);
         }

         current = null;

         while (!history.isEmpty() && history.peek().right) {
            Container tmp = history.pop();
            result.add(tmp.node.val);
         }
         current = null;

         if(!history.isEmpty()) {
            history.peek().right = true;
            current = history.peek().node.right;
            Container tmp = new Container(current);
//            history.push(tmp);
         }
      }

      return result;
   }
}
