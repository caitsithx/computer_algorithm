package leetcode.binarytree.issubtree;

import leetcode.binarytree.TreeNode;

public class Solution {
   public boolean isSubtree(TreeNode s, TreeNode t) {
      if (s == null) return false;
      if (t == null) return true;

      if (s.val == t.val && compareSubTree(s, t)) {
         return true;
      } else if (isSubtree(s.left, t)) {
         return true;
      } else return isSubtree(s.right, t);
   }

   private boolean compareSubTree(TreeNode s, TreeNode t) {
      if ((s == null && t != null) || (s != null && t == null)) {
         return false;
      } else if (s != null) {
         if (s.val == t.val) {
            return compareSubTree(s.left, t.left) && compareSubTree(s.right, t.right);
         } else {
            return false;
         }
      }

      return true;
   }
}