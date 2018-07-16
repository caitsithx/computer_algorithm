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
public class Solution1 {
   public void rec(List<List<Integer>>res,int target, int[] candidates,List tlist,int start){
      if(target==0){
         List alist = new ArrayList<Integer>(tlist);
         res.add(alist);return;
      }
      if(target<0){
         return;
      }
      //
      for(int i=start;i<candidates.length;i++){
         tlist.add(candidates[i]);
         rec(res,target-candidates[i],candidates,tlist,i);
         tlist.remove(tlist.size()-1);
      }

   }


   public List<List<Integer>> combinationSum(int[] candidates, int target) {
      List<List<Integer>>res = new ArrayList<List<Integer>>();

      List<Integer>tlist = new ArrayList<Integer>();
      rec(res,target,candidates,tlist,0);
      return res;
   }

   public static void main(String[] args) {
      System.out.println(new Solution1().combinationSum(new int[]{2,3,6,7}, 7));
      System.out.println(new Solution1().combinationSum(new int[]{2,3,5}, 8));

   }
}
