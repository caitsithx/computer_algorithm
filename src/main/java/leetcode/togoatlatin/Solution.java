package leetcode.togoatlatin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

public class Solution {

   public String toGoatLatin(String s) {
      Set<Character> aeiou = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

      if(s == null || s.trim().length() == 0) {
         return "";
      }

      List<String> words =
      Arrays.stream(s.split(" ")).map(String::trim).filter(s1 -> s1.length() > 0).collect(Collectors.toList());

      StringBuilder builder = new StringBuilder();
      for(int i = 0; i < words.size(); i ++) {
         produce(words.get(i), i, aeiou, builder);
         if (i != words.size() - 1){
            builder.append(' ');
         }
      }

      return builder.toString();
   }

   private String produce(String s, int i, Set aeiou, StringBuilder builder) {
      char first = s.charAt(0);

      if(!aeiou.contains(first)) {
          builder.append(s.substring(1)).append(first);
      } else {
         builder.append(s);
      }

      builder.append("ma");
      IntStream.range(0, i + 1).forEach(idx -> builder.append('a'));

      return builder.toString();
   }


   @Test
   public void test1() {
      System.out.println(
      new Solution().toGoatLatin("I speak Goat Latin"));
   }

}
