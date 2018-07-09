package leetcode.maxArea;

public class Solution2 {

   public int maxArea(int[] height) {
      if(height == null || height.length < 2){
         return 0;
      }
      int max = 0;
      int left = 0;
      int right = height.length - 1;
      do {
         int current = (right - left) * Math.min(height[left], height[right]);

         if(max < current) {
            max = current;
         }

         if(height[left] <= height[right]) {
            left ++;
         } else {
            right --;
         }

      } while(left != right);

      return max;
   }

   public static void main(String[] args) {
      System.out.print(new Solution2().maxArea(new int[]{1, 1}));
   }

}
