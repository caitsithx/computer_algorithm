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
      history.push(root);
      TreeNode current;

      while (!history.isEmpty()) {
         current = history.lastElement();
         while (current.left != null) {
            current = current.left;
            history.push(current);
         }


         history.pop();
         result.add(current.val);

         while(!history.isEmpty() && current.right == null) {
            current = history.pop();
            result.add(current.val);
         }  
         if(current.right != null) {
            history.push(current.right);
         }
      }


      return result;
   }
}
