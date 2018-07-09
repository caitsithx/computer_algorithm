package leetcode.maxprofit;

import org.junit.Test;

public class Solution {
   public int maxProfit(int[] prices) {

      int diff = 0;

      if(prices.length > 0) {
         int min = prices[0];

         for (int price : prices) {
            int tmp = price - min;
            if (tmp < 0) {
               min = price;
            } else if (tmp > diff) {
               diff = tmp;
            }
         }
      }

      return diff;
   }

   @Test
   public void test() {
      System.out.println(new Solution().maxProfit(new int[] {7,1,5,3,6,4}));
   }

}
