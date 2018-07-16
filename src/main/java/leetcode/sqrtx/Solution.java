package leetcode.sqrtx;

public class Solution {
   public int mySqrt(int x) {
      if( x == 0 || x == 1) return x;

      long j = 1;
      for (;; j++) {
         long sqx = j * j;
         if(sqx > x) {
            break;
         }
      }

      return (int)j - 1;
   }

   public static void main(String[] args) {
//      System.out.println(new Solution().mySqrt(2));
//      System.out.println(new Solution().mySqrt(4));
//      System.out.println(new Solution().mySqrt(8));

      System.out.println(new Solution().mySqrt(2147395600));
   }
}
