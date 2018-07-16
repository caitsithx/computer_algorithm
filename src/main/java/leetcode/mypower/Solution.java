package leetcode.mypower;

public class Solution {
   public double myPow(double x, int n) {
      long nn = n;
      if(nn == 0) return 1;
      else if (nn < 0) {
         nn = -nn;
         x = 1 / x;
      }

      double sum = 1.0;

      while (nn != 1) {
         if((nn & 1) == 1) {
            sum *= x;
         }

         nn >>= 1;
         x *= x;
      }
      sum = sum * x;

      return sum;
   }

   public static void main(String[] args) {
      System.out.println(new Solution().myPow(2, 1));
      System.out.println(new Solution().myPow(2, 0));


      System.out.println(new Solution().myPow(2, 2));
      System.out.println(new Solution().myPow(2, 10));
      System.out.println(new Solution().myPow(2, 15));


      System.out.println(new Solution().myPow(2, -2));

   }
}
