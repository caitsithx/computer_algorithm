package leetcode.topeasy.array.rotate;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class Solution1 {
   public void rotate(int[] nums, int k) {
      if(k == 0) return;
      if(k == nums.length) return;

      int index = 0;
      int oldIndex = index;
      int count = 0;
      while (count < nums.length - 1){
         int newIndex = (index + k) % nums.length;
         if(newIndex == oldIndex) {
            oldIndex ++;
            index = oldIndex;
            count++;
         } else {
            int tmp = nums[newIndex];
            nums[newIndex] = nums[oldIndex];
            index = newIndex;
            nums[oldIndex] = tmp;
            count++;
         }
      }
   }

   @Test
   public void test() {
      int[] array = new int[]{1,2,3,4,5,6};
      new Solution1().rotate(array, 2);
      System.out.println(Arrays.toString(array));
   }

}
