package hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongSum {

   public static void main(String[] args) {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      String str = null;
      try {
         str = reader.readLine();
         int count = Integer.parseInt(str);
         str = reader.readLine();
         long sum = Arrays.stream(str.split(" ")).mapToLong(Integer::parseInt).sum();

         System.out.println(sum);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}