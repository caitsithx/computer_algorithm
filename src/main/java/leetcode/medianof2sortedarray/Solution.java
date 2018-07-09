package leetcode.medianof2sortedarray;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

class Solution {

   public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      List<Integer> combined = new ArrayList<>();
      int i = 0, j = 0;

      while (i < nums1.length && j < nums2.length) {

         if (nums1[i] < nums2[j]) {
            combined.add(nums1[i]);
            i++;
         } else {
            combined.add(nums2[j]);
            j++;
         }
      }

      while (i < nums1.length) {
         combined.add(nums1[i]);
         i++;
      }

      while (j < nums2.length) {
         combined.add(nums2[j]);
         j++;
      }


      int half = combined.size() / 2;
      if (half * 2 == combined.size()) {
         return (combined.get(half - 1) + combined.get(half)) / 2.0f;
      } else {
         return combined.get(half);
      }
   }

   public static void main(String[] args) {
      out.println(new Solution().findMedianSortedArrays(
            new int[]{1, 3}, new int[]{2}
      ));
      out.println(new Solution().findMedianSortedArrays(
            new int[]{1, 2}, new int[]{3}
      ));
      out.println(new Solution().findMedianSortedArrays(
            new int[]{1, 3}, new int[]{2, 4}
      ));

      out.println(new Solution().findMedianSortedArrays(
            new int[]{1, 2}, new int[]{1, 1}
      ));
   }
}
