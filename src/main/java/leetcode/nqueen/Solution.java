package leetcode.nqueen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {


   public List<List<String>> solveNQueens(int n) {
      Set<List<String>> existing = new HashSet<>();
      int[][] availables = new int[n][n];

      List<String> current = new ArrayList<>(n);
      solve(existing, current,0, n, availables);

      return new ArrayList<>(existing);
   }

   private void solve(Set<List<String>> results, List<String> current, int lineIndex, int n, int[][] availables) {

      if(lineIndex == n) {
         results.add(new ArrayList<>(current));
         return;
      }

      //在当前行依次找个空位
      for (int i = 0; i < n; i++) {
         if (availables[lineIndex][i] == 0) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n; j++) {
               if (j != i) {
                  builder.append(".");
               } else {
                  builder.append("Q");
               }
            }

            current.add(builder.toString());


            for (int j = lineIndex + 1; j < n; j++) {
               int k1 = i + j - lineIndex;
               int k2 = i - (j - lineIndex);
               availables[j][i] --;
               if (k1 < n) {
                  availables[j][k1] --;
               }

               if (k2 > -1) {
                  availables[j][k2] --;
               }
            }

            solve(results, current, lineIndex + 1, n, availables);
            current.remove(builder.toString());

            for (int j = lineIndex + 1; j < n; j++) {
               int k1 = i + j - lineIndex;
               int k2 = i - (j - lineIndex);
               availables[j][i] ++;
               if (k1 < n) {
                  availables[j][k1] ++;
               }

               if (k2 > -1) {
                  availables[j][k2] ++;
               }
            }
         }
      }
   }


   public static void main(String[] args) {
//      print(new Solution().solveNQueens(2));
//      print(new Solution().solveNQueens(3));
//      print(new Solution().solveNQueens(4));
      print(new Solution().solveNQueens(5));



   }

   private static void print(List<List<String>> ints) {
      ints.forEach(Solution::print1);
   }
   private static void print1(List<String> ints) {
      System.out.println();
      ints.forEach(System.out::println);
   }

}
