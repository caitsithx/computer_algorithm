package leetcode.sum.combination;

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
public class Solution {
   public List<List<Integer>> combinationSum(int[] candidates, int target) {
      if(candidates == null || candidates.length == 0) {
         return Collections.emptyList();
      }

      int[] sorted = Arrays.stream(candidates).sorted().toArray();

      return new ArrayList<>(sum(sorted, target));
   }

   private Set<List<Integer>> sum(int[] sorted, int target) {
      Set<List<Integer>> results = new HashSet<>();


      for (int num : sorted) {
         int remain = target - num;
         if (remain >= sorted[0]) {
            Set<List<Integer>> subResults = sum(sorted, remain);
            for (List<Integer> subResult : subResults) {
               List<Integer> tmp = new ArrayList<>();
               tmp.add(num);
               tmp.addAll(subResult);
               Collections.sort(tmp);
               results.add(tmp);
            }
         } else if(remain == 0) {
            System.out.println(num);
            results.add(Collections.singletonList(num));
            break;
         } else if(remain < 0){
            break;
         }
      }
      return results;
   }

   public static void main(String[] args) {
      System.out.println(new Solution().combinationSum(new int[]{2,3,6,7}, 7));
      System.out.println(new Solution().combinationSum(new int[]{2,3,5}, 8));

   }
}
