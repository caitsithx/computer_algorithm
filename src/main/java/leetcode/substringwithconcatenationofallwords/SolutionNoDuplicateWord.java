package leetcode.substringwithconcatenationofallwords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/description/
 */
public class SolutionNoDuplicateWord {
   public List<Integer> findSubstring(String s, String[] words) {
      if (s == null || s.length() == 0 || words == null || words.length == 0 || s.length() < words[0].length()) {
         return new ArrayList<>(0);
      }

      Set<String> wordSet = Arrays.stream(words).collect(Collectors.toSet());

      List<Integer> result = new ArrayList<>();
      int i = 0;
      Map<String, Integer> current = new HashMap<>(words.length);
      int start = 0;
      while (i <= s.length() - words[0].length()) {
         String sub = s.substring(i, i + words[0].length());
         if (wordSet.contains(sub)) {
            if (current.containsKey(sub)) {
               int subIndexInWindow = current.get(sub);
               int shift = (subIndexInWindow) * words[0].length();
               for (int j = start; j < start + shift; j += words.length) {
                  current.remove(s.substring(j, j + words.length));
               }
               start += shift;
               start += words[0].length();
               i += words[0].length();
            } else {
               if (current.size() == words.length - 1) {
                  result.add(start);

                  //restart i to find next window
                  i = start + words[0].length();
                  start = 0;
                  current.clear();
               } else {
                  if (current.size() == 0) {
                     start = i;
                  }
                  current.put(sub, current.size());
                  i += words[0].length();
               }
            }
         } else {
            start = 0;
            if (current.size() > 0) {
               current.clear();
            }
            i++;
         }
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(new Solution().findSubstring("a1b2c3a1d4", new String[]{"a1", "b2", "c3", "d4"}));
      System.out.println(new Solution().findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
      System.out.println(new Solution().findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
      System.out.println(new Solution().findSubstring("barfoofoobar", new String[]{"bar", "foo"}));

      System.out.println(new SolutionNoDuplicateWord().findSubstring("abababab", new String[]{"a", "b", "a"}));
   }
}
