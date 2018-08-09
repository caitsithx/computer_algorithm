package leetcode.topeasy.array.intersect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
   public int[] intersect(int[] nums1, int[] nums2) {
      List<Integer> result = new ArrayList<>(nums2.length);
      Map<Integer, Integer> set = new HashMap<>();
      for (int num1 :nums1) {
         if (set.containsKey(num1)) {
            set.put(num1, set.get(num1) + 1);
         } else {
            set.put(num1, 1);
         }
      }
      for (int num2:nums2) {
         if(set.containsKey(num2)) {
            int count = set.get(num2);
            count --;
            if(count > 0) {
               set.put(num2, count);
            } else{
               set.remove(num2);
            }
            result.add(num2);
         }
      }

      return result.stream().mapToInt(Integer::intValue).toArray();
   }

   public static void main(String[] args) {
      new Solution().intersect(new int[]{1}, new int[]{1, 1});
   }
}
