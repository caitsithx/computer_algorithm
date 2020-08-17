package leetcode.string.substringwithconcatenationofallwords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
   public List<Integer> findSubstring(String s, String[] words) {
      if (s == null || s.length() == 0 || words == null || words.length == 0 || s.length() < words[0].length()) {
         return new ArrayList<>(0);
      }

      Map<String, Integer> wordSet = new HashMap<>(words.length);
      for (int i = 0; i < words.length; i++) {
         if (wordSet.containsKey(words[i])) {
            wordSet.put(words[i], wordSet.get(words[i]) + 1);
         } else {
            wordSet.put(words[i], 1);
         }
      }

      List<Integer> result = new ArrayList<>();

      for (int k = 0; k < words[0].length(); k++) {
         Map<String, Integer> window = new HashMap<>(words.length);
         int allCount = 0;
         int start = 0;
         int i = k;
         while (i <= s.length() - words[0].length()) {
            String sub = s.substring(i, i + words[0].length());
            if (wordSet.containsKey(sub)) {
               if (window.containsKey(sub)) {
                  if (window.get(sub).equals(wordSet.get(sub))) {
                     for (int j = start; j < i; j += words[0].length()) {
                        String toBeRemoved = s.substring(j, j + words[0].length());
                        int toBeRemovedCount = window.get(toBeRemoved);
                        if (toBeRemovedCount > 1) {
                           window.put(toBeRemoved, toBeRemovedCount - 1);
                        } else {
                           window.remove(toBeRemoved);
                        }
                        allCount--;
                        start += words[0].length();

                        if (toBeRemoved.equals(sub)) {
                           break;
                        }
                     }
                  }

                  if (window.containsKey(sub)) {
                     window.put(sub, window.get(sub) + 1);
                  } else {
                     window.put(sub, 1);
                  }
               } else {
                  if (allCount == 0) {
                     start = i;
                  }

                  window.put(sub, 1);
               }
               i += words[0].length();
               allCount++;


               if (allCount == words.length) {
                  result.add(start);

                  //restart i to find next window
                  i = start + words[0].length();
                  start = i;
                  window.clear();
                  allCount = 0;
               }
            } else {
               i += words[0].length();
               if (window.size() > 0) {
                  window.clear();
                  allCount = 0;
                  start = i;
               }
            }
         }
      }

      return result;
   }


   public static void main(String[] args) {
      System.out.println(new Solution().findSubstring("a1b2c3a1d4", new String[]{"a1", "b2", "c3", "d4"}));
      System.out.println(new Solution().findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
      System.out.println(new Solution().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
      System.out.println(new Solution().findSubstring("barfoofoobar", new String[]{"bar", "foo"}));
      System.out.println(new Solution().findSubstring("abababab", new String[]{"a", "b", "a"}));
      System.out.println(new Solution().findSubstring("abaababbaba", new String[]{"ba", "ab", "ab"}));
      System.out.println(new Solution().findSubstring("aaaaaaaa", new String[]{"aa", "aa", "aa"}));


      System.out.println(new Solution().findSubstring("ababaab", new String[]{"ab", "ba", "ba"}));
   }
}
