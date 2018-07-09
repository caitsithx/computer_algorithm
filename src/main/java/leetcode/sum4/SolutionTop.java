package leetcode.sum4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SolutionTop {
   public List<List<Integer>> fourSum(int[] nums, int target) {
      Arrays.sort(nums);
      List<List<Integer>> res = new ArrayList<>();

      for (int i = 0; i < nums.length - 3; i++) {
         if (i > 0 && nums[i] == nums[i - 1]) {
            continue;
         }

         if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
            break;
         }

         if (nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
            continue;
         }

         for (int j = i + 1; j < nums.length - 2; j++) {
            if (j > i + 1 && nums[j] == nums[j - 1]) {
               continue;
            }

            if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
               break;
            }

            int left = j + 1;
            int right = nums.length - 1;
            while (left < right) {
               int tmp = nums[i] + nums[j] + nums[left] + nums[right];
               if (tmp == target) {
                  res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                  right --;
                  left ++;
                  while (left < (nums.length - 1) && nums[left] == nums[left - 1]) {
                     left++;
                  }

                  while (right > (j + 1) && nums[right] == nums[right + 1]) {
                     right--;
                  }
               } else if(tmp > target) {
                  right --;
               } else {
                  left ++;
               }
            }
         }
      }


      return res;
   }

   public static void main(String[] args) {

      List<List<Integer>> result = new SolutionTop().fourSum(new int[]{0,1,5,0,1,5,5,-4}, 11);
      result.forEach(System.out::println);

      result = new SolutionTop().fourSum(new int[]{0,0,0,0}, 0);
      result.forEach(System.out::println);

      result = new SolutionTop().fourSum(new int[]{-1,-5,-5,-3,2,5,0,4}, -7);
      result.forEach(System.out::println);

      result = new SolutionTop().fourSum(new int[]{-1,0,-5,-2,-2,-4,0,1,-2}, -9);
      result.forEach(System.out::println);

   }
}
