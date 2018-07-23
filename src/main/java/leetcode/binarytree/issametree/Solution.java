package leetcode.binarytree.issametree;

import leetcode.binarytree.TreeNode;

public class Solution {
   public boolean isSameTree(TreeNode p, TreeNode q) {
      if(p == null && q == null) {
         return true;
      } else if(p != null && q!= null) {
         return p.val == q.val && isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
      } else {
         return false;
      }
   }
}
