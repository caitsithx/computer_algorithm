package hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by xiaoliangl on 4/28/16.
 */
public class HourGlasses {
   private static int ARRAY_SIZE = 6;
   private static int GLASS_SIZE = 3;

   public static void main(String[] args) {
      int glassNum = ARRAY_SIZE - GLASS_SIZE + 1;
      int[][] glasses = new int[glassNum][glassNum];
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      try {

         for (int i = 0; i < ARRAY_SIZE; i++) {
            String[] numbers = reader.readLine().split(" ");
            for (int j = 0; j < ARRAY_SIZE; j++) {
               int val = Integer.parseInt(numbers[j]);
               if (i < glassNum && j < glassNum) {
                  add(glasses, i, j, val);
               }

               if (i < glassNum) {
                  if (j >= 1 && j - 1 < glassNum) {
                     add(glasses, i, j - 1, val);
                  }

                  if (j >= 2 && j - 2 < glassNum) {
                     add(glasses, i, j - 2, val);
                  }
               }

               if (i >= 1 && i - 1 < glassNum && j >= 1 && j - 1 < glassNum) {
                  add(glasses, i - 1, j - 1, val);
               }


               if (i >= 2 && i - 2 < glassNum) {
                  if (j < glassNum) {
                     add(glasses, i - 2, j, val);
                  }

                  if (j >= 1 && j - 1 < glassNum) {
                     add(glasses, i - 2, j - 1, val);
                  }

                  if (j >= 2 && j - 2 < glassNum) {
                     add(glasses, i - 2, j - 2, val);
                  }
               }
            }
         }

         for (int[] glass : glasses) {
            System.out.println(Arrays.toString(glass));
         }

         int[] maxes = new int[glassNum];

         for(int i = 0; i < glasses.length; i ++) {
            maxes[i] = Arrays.stream(glasses[i]).max().getAsInt();
         }

         System.out.println(Arrays.stream(maxes).max().getAsInt());

      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   private static void add(int[][] array, int x, int y, int val) {
      array[x][y] += val;
   }
}
