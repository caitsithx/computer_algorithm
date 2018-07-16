package leetcode.sum.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/description/
 * @author xiaoliangl
 */
public class Solution2 {
   public List<List<Integer>> combinationSum(int[] candidates, int target) {
      if(candidates == null || candidates.length == 0) {
         return Collections.emptyList();
      }

      int[] sorted = Arrays.stream(candidates).sorted().toArray();

      List<List<Integer>> results = new ArrayList<>();
      List<Integer> tmpResult = new ArrayList<>();
      sum(sorted, target, results, tmpResult, 0);

      return results;
   }

   private void sum(int[] sorted, int target, List<List<Integer>> results, List<Integer> tmpResult, int start) {
      for (int i = start; i < sorted.length; i++) {
         int num = sorted[i];
         int remain = target - num;
         if (remain >= sorted[0]) {
            tmpResult.add(num);
            sum(sorted, remain, results, tmpResult, i);
            tmpResult.remove(tmpResult.size() - 1);
         } else if(remain == 0) {
            tmpResult.add(num);
            results.add(new ArrayList<>(tmpResult));
            tmpResult.remove(tmpResult.size() - 1);
            break;
         } else if(remain < 0){
            break;
         }
      }
   }

   public static void main(String[] args) {
      System.out.println(new Solution2().combinationSum(new int[]{2,3,6,7}, 7));
      System.out.println(new Solution2().combinationSum(new int[]{2,3,5}, 8));

   }
}
