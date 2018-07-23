package leetcode.binarytree.inorder;

import java.util.ArrayList;
import java.util.List;

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
class Solution {
   public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();

      if(root != null) {

         if (root.left != null) {
            result.addAll(inorderTraversal(root.left));
         }
         result.add(root.val);

         if (root.right != null) {
            result.addAll(inorderTraversal(root.right));
         }
      }

      return result;
   }
}
