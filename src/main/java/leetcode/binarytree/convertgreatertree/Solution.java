package leetcode.binarytree.convertgreatertree;

import leetcode.binarytree.TreeNode;

public class Solution {
   int sum = 0;
   public TreeNode convertBST(TreeNode root) {
      if(root != null) {
         convertBST(root.right);
         sum += root.val;
         root.val = sum;
         convertBST(root.left);
      }

      return root;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(5);
      TreeNode left = new TreeNode(2);
      TreeNode right = new TreeNode(13);
      root.left = left;
      root.right = right;
      new Solution().convertBST(root);
      System.out.println(root);
   }
}
