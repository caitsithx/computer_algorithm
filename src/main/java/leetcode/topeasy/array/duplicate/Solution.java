package leetcode.topeasy.array.duplicate;

import java.util.HashSet;
import java.util.Set;

class Solution {
   public boolean containsDuplicate(int[] nums) {
      Set<Integer> set = new HashSet<>();
      for (int val : nums) {
         if (set.contains(val)) {
            return true;
         } else {
            set.add(val);
         }
      }

      return false;
   }
}