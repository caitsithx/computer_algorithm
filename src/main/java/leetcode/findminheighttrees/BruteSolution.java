package leetcode.findminheighttrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class BruteSolution {
   private Map<Integer, List<Integer>> edgesByStart;
   private int[] heights;
   private int smallest = Integer.MAX_VALUE;
   private List<Integer> results = new ArrayList<>();

   public List<Integer> findMinHeightTrees(int n, int[][] edges) {
      heights = new int[n];
      Arrays.fill(heights, -1);
      edgesByStart = new HashMap<>(edges.length);
      for (int[] edge : edges) {
         edgesByStart.computeIfAbsent(edge[0], integer -> new ArrayList<>()).add(edge[1]);
         edgesByStart.computeIfAbsent(edge[1], integer -> new ArrayList<>()).add(edge[0]);
      }

      IntStream.range(0, n).forEach(i -> {
         heights[i] = calculate(i, i);
         if(smallest > heights[i]) {
            results.clear();
            smallest = heights[i];
         }

         if(smallest == heights[i]) {
            results.add(i);
         }
      });


      return results;
   }

   private int calculate(int i, int noReverse) {
      List<Integer> ends = edgesByStart.get(i);
      if (ends == null || ends.size() == 0) {
         return 1;
      } else {
         int height = 1;
         for (int end : ends) {
            if (end == noReverse) {
               continue;
            }

            int sub = calculate(end, i);
            if (height < sub + 1) {
               height = sub + 1;
            }
         }

         return height;
      }
   }
}
