package leetcode.foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * https://leetcode-cn.com/problems/4sum/description/
 */
public class RandomSum4 {
   private Set<List<Integer>> results = new HashSet<>();

   public List<List<Integer>> fourSum(int[] nums, int target) {
      Arrays.sort(nums);


      IntStream.range(0, nums.length).forEach(i ->
      {
         final List<Integer> list = new ArrayList<>();
         final int sum = nums[i];
         list.add(nums[i]);
         IntStream.range(i + 1, nums.length).forEach(j -> {
            final int sum2 = sum + nums[j];
            final List<Integer> list2 = new ArrayList<>(list);
            list2.add(nums[j]);
            IntStream.range(j + 1, nums.length).forEach(k -> {
               final int sum3 = sum2 + nums[k];
               final List<Integer> list3 = new ArrayList<>(list2);
               list3.add(nums[k]);
               IntStream.range(k + 1, nums.length).forEach(l -> {
                  final int sum4 = sum3 + nums[l];
                  final List<Integer> list4 = new ArrayList<>(list3);
                  if (sum4 == target) {
                     list4.add(nums[l]);
                     Collections.sort(list4);
                     results.add(list4);
                  }
               });
            });
         });
      });

      return new ArrayList<>(results);
   }


   public static void main(String[] args) {
//      List<List<Integer>> result = new RandomSum4().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
      List<List<Integer>> result = new RandomSum4().fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11);

      result.forEach(System.out::println);
   }
}
