package hackerrank.decent_number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

   public static void main(String[] args) {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      String str = null;
      try {
         str = reader.readLine();
         int caseCount = Integer.parseInt(str);

         int[] counts = new int[caseCount];
         for(int i = 0; i < caseCount; i ++) {
            counts[i] = Integer.parseInt(reader.readLine());
         }

         for(int count: counts) {
            int count3 = getCount3(count);
            if(count3 != -1) {
               for(int i = 0; i < count - count3; i ++) {
                  System.out.print('5');
               }

               for(int i = 0; i < count3; i ++) {
                  System.out.print('3');
               }

               System.out.println();
            } else {
               System.out.println(-1);
            }
         }


      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   private static  int getCount3(int count) {
      if(count % 3 == 0) {
         return 0;
      } else {
         int count5 = count / 3 * 3;
         int count3 = count - count5;

         while(count5 != 0 && count3 % 5 != 0) {
            count5 -=3;
            count3 +=3;
         }

         if(count3 % 5 == 0) {
            return count3;
            //good
         }
      }

      return -1;
   }
}