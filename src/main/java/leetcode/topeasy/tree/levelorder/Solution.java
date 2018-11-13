package leetcode.topeasy.tree.levelorder;

import java.util.ArrayList;
import java.util.List;

import leetcode.topeasy.tree.TreeNode;

public class Solution {
   public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> result = new ArrayList<>();
      if (root == null) return result;

            List<TreeNode> lList = new ArrayList<>();
      lList.add(root);

      while (!lList.isEmpty()) {
         List<Integer> level = new ArrayList<>();
         List<TreeNode> lList1 = new ArrayList<>();

         for (int i = 0; i < lList.size(); i++) {
            level.add(lList.get(i).val);
            if (lList.get(i).left != null) {
               System.out.print(lList.get(i).left.val);
               lList1.add(lList.get(i).left);
            }
            if (lList.get(i).right != null) {
               System.out.print(lList.get(i).right.val);
               lList1.add(lList.get(i).right);
            }
         }
         System.out.println();

         lList.clear();
         lList.addAll(lList1);
         result.add(level);
      }

      return result;
   }
}
