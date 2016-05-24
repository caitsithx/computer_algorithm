
package hackerrank.sparse_arrays;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by xiaoliangl on 5/3/16.
 */
public class Solution {
   private Node root = new Node('r');
   public void store(String str) {
      char[] chars = str.toCharArray();

      Node parent = root;
      for(char ch : chars) {
         parent = add(ch, parent);
      }
      parent.count ++;
   }

   public int query(String str) {
      char[] chars = str.toCharArray();

      Node parent = root;
      for(char ch : chars) {
         parent = search(parent, ch);
      }

      return parent == null ? 0 : parent.count;
   }

   private Node search(Node parent, char ch) {
      if(parent.east == null) {
         return null;
      } else {
         Node current = parent.east;
         while(current.ch != ch && current.south != null) {
            current = current.south;
         }

         if(current.ch == ch) {
            return current;
         } else {
            return null;
         }
      }

   }


   private Node add(char ch, Node parent) {
      if(parent.east == null) {
         parent.east = new Node(ch);
         return parent.east;
      } else {
         Node current = parent.east;
         while(current.ch != ch && current.south != null) {
            current = current.south;
         }

         if(current.ch == ch) {
            return current;
         } else {
            current.south = new Node(ch);
            return  current.south;
         }
      }
   }

   public static void handle(String[] inputs, String[] queries) {
//      String[] inputs = {"aba",
//            "baba",
//            "aba",
//            "xzxb"};
//
//      String[] queries = {"aba",
//            "xzxb",
//            "ab"};
      Solution ndArray = new Solution();
      for(String input : inputs) {
         ndArray.store(input);
      }


      for(String query : queries) {
         System.out.println(ndArray.query(query));
      }

   }

   private static String[] inputs;
   private static String[] queries;
   public static void main(String[] args) {
      final Scanner scanner = new Scanner(System.in);
      int len = scanner.nextInt();
      scanner.nextLine();
      inputs = new String[len];
      IntStream.range(0, len).forEach(i -> {
         inputs[i] = scanner.nextLine();
      });

      len = scanner.nextInt();
      scanner.nextLine();
      queries = new String[len];
      IntStream.range(0, len).forEach(i -> {
         queries[i] = scanner.nextLine();
      });

      handle(inputs, queries);
   }

}

class Node {
   int count;
   char ch;
   Node east;
   Node south;
   Node(char ch1) {
      ch = ch1;
      count = 0;
   }
}