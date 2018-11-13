package leetcode.topeasy.sortandsearch.mergesorted;

class Solution {
   public void merge(int[] nums1, int m, int[] nums2, int n) {
      if(m == 0) {
         System.arraycopy(nums2, 0, nums1, 0, nums2.length);
         return;
      }

      if(n == 0) {
         return;
      }

      int index = n + m - 1;
      for (int i = m - 1, j = n - 1; i >= 0 && j >= 0; ) {
         if (nums1[i] <= nums2[j]) {
            nums1[index] = nums2[j];
            j --;
         } else {
            nums1[index] = nums1[i];

            if(i == 0) {
               System.arraycopy(nums2, 0, nums1, 0, j + 1);
            } else {
               nums1[i] = 0;
            }
            i --;
         }
         index--;
      }
   }
}
