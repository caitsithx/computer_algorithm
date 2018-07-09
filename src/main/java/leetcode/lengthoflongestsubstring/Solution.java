package leetcode.lengthoflongestsubstring;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

   public int lengthOfLongestSubstring(String s) {

      int max = 0;

      Set<Character> characters = new HashSet<>();
      char[] chars = s.toCharArray();

      for(int i = 0,j=0; i< chars.length; i ++) {
         while(characters.contains(chars[i])) {
            characters.remove(chars[j++]);
         }

         characters.add(chars[i]);
         max = max > characters.size() ? max : characters.size();

      }

      return max;
   }

   public static void main(String[] args) {
      out.println(new Solution().lengthOfLongestSubstring("dvdf"));
   }
}
