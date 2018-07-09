package leetcode.medianof2sortedarray;

import static java.lang.System.out;

class Solution1 {

   public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int i = 0, j = 0;
      int medianIndex = ((nums1.length + nums2.length) / 2);
      boolean even = medianIndex * 2 == nums1.length + nums2.length;

      Integer[] medians = new Integer[2];
      for (int k = 0; k < medianIndex + 1; k++) {
         if(i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
               add(medians, nums1[i], even);
               i++;
            } else {
               add(medians, nums2[j], even);

               j++;
            }
         } else if(i < nums1.length){
            add(medians, nums1[i], even);

            i++;
         } else if(j < nums2.length){
            add(medians, nums2[j], even);

            j++;
         }
      }

      if(even) {
         return (medians[0] + medians[1]) /2.0f;
      } else {
         return  medians[0];
      }

   }

   private void add(Integer[] medians, int i, boolean even) {
      if(even) {
         if(medians[0] == null) {
            medians[0] = i;
         } else if(medians[1] == null) {
            medians[1] = i;
         } else {
            medians[0] = medians[1];
            medians[1] = i;
         }
      } else {
         medians[0] = i;
      }
   }

   public static void main(String[] args) {
      out.println(new Solution1().findMedianSortedArrays(
            new int[]{1, 3}, new int[]{2}
      ));
      out.println(new Solution1().findMedianSortedArrays(
            new int[]{1, 2}, new int[]{3}
      ));
      out.println(new Solution1().findMedianSortedArrays(
            new int[]{1, 3}, new int[]{2, 4}
      ));

      out.println(new Solution1().findMedianSortedArrays(
            new int[]{1, 2}, new int[]{1, 1}
      ));
   }
}
