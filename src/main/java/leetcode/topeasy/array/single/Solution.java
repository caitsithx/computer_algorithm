package leetcode.topeasy.array.single;

class Solution {
   public int singleNumber(int[] nums) {
      int[] bits = new int[32];

      int result = 0;
      for (int i = 0; i < 32; i++) {
         for (int num : nums) {
            bits[i] += (1 & (num >> i));
         }
         result += ((bits[i] % 2) << i);
      }



      return result;
   }


   public static void main(String[] args) {
      new Solution().singleNumber(new int[] {1,1,2});
   }
}
