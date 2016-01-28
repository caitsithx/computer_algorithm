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
package hackerrank.twoArrays;

/**
 * Created by xiaoliangl on 1/28/16.
 * You are given two integer arrays, A and B, each containing N integers. The size of the array is less than or equal to 1000. You are free to permute the order of the elements in the arrays.
 * <p>
 * Now here's the real question: Is there an permutation A', B' possible of A and B, such that, A'i+B'i ≥ K for all i, where A'i denotes the ith element in the array A' and B'i denotes ith element in the array B'.
 * <p>
 * <p>
 * Input Format
 * The first line contains an integer, T, the number of test-cases. T test cases follow. Each test case has the following format:
 * <p>
 * The first line contains two integers, N and K. The second line contains N space separated integers, denoting array A. The third line describes array B in a same format.
 * <p>
 * Output Format
 * For each test case, if such an arrangement exists, output "YES", otherwise "NO" (without quotes).
 * <p>
 * <p>
 * Constraints
 * 1 <= T <= 10
 * 1 <= N <= 1000
 * 1 <= K <= 109
 * 0 <= Ai, Bi ≤ 109
 * <p>
 * <p>
 * Sample Input
 * <p>
 * 2
 * 3 10
 * 2 1 3
 * 7 8 9
 * 4 5
 * 1 2 2 1
 * 3 3 3 4
 * <p>
 * <p>
 * Sample Output
 * <p>
 * YES
 * NO
 * <p>
 * Explanation
 * <p>
 * The first input has 3 elements in Array A and Array B, we see that the one of the arrangements, 3 2 1 and 7 8 9 has each pair of elements (3+7, 2 + 8 and 9 + 1) summing upto 10 and hence the answer is "YES".
 * <p>
 * The second input has array B with three 3s. So, we need at least three numbers in A that are greater than 1. As this is not the case, the answer is "NO".
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Solution {
   private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
   public static void main(String[] args) throws IOException {
      int caseCount = Integer.parseInt(in.readLine());
      for (int i = 0; i < caseCount; i++) {
         String[] nums = in.readLine().split(" ");
         int arrayLen = Integer.parseInt(nums[0]);
         int numK = Integer.parseInt(nums[1]);

         List<Integer> listA = readIntArray();
         List<Integer> listB = readIntArray();

         boolean matched = false;
         for (Integer elemA : listA) {

            for (Iterator<Integer> iterator = listB.iterator(); iterator.hasNext(); ) {
               int elemB = iterator.next();
               if (elemA + elemB >= numK) {
//                  System.out.print(elemA + " ");
                  iterator.remove();
                  matched = true;
                  break;
               } else {
                  matched = false;
               }
            }

            if (!matched) {
               break;
            }
         }

         System.out.println(matched ? "YES" : "NO");
      }
   }

   private static boolean check1(int[] arrayA, int indexA, int[] arrayB, int indexB) {


      return false;
   }

   private static ArrayList<Integer> readIntArray() throws IOException {
      ArrayList<Integer> intList = new ArrayList<>();

      String[] counts = in.readLine().split(" ");
      Arrays.asList(counts).stream().mapToInt((String str) -> Integer.parseInt(str)).sorted().forEach(intList::add);

      return intList;
   }
}
