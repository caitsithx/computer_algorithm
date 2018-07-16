package leetcode.sum.sum4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode-cn.com/problems/4sum/description/
 * @author xiaoliangl
 */
public class SolutionParallel {
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

//      result.forEach(System.out::println);

      return new ArrayList<>(result);
   }


   public List<List<Integer>> fourSum(int[] nums, int sum) {
      return new Summer(nums, sum, 4).sum();
   }

   class Result {
      List<List<Integer>> result;
      boolean isDone = false;

      public synchronized List<List<Integer>> getResult() {
         return result;
      }

      public synchronized void setResult(List<List<Integer>> result) {
         setDone(true);
         this.result = result;
      }

      public synchronized boolean isDone() {
         return isDone;
      }

      public synchronized void setDone(boolean done) {
         isDone = done;
      }
   }


   class Summer {
      private int[] nums;
      private int sum;
      private int count;

      public Summer(int[] nums, int sum, int count) {
         this.nums = nums;
         Arrays.sort(this.nums);
         this.sum = sum;
         this.count = count;
      }

      /**
       * 剪枝1：已经处理过的，就不再处理
       */
      private final Map<Integer, Result> passed = new HashMap<>();

      public boolean lockIt(int num) {
//         System.out.println("lockIt: " + num);
         synchronized (passed) {
            if (passed.containsKey(num)) {
               return true;
            }

//            System.out.println("go lockIt: " + num);


            passed.put(num, new Result());
            return true;
         }
      }

      public List<List<Integer>> sum() {

         //使用hash set和有序list来避免重复

         return IntStream.range(0, nums.length).parallel().mapToObj(index -> {

            int remain = nums.length - index - 1;
            int nextCount = count - 1;

//            System.out.println("num: " + Arrays.toString(nums) + " sum: " + sum + " remain: " + remain
//                  + " nextCount: " + nextCount + " index: " + index + " numLock: " + nums[index]);

            if (remain >= nextCount) {
               if (lockIt(nums[index])) {
//                  System.out.println("numLock: " + nums[index]);

                  int sub = sum - nums[index];

                  int[] subNums = new int[nums.length - 1 - index];
                  //剪枝2：先前处理过的nums，就不计算twoSum了。
                  System.arraycopy(nums, index + 1, subNums, 0, nums.length - index - 1);

                  List<List<Integer>> subResults = new ArrayList<>();
                  if (count > 3) {
//                     System.out.println("p: " + count + "nums: " + Arrays.toString(subNums));
                     subResults = new Summer(subNums, sub, count - 1).sum();
                  } else if (count == 3) {
//                     System.out.println("p: " + count + " nums: " + Arrays.toString(subNums));
                     subResults = twoSum(subNums, sub);
                  } else {
                     throw new IllegalArgumentException();
                  }

                  subResults.forEach(subList -> {
                     subList.add(nums[index]);
                     Collections.sort(subList);
                  });

                  passed.get(nums[index]).setResult(subResults);

                  return subResults;
               } else {
                  while (true) {
                     try {
                        Thread.sleep(30);
                     } catch (InterruptedException e) {
                        //
                     }

                     if (passed.get(nums[index]).isDone) {
                        return passed.get(nums[index]).getResult();
                     }
                  }
               }
            }

            return null;
         }).filter(Objects::nonNull)
               .flatMap(List::stream)
               .distinct().collect(Collectors.toList());
      }
   }


   public static void main(String[] args) {

      List<List<Integer>> result = new SolutionParallel().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
      result.forEach(System.out::println);
   }
}
