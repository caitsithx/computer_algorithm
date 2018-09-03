package leetcode.topeasy.tree.maxdepth;

import java.util.Stack;

import leetcode.topeasy.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
   public int maxDepth(TreeNode root) {
      if(root == null) {
         return 0;
      }

      Stack<TreeNode> history = new Stack<>();
      TreeNode pre = null;
      TreeNode current = root;
      int maxDep = 0;
      int dep = 0;
      while (current != null || !history.isEmpty()) {
         while (current != null) {
            history.push(current);
            current = current.left;
            dep ++;
         }

         if(dep > maxDep) {
            maxDep = dep;
         }

         current = history.peek();

         if(current.right != null && current.right != pre) {
            current = current.right;
         } else {
            dep --;
            history.pop();
            pre = current;
            current = null;
         }
      }

      return maxDep;
   }
}

