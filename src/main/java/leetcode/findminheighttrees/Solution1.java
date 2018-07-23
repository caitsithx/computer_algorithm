package leetcode.findminheighttrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution1 {

   public List<Integer> findMinHeightTrees(int n, int[][] edges) {
      if (n == 1) return Collections.singletonList(0);

      List<Set<Integer>> nodesByStart = new ArrayList<>(n);
      for (int i = 0; i < n; i++) {
         nodesByStart.add(new HashSet<>());
      }
      for (int[] edge : edges) {
         nodesByStart.get(edge[0]).add(edge[1]);
         nodesByStart.get(edge[1]).add(edge[0]);
      }

      List<Integer> leaves = new ArrayList<>();
      for (int i = 0; i < n; i++) {
         if(nodesByStart.get(i).size() == 1) {
            leaves.add(i);
         }
      }

      while (n > 2) {
         n -= leaves.size();
         List<Integer> leaves1 = new ArrayList<>();

         for(Integer leave : leaves) {
            for (Integer node : nodesByStart.get(leave)) {
               nodesByStart.get(node).remove(leave);
               if(nodesByStart.get(node).size() == 1) {
                  leaves1.add(node);
               }
            }
         }

         leaves = leaves1;
      }

      return leaves;

   }


   public static void main(String[] args) {
      int[][] edges = new int[][]{{1, 0}, {1, 2}, {1, 3}};
      System.out.println(new Solution1().findMinHeightTrees(4, edges));
   }
}
