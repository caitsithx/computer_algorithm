package leetcode.topeasy.tree.issymmetric;

import leetcode.topeasy.tree.TreeNode;

public class Solution {
   public boolean isSymmetric(TreeNode root) {
      if (root == null) return true;

      return isSymmetric(root.left, root.right);
   }

   private boolean isSymmetric(TreeNode left, TreeNode right) {
      if (left != null && right != null) {
         return left.val == right.val
               && isSymmetric(left.left, right.right)
               && isSymmetric(left.right, right.left);
      } else return left == null && right == null;
   }
}
