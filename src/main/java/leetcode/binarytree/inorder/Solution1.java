package leetcode.binarytree.inorder;

import java.util.ArrayList;
import java.util.Collections;
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
class Solution1 {
   public List<Integer> inorderTraversal(TreeNode root) {
      if(root == null) return Collections.emptyList();

      List<Integer> result = new ArrayList<>();
      List<TreeNode> history = new ArrayList<>();

      TreeNode current = root;
      boolean backFromLeftChild = false;
      do{
         if(!backFromLeftChild) {
            while (current.left != null) {
               history.add(current);
               current = current.left;
            }
         } else {
            history.remove(history.size() - 1);
         }
         result.add(current.val);

         if(current.right != null) {
            history.add(current);
            current = current.right;
            backFromLeftChild = false;
         } else {
            //go up from right
            while(!history.isEmpty() && history.get(history.size() - 1).right == current) {
               current = history.remove(history.size() - 1);
            }

            //until current if the root of left sub tree
            backFromLeftChild = true;
            if(!history.isEmpty()) {
               current = history.get(history.size() - 1);
            }
         }
      } while(!history.isEmpty());

      return result;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      TreeNode right = new TreeNode(2);
      TreeNode rightLeft = new TreeNode(3);
      root.right = right;
      right.left = rightLeft;

      System.out.println(new Solution().inorderTraversal(root));

   }
}
