package leetcode.topeasy.array.rotate;

public class Solution {
   public void rotate(int[] nums, int k) {
      for (int i = 0; i < k; i++) {
         rotate1(nums);
      }
   }

   private void rotate1(int[] nums) {
      int tmp;
      for (int i = 1; i < nums.length; i++) {
         tmp = nums[i];
         nums[i] = nums[0];
         nums[0] = tmp;
      }
   }
}
