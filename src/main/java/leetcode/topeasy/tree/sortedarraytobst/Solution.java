package leetcode.topeasy.tree.sortedarraytobst;

import leetcode.topeasy.tree.TreeNode;

public class Solution {
   public TreeNode sortedArrayToBST(int[] nums) {
      TreeNode root = null;
      if (nums.length == 1) {
         root = new TreeNode(nums[0]);
      } else if (nums.length == 2) {
         root = new TreeNode(nums[0]);
         root.right = new TreeNode(nums[1]);
      } else if (nums.length > 2) {
         int middle = nums.length /2;
         root = new TreeNode(nums[middle]);
         int[] left = new int[middle];
         System.arraycopy(nums, 0, left, 0, middle);
         root.left = sortedArrayToBST(left);
         int[] right = new int[nums.length - middle - 1];
         System.arraycopy(nums, middle + 1, right, 0, nums.length - middle - 1);
         root.right = sortedArrayToBST(right);
      }

      return root;
   }
}
