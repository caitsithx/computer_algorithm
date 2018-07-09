package leetcode.sum4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * https://leetcode-cn.com/problems/4sum/description/
 */
public class Solution {
   public List<List<Integer>> twoSum(int[] nums, int target) {
      final Set<List<Integer>> result = new HashSet<>();

      final Map<Integer, Integer> dict = new HashMap<>(nums.length);
      Arrays.stream(nums).forEach(num -> {
         if (!dict.containsKey(num)) {
            int sub = target - num;

            if (dict.containsKey(sub)) {
               List<Integer> list = new ArrayList<>();
               list.add(num);
               list.add(sub);
               Collections.sort(list);
               result.add(list);
            }

            dict.put(num, 1);
         } else {
            if (dict.get(num) == 1) {
               if (num == (target - num)) {
                  List<Integer> list = new ArrayList<>();
                  list.add(num);
                  list.add(num);
                  result.add(list);
               }
               dict.put(num, 2);
            }
         }
      });

      return new ArrayList<>(result);
   }


   public List<List<Integer>> threeSum(int[] nums, int sum) {
      //剪枝1：已经处理过的，就不再处理
      Set<Integer> passed = new HashSet<>();

      //使用hash set和有序list来避免重复
      Set<List<Integer>> results = new HashSet<>();
      IntStream.range(0, nums.length).forEach(index -> {
         if (!passed.contains(nums[index])) {
            passed.add(nums[index]);

            int sub = sum - nums[index];
            int[] subNums = new int[nums.length - 1 - index];
            //剪枝2：先前处理过的nums，就不计算twoSum了。
            System.arraycopy(nums, index + 1, subNums, 0, nums.length - index - 1);

            List<List<Integer>> subResults = twoSum(subNums, sub);
            subResults.forEach(subList -> {
               subList.add(nums[index]);
               Collections.sort(subList);
               results.add(subList);
            });
         }
      });

      return new ArrayList<>(results);
   }

   public List<List<Integer>> fourSum(int[] nums, int sum) {
      //剪枝1：已经处理过的，就不再处理
      Set<Integer> passed = new HashSet<>();

      //使用hash set和有序list来避免重复
      Set<List<Integer>> results = new HashSet<>();
      IntStream.range(0, nums.length).forEach(index -> {
         if (!passed.contains(nums[index])) {
            passed.add(nums[index]);

            int sub = sum - nums[index];
            int[] subNums = new int[nums.length - 1 - index];
            //剪枝2：先前处理过的nums，就不计算twoSum了。
            System.arraycopy(nums, index + 1, subNums, 0, nums.length - index - 1);

            List<List<Integer>> subResults = threeSum(subNums, sub);
            subResults.forEach(subList -> {
               subList.add(nums[index]);
               Collections.sort(subList);
               results.add(subList);
            });
         }
      });

      return new ArrayList<>(results);
   }


   public static void main(String[] args) {

      List<List<Integer>> result = new Solution().twoSum(new int[]{-3, 4, 3, 90}, 0);
      result.forEach(System.out::println);


      result = new Solution().twoSum(new int[]{3, 4, 3, 90}, 6);
      result.forEach(System.out::println);


      result = new Solution().twoSum(new int[]{3, 4, 2, 90}, 6);
      result.forEach(System.out::println);
   }
}
