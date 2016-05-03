package hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class ReverseArray {

   private static boolean started = false;
   public static void main(String[] args) {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      String str = null;
      try {
         str = reader.readLine();
         int count = Integer.parseInt(str);
         str = reader.readLine();

         String[] intStrs = str.split(" ");

         IntStream.range(1, count + 1).mapToObj(i -> intStrs[count - i]).forEach(ele -> {
            if(started) {
               System.out.print(' ');
            } else {
               started = true;
            }
            System.out.print(ele);
         });

      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}