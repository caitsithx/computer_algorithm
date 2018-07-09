package leetcode.medianof2sortedarray;

import static java.lang.System.out;

class Solution2NotFInished {

   public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      if (nums1.length == 1 && nums2.length == 1) {
         return (nums1[0] + nums2[0]) / 2;
      } else if (nums1.length == 1) {
         int n = nums2.length / 2;
         boolean even2 = n * 2 == nums2.length;
         double median2 = getMedian(nums2, n, even2);

         if (nums1[0] == median2) {
            return median2;
         } else if(nums1[0] > median2) {
            int[] nums21 = new int[nums2.length - 1];
            System.arraycopy(nums2, 1, nums21, 0, nums21.length);
            int m21 = nums21.length / 2;
            boolean even21 = m21 * 2 == nums21.length;
            return getMedian(nums21, m21, even21);
         } else {
            int[] nums21 = new int[nums2.length - 1];
            System.arraycopy(nums2, 0, nums21, 0, nums21.length);
            int m21 = nums21.length / 2;
            boolean even21 = m21 * 2 == nums21.length;
            return getMedian(nums21, m21, even21);
         }
      } else if(nums2.length == 1) {
         int m = nums1.length / 2;
         boolean even1 = m * 2 == nums1.length;
         double median2 = getMedian(nums2, m, even1);
      }

      int m = nums1.length / 2;
      int n = nums2.length / 2;

      boolean even1 = m * 2 == nums1.length;
      boolean even2 = n * 2 == nums2.length;
      double median1 = getMedian(nums1, m, even1);
      double median2 = getMedian(nums2, n, even2);

      if (median1 == median2) {
         return median1;
      } else if (median1 < median2) {
         int len = m > n ? n : m;
         int[] nums11 = new int[nums1.length - len];
         System.arraycopy(nums1, 0, nums11, 0, nums11.length);
         int[] nums21 = new int[nums2.length - len];
         System.arraycopy(nums2, len, nums21, 0, nums11.length);

         return findMedianSortedArrays(nums11, nums21);
      }

      return -1;
   }

   private double getMedian(int[] nums1, int m, boolean even1) {
      if (even1) {
         return (nums1[m] + nums1[m + 1]) / 2;
      } else {
         return nums1[m];
      }
   }


   public static void main(String[] args) {
      out.println(new Solution2NotFInished().findMedianSortedArrays(
            new int[]{1, 3}, new int[]{2}
      ));
      out.println(new Solution2NotFInished().findMedianSortedArrays(
            new int[]{1, 2}, new int[]{3}
      ));
      out.println(new Solution2NotFInished().findMedianSortedArrays(
            new int[]{1, 3}, new int[]{2, 4}
      ));

      out.println(new Solution2NotFInished().findMedianSortedArrays(
            new int[]{1, 2}, new int[]{1, 1}
      ));
   }
}
