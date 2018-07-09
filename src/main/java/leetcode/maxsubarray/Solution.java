package leetcode.maxsubarray;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/description/
 *
 * @author xiaoliangl
 */
public class Solution {
   public int maxSubArray(int[] nums) {
      int[] max = null;
      int maxLen = 1;

      int tmp = 0;
      int len = 0;
      for(int num : nums) {
         tmp += num;
         if(max == null) {
            max = new int[1];
            max[0] = tmp;
         } else {
            if(tmp > max[0]) {
               max[0] = tmp;
            }
         }

         if(tmp < 0) {
            tmp = 0;
         }
      }

      return max[0];
   }

   public static void main(String[] args) {
     System.out.println( new Solution().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
      System.out.println( new Solution().maxSubArray(new int[]{-2}));
      System.out.println( new Solution().maxSubArray(new int[]{-2, -1}));


   }
}
