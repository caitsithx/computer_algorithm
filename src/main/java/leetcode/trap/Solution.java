package leetcode.trap;

import java.util.ArrayList;
import java.util.List;

public class Solution {

   public int trap(int[] height) {
      if(height == null || height.length < 2){
         return 0;
      }
      int max = 0;

      for(int i = 0; i < height.length - 1; i ++) {
         if (height[i] <= height[i + 1]) {
            continue;
         }

         int stat = 1;
         int heighestIndex = -1;
         for (int j = i + 2; j < height.length; j++) {
            if (stat == 1) {
               if(height[j] <= height[j - 1]) {
//                  toBeDeduct += height[j];
               } else {
                  stat = 2;
                  heighestIndex = j;
                  if(j == height.length - 1) {
                     int current = (heighestIndex - i - 1) * Math.min(height[heighestIndex], height[i]);
                     for (int k = i + 1; k < heighestIndex; k++) {
                        current -= (height[k] > height[heighestIndex] ? height[heighestIndex] : height[k]);
                     }

                     max += current;

                     i = j;
                  }
               }
            } else {
               if(height[j] >= height[j - 1]) {
//                  toBeDeduct += height[heighestIndex];
                  heighestIndex = j;
                  if(j == height.length - 1) {
                     int current = (heighestIndex - i - 1) * Math.min(height[heighestIndex], height[i]) ;
                     for (int k = i + 1; k < heighestIndex; k++) {
                        current -= (height[k] > height[heighestIndex] ? height[heighestIndex] : height[k]);
                     }

                     max += current;

                     i = j;
                  }
               } else {
                  int current = (heighestIndex - i - 1) * Math.min(height[heighestIndex], height[i]) ;
                  for (int k = i + 1; k < heighestIndex; k++) {
                     current -= (height[k] > height[heighestIndex] ? height[heighestIndex] : height[k]);
                  }

                  max += current;

                  i = j - 2;

                  break;
               }
            }
         }
      }

      return max;
   }

   public static void main(String[] args) {
      System.out.println(new Solution().trap(new int[]{1, 1}));
      System.out.println(new Solution().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
      System.out.println(new Solution().trap(new int[]{2,1,2}));

            System.out.println(new Solution().trap(new int[]{5,4,1,2}));



   }
}
