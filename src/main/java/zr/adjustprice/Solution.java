package zr.adjustprice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class Solution {
   static class Price {
      double price;
      int index;

      Price(double price, int index) {
         this.price = price;
         this.index = index;
      }
   }

   public static long[] solution(double[] prices) {
      if(prices == null) return null;

      long[] result = new long[prices.length];
      List<Price> subPrices = new ArrayList<>(prices.length);
      for (int i = 0; i < prices.length; i++) {
         if (Math.ceil(prices[i]) != prices[i]) {
            subPrices.add(new Price(prices[i], i));
         } else {
            result[i] = (long)prices[i];
         }
      }

      long sum = Math.round(subPrices.stream().mapToDouble(p -> p.price).sum());
      for (Iterator<Price> iterator = subPrices.iterator(); iterator.hasNext(); ) {
         Price price = iterator.next();
         long rounded = Math.round(price.price);
         if (rounded > price.price) {
            result[price.index] = rounded;
            iterator.remove();
            sum -= rounded;
         }
      }

      for (Price price : subPrices) {
         sum -= Math.floor(price.price);
      }
      subPrices.sort((p1, p2) -> {
         double diff = p1.price - Math.floor(p1.price) - p2.price + Math.floor(p2.price);
         if (diff > 0) {
            return 1;
         } else if (diff < 0) {
            return -1;
         } else {
            return 0;
         }
      });

      int count = 0;
      for (Price price : subPrices) {
         if (subPrices.size() - count > sum) {
            result[price.index] = (long) Math.floor(price.price);
         } else {
            result[price.index] = (long) Math.ceil(price.price);
         }
         count++;
      }

      return result;
   }

   static double[] prices = {5.4, 3.3, 5.0};
   static double[] prices1 = {5.8, 5.3, 5.4, 5.4, 3.3, 5.0};
   static double[] prices2 = {5.1, 5.1, 5.1, 5.1, 3.3, 5.0};



   public static void main(String[] args) {
     System.out.println(Arrays.toString(solution(prices2)));
   }
}
