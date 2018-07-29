package leetcode.binarytree.leafsimilar;

import java.util.ArrayList;
import java.util.List;

import leetcode.binarytree.TreeNode;

public class Solution {
   public boolean leafSimilar(TreeNode root1, TreeNode root2) {
      List<TreeNode> leaves1 = new ArrayList<>();
      List<TreeNode> leaves2 = new ArrayList<>();
      getLeaves(root1, leaves1);
      getLeaves(root2, leaves2);

      if (leaves1.size() != leaves2.size()) {
         return false;
      } else {
         for (int i = 0; i < leaves1.size(); i++) {
            if (leaves1.get(i).val != leaves2.get(i).val) {
               return false;
            }
         }

         return true;
      }
   }

   private void getLeaves(TreeNode root1, List<TreeNode> leaves1) {
      if (root1.left == null && root1.right == null) {
         leaves1.add(root1);
      } else {
         if (root1.left != null) {
            getLeaves(root1.left, leaves1);
         }
         if (root1.right != null) {
            getLeaves(root1.right, leaves1);
         }
      }
   }
}
