package leetcode.maxprofit;

public class Solution2 {

   public int maxProfit(int[] prices) {
      int diff =0;
      if(prices.length > 0) {
         int min = prices[0];
         int subDiff = 0;

         boolean bull = true;
         for(int price : prices) {
            int tmp = price - min;

            if(bull) {
               if(subDiff < tmp) {
                  subDiff = tmp;
               } else if (subDiff > tmp) {
                  bull = false;
                  min = price;
                  diff += subDiff;
                  subDiff = 0;
               }
            } else {
               if(tmp <= 0) {
                  min = price;
               } else {
                  bull = true;
                  subDiff = tmp;
               }
            }
         }

         if(subDiff > 0) {
            diff += subDiff;
         }
      }


      return diff;
   }

   public static void main(String[] args) {
      System.out.println(new Solution2().maxProfit(new int[]{1,2,3,4,5}));
      System.out.println(new Solution2().maxProfit(new int[]{7,6,4,3,1}));


   }
}
