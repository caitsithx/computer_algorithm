package leetcode.topeasy.tree.issymmetric;

import java.util.ArrayList;
import java.util.List;

import leetcode.topeasy.tree.TreeNode;

public class Solution1 {
   public boolean isSymmetric(TreeNode root) {
      if (root == null) return true;


      return isSymmetric(root.left, root.right);
   }

   private boolean equals(TreeNode o1, TreeNode o2) {
       return o1 == o2 || (o1 != null && o2 != null && o1.val == o2.val);
   }

   private boolean isSymmetric(TreeNode left, TreeNode right) {
      if (left == null && right == null) {
         return true;
      } else if (left != null && right != null) {
         List<TreeNode> lList = new ArrayList<>();
         List<TreeNode> rList = new ArrayList<>();
         lList.add(left);
         rList.add(right);
         while (!rList.isEmpty() || !lList.isEmpty()) {
            if(lList.size() != rList.size()) {
               return false;
            }

            List<TreeNode> lList1 = new ArrayList<>();
            List<TreeNode> rList1 = new ArrayList<>();

            for (int i = 0, j = 0; i < lList.size() && j < rList.size(); i++, j++) {
               if(!equals(lList.get(i), rList.get(j))) {
                  return false;
               }
               if(lList.get(i) != null) {
                  lList1.add(lList.get(i).left);
                  lList1.add(lList.get(i).right);
               }
               if(rList.get(j) != null) {
                  rList1.add(rList.get(j).right);
                  rList1.add(rList.get(j).left);
               }
            }

            lList.clear();
            lList.addAll(lList1);
            rList.clear();
            rList.addAll(rList1);
         }

         return true;
      } else {
         return false;
      }
   }
}
