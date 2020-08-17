package leetcode.string.longestcommonprefix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 */
public class Solution {
   public String longestCommonPrefix(String[] strs) {
      if(strs.length == 0) {
         return "";
      }

      List<String> sorted = Arrays.stream(strs).sorted(Comparator.comparingInt(String::length))
            .collect(Collectors.toList());

      String shorted = sorted.get(0);

      for(String str : sorted) {
         shorted = diff(shorted, str);

         if(shorted.length() == 0) {
            break;
         }
      }

      return shorted;
   }

   private String diff(String shorted, String str) {
      for(int i = 0; i < shorted.length(); i ++) {
         if (shorted.charAt(i) != str.charAt(i)) {
            if(i == 0) return "";
            else return shorted.substring(0, i);
         }
      }

      return shorted;
   }

   public static void main(String[] args) {
      System.out.println(new Solution().longestCommonPrefix(new String[]{"flower","flow","flight"}));
      System.out.println(Byte.valueOf((byte)'b').intValue());

   }
}
