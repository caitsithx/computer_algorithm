/***************************************************************************
 * Copyright (c) 2016 VMware, Inc. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ***************************************************************************/
package hackerrank.algorithms.insert_sort_1;

import java.util.Scanner;

public class Solution {



   public static void insertIntoSorted(int[] ar) {
      // Fill up this function
   }


   /* Tail starts here */
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int s = in.nextInt();
      int[] ar = new int[s];
      for(int i=0;i<s;i++){
         ar[i]=in.nextInt();
      }
      insertIntoSorted(ar);
   }


   private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
      System.out.println("");
   }


}
