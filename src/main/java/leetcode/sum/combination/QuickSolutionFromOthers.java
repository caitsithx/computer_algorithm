package leetcode.sum.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSolutionFromOthers {
   public List<List<Integer>> combinationSum(int[] candidates, int target) {
      List<List<Integer>> aList = new ArrayList<>();
      Arrays.sort(candidates);
      List<Integer> bList = new ArrayList<>();
      dfs(aList, bList, candidates, target, 0, 0);
      return aList;
   }

   public void dfs(List<List<Integer>> aList, List<Integer> bList, int[] candidates, int target, int end, int index) {

      if (index >= candidates.length || target - end < candidates[index]) {

      } else if (target - end > candidates[index]) {


         bList.add(candidates[index]);
         end += candidates[index];
         dfs(aList, bList, candidates, target, end, index);

         bList.remove(bList.size() - 1);
         end -= candidates[index];


         index++;
         dfs(aList, bList, candidates, target, end, index);
         index--;


			/*bList.add(candidates[index]);
			end+=candidates[index];
			index++;
			dfs(aList, bList, candidates, target, end, index);
			index--;
			bList.remove(bList.size()-1);
			end-=candidates[index];*/


      } else {
         List<Integer> ss = new ArrayList<>();
         for (int i = 0; i < bList.size(); i++) {
            ss.add(bList.get(i));
         }
         ss.add(candidates[index]);
         aList.add(ss);
      }
   }
}
