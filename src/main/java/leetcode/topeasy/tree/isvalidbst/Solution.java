package leetcode.topeasy.tree.isvalidbst;

import java.util.Stack;

import leetcode.topeasy.tree.TreeNode;


class Solution {
   class ValidException extends RuntimeException {

   }

   public boolean isValidBST(TreeNode root) {
      if (root == null) {
         return true;
      }

      Stack<TreeNode> history = new Stack<>();
      TreeNode current = root;
      TreeNode pre = null;

      while (current != null || !history.isEmpty()) {
         while (current != null) {
            history.push(current);
            current = current.left;
         }

         current = history.pop();
         if (pre != null && pre.val >= current.val) {
            return false;
         }

         if (current.right != null) {
            if (current.val >= current.right.val) {
               return false;
            }
         }
         pre = current;

         current = current.right;
      }

      return true;
   }
}
