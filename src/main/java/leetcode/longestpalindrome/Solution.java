package leetcode.longestpalindrome;

public class Solution {
   public String longestPalindrome(String s) {
      if(s == null || s.length() == 0) {
         return "";
      } else if(s.length() == 1) {
         return s;
      }

      boolean[][] flags = new boolean[s.length()][s.length()];
      for (int i = 0; i < s.length(); i++) {
         flags[i][i] = true;
      }

      for (int i = 0; i < s.length() - 1; i++) {
         flags[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
      }

      String max = s.substring(0, 1);
      for (int len = 1; len <= s.length(); len++) {
         for (int i = 0; i < s.length() - len + 1; i++) {
            if (len == 1) {
               flags[i][i] = true;
            } else if (len == 2) {
               if (s.charAt(i) == s.charAt(i + 1)) {
                  flags[i][i + 1] = true;

                  if (len > max.length()) {
                     max = s.substring(i, i+len);
                  }
               }
            } else {
               if (s.charAt(i) == s.charAt(i + len - 1) && flags[i + 1][i + len - 2]) {
                  flags[i][i + len - 1] = true;


                  if (len > max.length()) {
                     max = s.substring(i, i+len);
                  }
               }
            }
         }
      }

      return max;
   }

   public static void main(String[] argd) {
      System.out.println(new Solution().longestPalindrome("bb"));

      System.out.println(new Solution().longestPalindrome("babad"));
      System.out.println(new Solution().longestPalindrome("cbbd"));

   }

}
