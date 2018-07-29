package leetcode.binarytree.postorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import leetcode.binarytree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution2 {
   public List<Integer> postorderTraversal(TreeNode root) {
      if (root == null) {
         return Collections.emptyList();
      }

      List<Integer> result = new ArrayList<>();
      Stack<TreeNode> history = new Stack<>();
      TreeNode current = root;
      TreeNode pre = null;

      while (current != null || !history.isEmpty()) {
         while (current != null) {
            history.push(current);
            current = current.left;
         }

         current = history.peek();
         if(current.right != null && pre != current.right) {
            current = current.right;
         } else {
            history.pop();
            result.add(current.val);
            pre= current;
            current = null;
         }
      }
      return result;
   }
}
