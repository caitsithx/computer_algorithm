package leetcode.maxprofit;

import java.util.Arrays;

public class Solution3 {


   public static void main(String[] args) {
//      System.out.println(Arrays.toString(new Solution3().maxFromHead(new int[]{6, 1, 3, 2, 4, 7})));
//      System.out.println(Arrays.toString(new Solution3().maxFromEnd(new int[]{6, 1, 3, 2, 4, 7})));
//      System.out.println(new Solution3().maxProfit(new int[]{6, 1, 3, 2, 4, 7}));
//
//      System.out.println(Arrays.toString(new Solution3().maxFromHead(new int[]{1, 4,2})));
//      System.out.println(Arrays.toString(new Solution3().maxFromEnd(new int[]{1, 4,2})));
//      System.out.println(new Solution3().maxProfit(new int[]{1, 4,2}));


      System.out.println(Arrays.toString(new Solution3().maxFromHead(new int[]{2,1,2,1,0,0,1})));
      System.out.println(Arrays.toString(new Solution3().maxFromEnd(new int[]{2,1,2,1,0,0,1})));
      System.out.println(new Solution3().maxProfit(new int[]{2,1,2,1,0,0,1}));

//      System.out.println(new Solution3().maxProfit(new int[]{2,1,2,0,1}));
//      System.out.println(new Solution3().maxFromHead(new int[]{1,2,3,4,5}));
//      System.out.println(new Solution3().maxFromHead(new int[]{7,6,4,3,1}));
//      System.out.println(new Solution3().maxFromHead(new int[]{3,3,5,0,0,3,1,4}));

   }

   public int maxProfit(int[] prices) {
      if(prices.length < 2) {
         return 0;
      } else
      if (prices.length == 2) {
         int profit=prices[1] - prices[0];
         return profit > 0 ? profit : 0;
      }


      int[] maxFromHead = maxFromHead(prices);
      int[] maxFromEnd = maxFromEnd(prices);

      int max = 0;
      for(int i = 1; i < prices.length - 1; i ++) {
         int current = Math.max(maxFromHead[i], maxFromEnd[i]);
         current = Math.max(current, maxFromHead[i] + maxFromEnd[i]);

         if(current > max) {
            max = current;
         }
      }

      return max;
   }

   public int[] maxFromEnd(int[] prices) {
      if (prices.length >= 2) {
         int[] maxFromEnd = new int[prices.length];
         maxFromEnd[prices.length - 2] = prices[prices.length - 1] - prices[prices.length - 2];
         int max = Math.max(prices[prices.length - 1], prices[prices.length - 2]);

         for (int i = prices.length - 3; i >= 0; i--) {
            int tmp = max - prices[i];
            if (prices[i] > max) {
               max = prices[i];
               maxFromEnd[i] = maxFromEnd[i + 1];
            } else if(prices[i] == max) {
               maxFromEnd[i] = maxFromEnd[i + 1];
            } else if (tmp > maxFromEnd[i + 1]) {
               maxFromEnd[i] = tmp;
            } else if(prices[i] < max) {
               maxFromEnd[i] = maxFromEnd[i + 1];
            }
         }

         return maxFromEnd;
      }

      return null;
   }

   public int[] maxFromHead(int[] prices) {
      if (prices.length >= 2) {

         int[] maxFromHead = new int[prices.length];
         maxFromHead[1] = prices[1] - prices[0];
         int min = Math.min(prices[0], prices[1]);

         for (int i = 2; i < prices.length; i++) {
            int tmp = prices[i] - min;
            if (prices[i] < min) {
               min = prices[i];
               maxFromHead[i] = maxFromHead[i - 1];
            } else if (prices[i] < min) {
               maxFromHead[i] = maxFromHead[i - 1];
            }
            else if (tmp > maxFromHead[i - 1]) {
               maxFromHead[i] = tmp;
            } else if (prices[i] > min) {
               maxFromHead[i] = maxFromHead[i - 1];
            }
         }

         return maxFromHead;
      }

      return null;
   }
}
