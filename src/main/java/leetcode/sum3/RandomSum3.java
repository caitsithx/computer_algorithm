package leetcode.sum3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class RandomSum3 {

   public List<List<Integer>> threeSum(int[] nums, int sum) {
      final Map<Integer, Set<List<Integer>>> dict = new HashMap<>(nums.length);
      IntStream.range(0, nums.length).forEach(i -> IntStream.range(i, nums.length).forEach(j -> {
         int sum2 = nums[i] + nums[j];
         Set<List<Integer>> subResult = dict.computeIfAbsent(sum2, k -> new HashSet<>());
         List<Integer> tmp = new ArrayList<>();
         tmp.add(nums[i]);
         tmp.add(nums[j]);
         Collections.sort(tmp);
         subResult.add(tmp);
      }));

      Set<List<Integer>> results = new HashSet<>();
      Arrays.stream(nums).forEach(num -> {
         Set<List<Integer>> subResults = dict.get(sum - num);
         if(subResults != null) {
            subResults.forEach(subResult -> {
               subResult.add(num);
               Collections.sort(subResult);
               results.add(subResult);
            });
         }
      });

      return new ArrayList<>(results);
   }

   public List<List<Integer>> twoSum(int[] nums, int target) {
      //使用hash set和有序list来避免重复
      final Set<List<Integer>> result = new HashSet<>();

      final Map<Integer, Integer> dict = new HashMap<>(nums.length);
      Arrays.stream(nums).forEach(num -> {
         if (dict.containsKey(num)) {
            dict.put(num, dict.get(num) + 1);
         } else {
            dict.put(num, 1);
         }
      });

      Arrays.stream(nums).forEach(num -> {
         List<Integer> list = new ArrayList<>();
         int sub = target - num;
         if (dict.containsKey(sub)) {
            if (sub != num) {
               list.add(num);
               list.add(sub);
               Collections.sort(list);
               result.add(list);
            } else if (dict.get(sub) > 1) {
               list.add(num);
               list.add(sub);
               Collections.sort(list);
               result.add(list);
            }
         }
      });

      return new ArrayList<>(result);
   }

   public List<List<Integer>> twoSum1(int[] nums, int target) {
      final Set<List<Integer>> result = new HashSet<>();

      final Set<Integer> dict = new HashSet<>(nums.length);
      Arrays.stream(nums).forEach(num -> {
         int sub = target - num;

         if(dict.contains(sub)) {
            List<Integer> list = new ArrayList<>();
            list.add(num);
            list.add(sub);
            Collections.sort(list);
            result.add(list);
         }

         dict.add(num);
      });

      return new ArrayList<>(result);
   }

   public List<List<Integer>> threeSum1(int[] nums, int sum) {
      //剪枝1：已经处理过的，就不再处理
      Set<Integer> passed = new HashSet<>();

      //使用hash set和有序list来避免重复
      Set<List<Integer>> results = new HashSet<>();
      IntStream.range(0, nums.length).forEach(index -> {
         if(!passed.contains(nums[index])) {
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

   public List<List<Integer>> threeSum(int[] nums) {
      return threeSum1(nums, 0);
   }

   public static void main(String[] args) {

      List<List<Integer>> result = new RandomSum3().twoSum1(new int[]{-3, 4, 3, 90}, 0);
      result.forEach(System.out::println);

      result = new RandomSum3().twoSum1(new int[]{3, 4, 3, 90}, 6);
      result.forEach(System.out::println);


//      result = new RandomSum3().twoSum(new int[]{3, 4, 2, 90}, 6);
      result = new RandomSum3().threeSum(new int[]{1,2,-2,-1});
      result.forEach(System.out::println);

   }
}
