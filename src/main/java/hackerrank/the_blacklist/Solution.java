package hackerrank.the_blacklist;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by xiaoliangl on 4/29/16.
 */
public class Solution {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int gNum = scanner.nextInt();
      int mNum = scanner.nextInt();

      int[][] costs = new int[mNum][gNum];
      for(int i = 0; i < mNum; i ++) {
         scanner.nextLine();
         for(int j = 0; j < gNum; j ++) {
            costs[i][j] = scanner.nextInt();
         }
      }

      System.out.println(kill(costs));
   }

   private static HashMap<Integer, Integer> history = new HashMap<>();

   public static  int kill(int[][] costs) {
      int code = 0;
      for(int[] cost : costs) {
         for (int val : cost) {
            code = 31 * code + val;
         }

      }

      if(history.containsKey(code)) {
//         System.out.println("bingo");
         return history.get(code);
      }

      int small = -1;

      int[] sums = new int[costs.length];

      //just one m, kill all
      if(costs[0].length == 1) {
         for(int i = 0; i < costs.length; i ++) {
            sums[i] = costs[i][0];
         }

         Arrays.sort(sums);
         small = sums[0];
      } else {
         for(int i = 0; i < costs.length; i ++) {
            //shuffle
            int[][] costs1 = new int[costs.length][costs[0].length];
            for(int j = 0; j < costs.length; j ++) {
               int costIndex = (i + j) % costs.length;
               System.arraycopy(costs[costIndex], 0, costs1[j], 0, costs[costIndex].length);
            }

            int currentM = 0;
            for(int gIndex = 0; gIndex < costs1[0].length; gIndex ++) {
               currentM += costs1[0][gIndex];

               int sub = 0;
               //still have g to kill
               int remainMNum = costs1.length - 1;
               int remainGNum = costs1[0].length - gIndex - 1;
               if(remainGNum > 0) {

                  if(remainMNum > 0) {
                     int[][] subCosts = new int[remainMNum][remainGNum];
                     for (int subIndex = 0; subIndex < subCosts.length; subIndex++) {
                        System.arraycopy(costs1[subIndex + 1], gIndex + 1, subCosts[subIndex], 0, remainGNum);
                     }
                     sub = kill(subCosts);
                  } else {
                     //no free m, let current m kill all remaining g.
                     continue;
                  }
               } else {
                  //we have kill all, although some M still free.
               }

               int total = currentM + sub;
               if(small < 0) {
                  small = total;
               } else if(small > total) {
                  small = total;
               }
            }
         }
      }


      /*System.out.println("input: ");
      for (int[] cost : costs) {
         System.out.println(Arrays.toString(cost));
      }

      System.out.println("output: " + small);*/

      history.put(code, small);

      return small;
   }

}
