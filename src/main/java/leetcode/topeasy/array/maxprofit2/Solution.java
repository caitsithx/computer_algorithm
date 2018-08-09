package leetcode.topeasy.array.maxprofit2;

public class Solution {
   public int maxProfit(int[] prices) {
      int[] pair = new int[] {-1, -1};
      int sum = 0;
      int diff = 0;
      for (int price : prices) {
         if(pair[0] == -1) {
            pair[0] = price;
         } else {
            if (pair[1] == -1) {
               if(pair[0] >= price) {
                  pair[0] = price;
               } else {
                  pair[1] = price;
               }
            } else {
               if(pair[1] <= price) {
                  pair[1] = price;
               } else {
                  sum += (pair[1] - pair[0]);
                  pair[0] = price;
                  pair[1] = -1;
               }
            }
         }
      }

      if(pair[1] != -1) {
         sum += (pair[1] - pair[0]);
      }

      return sum;
   }

   public static void main(String[] args) {
      System.out.println(new Solution().maxProfit(new int[]{1,2,3,4,5}));
   }
}
