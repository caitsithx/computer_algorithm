package leetcode.maxArea;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
   class Line {
      int height;
      int index;

      public Line(int i, int height) {
         this.index = i;
         this.height = height;
      }
   }

   public int maxArea(int[] height) {
      if(height == null || height.length < 2){
         return 0;
      }
      int max = 0;

      List<Line> sorted = new ArrayList<>(height.length);
      for (int i = 0; i < height.length; i++) {
         sorted.add(new Line(i, height[i]));
      }

      sorted.sort(Comparator.comparingInt(o -> o.height));

//      int[] capacities = new int[height.length - 1];

      int start = sorted.get(height.length - 1).index;
      int end = start;
      for (int i = height.length - 2; i >= 0; i --) {
         Line current = sorted.get(i);

         int width1 = Math.abs(current.index - start);
         int width2 = Math.abs(current.index - end);

         int currentMax = Math.max(width1, width2) * current.height;
         if(currentMax > max) {
            max = currentMax;
         }

         if(current.index > end) {
            end = current.index;
         } else if(current.index < start) {
            start = current.index;
         }
      }

      return max;
   }

   public static void main(String[] args) {
      System.out.print(new Solution().maxArea(new int[]{1, 1}));
   }

}
