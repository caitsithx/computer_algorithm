package leetcode.topeasy.sortandsearch.firstbadversion;

public class Solution extends VersionControl {
   public int firstBadVersion(int n) {
      return firstBadVersion(0, n);
   }

   private int firstBadVersion(int i, int n) {
      while(i != n - 1) {
         int mid = i + (i - n) / 2;
         if(isBadVersion(mid) ){
            n = mid;
         } else {
            i = mid;
         }
      }
      return n;

   }
}

class VersionControl {
   boolean isBadVersion(int version) {
      return true;
   }
}
