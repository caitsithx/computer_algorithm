package leetcode.topeasy.array.intersect.order;

import java.util.ArrayList;
import java.util.List;

public class Solution {
   public int[] intersect(int[] nums1, int[] nums2) {

      List<Integer> result = new ArrayList<>();
      int i = 0;
      int j = 0;
      while (i < nums1.length && j < nums2.length) {
         if (nums1[i] == nums2[j]) {
            i++;
            j++;
            result.add(nums1[i]);
         } else if (nums1[i] < nums2[j]) {
            i++;
         } else {
            j++;
         }
      }

      return result.stream().mapToInt(Integer::intValue).toArray();
   }


   public static void main(String[] args) {
      new Solution().intersect(new int[]{1}, new int[]{1, 1});
   }
}
