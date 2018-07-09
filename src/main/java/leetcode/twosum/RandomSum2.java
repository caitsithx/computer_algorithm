package leetcode.twosum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/description/
 */
public class RandomSum2 {

   public int[] twoSum(int[] nums, int target) {
      Map<Integer, List<Integer>> dict = new HashMap<>(nums.length);
      for (int i = 0; i < nums.length; i++) {
         List<Integer> indexes = dict.computeIfAbsent(nums[i], k -> new ArrayList<>());

         indexes.add(i);
      }
      int[] result = new int[] {-1, -1};
      for(int i = 0; i < nums.length; i++) {
         int sub = target - nums[i];
         List<Integer> indexes = dict.get(sub);
         if(indexes != null) {
            if(sub == nums[i]) {
               if(indexes.size() > 1) {
                  result[0] = i;
                  result[1] = indexes.get(1);
                  break;
               }
            } else {
               result[0] = i;
               result[1] = indexes.get(0);
               break;
            }
         }
      }

      return result;
   }

   public int[] twoSum1(int[] nums, int target) {
      int[] result = new int[] {-1, -1};

      Map<Integer, Integer> dict = new HashMap<>(nums.length);
      for (int i = 0; i < nums.length; i++) {
         int sub = target - nums[i];
         if(dict.containsKey(sub)) {
            result[0] = dict.get(sub);
            result[1] = i;
            break;
         }

         dict.put(nums[i], i);
      }


      return result;
   }

   public static void main(String[] args) {

      int[] result = new RandomSum2().twoSum(new int[]{-3, 4, 3, 90}, 0);
      System.out.println(result[0]);
      System.out.println(result[1]);

      result = new RandomSum2().twoSum(new int[]{3, 4, 3, 90}, 6);
      System.out.println(result[0]);
      System.out.println(result[1]);

      result = new RandomSum2().twoSum(new int[]{3, 4, 2, 90}, 6);
      System.out.println(result[0]);
      System.out.println(result[1]);
   }
}
