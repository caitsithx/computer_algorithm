
package hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by xiaoliangl on 4/28/16.
 */
public class SumDiagonal {
   public static void main(String[] args) {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      String str = null;
      try {
         str = reader.readLine();
         int count = Integer.parseInt(str);

         int[] sums = new int[]{0, 0};
         for(int i = 0; i < count; i ++) {
            str = reader.readLine();
            int[] values = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
            sums[0] += values[i];
            sums[1] += values[count - i - 1];
         }

         System.out.println(Math.abs(sums[0] - sums[1]));

      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
