package leetcode.trap;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/description/
 *
 * @author xiaoliangl
 */
public class Solution1 {

   public int trap(int[] height) {
      if (height == null || height.length < 2) {
         return 0;
      }
      int max = 0;

      int left = 0;
      int right = height.length - 1;
      while (height[left] <= height[left + 1]) {
         left++;

         if (left == height.length - 1) {
            return 0;
         }
      }
      while (height[right - 1] >= height[right]) {
//         if(right == left) {
//            return 0;
//         }

         right--;

         if (right == 0 || right == left) {
            return 0;
         }
      }

      while (left < (right - 1)) {
         boolean done = false;
         if (height[left] > height[right]) {
            for (int i = right - 1; i > left; i--) {
               if (height[i] >= height[right]) {
                  max += calculate(height, i, right);
                  right = i;
                  break;
               }

               if(i == left + 1) {
                  done = true;
               }
            }
         } else {
            for (int i = left + 1; i < right; i++) {
               if (height[i] >= height[left]) {
                  max += calculate(height, left, i);
                  left = i;
                  break;
               }


               if(i == right - 1) {
                  done = true;
               }
            }
         }

         if(done) {
            break;
         }
      }

      max += calculate(height, left, right);


      return max;
   }

   private int calculate(int[] height, int left, int right) {
      int lowest = Math.min(height[left], height[right]);

      int result = lowest * (right - left - 1);
      for (int i = left + 1; i < right; i++) {
         result -= (height[i] > lowest ? lowest : height[i]);
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(new Solution1().trap(new int[]{1, 1}));
      System.out.println(new Solution1().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
      System.out.println(new Solution1().trap(new int[]{2, 1, 2}));
      System.out.println(new Solution1().trap(new int[]{5, 4, 1, 2}));
      System.out.println(new Solution1().trap(new int[]{5, 2, 1, 2, 1, 5}));
      System.out.println(new Solution1().trap(new int[]{9, 1, 0}));
      System.out.println(new Solution1().trap(new int[]{0, 2, 0}));
      System.out.println(new Solution1().trap(new int[]{4,3,3,9,3,0,9,2,8,3}));
      System.out.println(new Solution1().trap(new int[]{9, 6, 8, 8, 5, 6, 3}));
   }
}
