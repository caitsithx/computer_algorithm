package leetcode.binarytree.inorder;

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
   public List<Integer> inorderTraversal(TreeNode root) {
      if (root == null) {
         return Collections.emptyList();
      }

      List<Integer> result = new ArrayList<>();
      Stack<TreeNode> history = new Stack<>();
      TreeNode current = root;

      while (current != null || !history.isEmpty()) {
         while (current != null) {
            history.push(current);
            current = current.left;
         }

         current = history.pop();
         result.add(current.val);
         current = current.right;
      }
      return result;
   }
}
