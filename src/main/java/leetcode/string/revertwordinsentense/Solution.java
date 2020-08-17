package leetcode.string.revertwordinsentense;

import static java.lang.System.out;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/description/
 * @author xiaoliangl
 */
public class Solution {
   public String reverseWords(String s) {
      String[] words = s.trim().split(" ");

      System.out.println(Arrays.toString(words));

      StringBuilder builder = new StringBuilder();
      for(int i = words.length - 1; i >= 0; i --) {
         if(words[i].trim().length() > 0) {
            builder.append(words[i]);
         } else {
            continue;
         }

         if(i > 0) {
            builder.append(' ');
         }
      }


      return builder.toString();
   }

   public static void main(String[] args) {
      out.println(new Solution().reverseWords( "the sky is  blue"));
   }
}
