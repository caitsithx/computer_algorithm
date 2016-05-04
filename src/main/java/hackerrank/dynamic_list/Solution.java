package hackerrank.dynamic_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by xiaoliangl on 5/3/16.
 */
public class Solution {
   private static List<Integer>[] buffer = null;
   private static int lastAns = 0;
   private static int len = 0;
   public static void main(String[] args) {
      final Scanner scanner = new Scanner(System.in);
      len = scanner.nextInt();
      int testNum = scanner.nextInt();

      buffer = new List[len];
      IntStream.range(0, len).forEach(i ->{
         buffer[i] = new ArrayList<>();
      });

      IntStream.range(0, testNum).forEach(i -> {
         scanner.nextLine();

         int testType = scanner.nextInt();
         int x = scanner.nextInt();
         int y = scanner.nextInt();

         switch (testType) {
            case 1:
               test1(x,y);
               break;
            case 2:
               test2(x,y);
               break;
            default:
               throw new RuntimeException("what!");
         }
      });

   }

   private static void test2(int x, int y) {
      int index = (x ^ lastAns) % len;
      if(index >= len) {
         throw new RuntimeException("what!");
      }

      int lastAnsIndex = y % buffer[index].size();

      if(lastAnsIndex >= len) {
         throw new RuntimeException("what!");
      }

      lastAns = buffer[index].get(lastAnsIndex);
      System.out.println(lastAns);
   }

   private static void test1(int x, int y) {
      int index = (x ^ lastAns) % len;
      buffer[index].add(y);
   }


}
