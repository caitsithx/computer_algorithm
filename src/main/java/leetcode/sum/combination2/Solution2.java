package leetcode.sum.combination2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/combination-sum/description/
 * @author xiaoliangl
 */
public class Solution2 {
   public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      if(candidates == null || candidates.length == 0) {
         return Collections.emptyList();
      }

      int[] sorted = Arrays.stream(candidates).sorted().toArray();

      Set<List<Integer>> results = new HashSet<>();
      List<Integer> tmpResult = new ArrayList<>();
      sum(sorted, target, results, tmpResult, 0);

      return new ArrayList<>(results);
   }

   private void sum(int[] sorted, int target, Set<List<Integer>> results, List<Integer> tmpResult, int start) {
      for (int i = start; i < sorted.length; i++) {
         int num = sorted[i];
         int remain = target - num;
         if (remain >= sorted[0]) {
            if(i + 1 < sorted.length) {
               tmpResult.add(num);
               sum(sorted, remain, results, tmpResult, i + 1);
               tmpResult.remove(tmpResult.size() - 1);
            }
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
      System.out.println(new Solution2().combinationSum2(new int[]{2,3,6,7}, 7));
      System.out.println(new Solution2().combinationSum2(new int[]{2,3,5}, 8));
      System.out.println(new Solution2().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));


   }
}
