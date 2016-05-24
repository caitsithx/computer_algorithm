/*
 * Copyright (c) 2016 caitsithx - All rights reserved.
 *
 */
package hackerrank.algorithms.sort.insert_sort_1;

import java.util.Scanner;

public class Solution {


    public static void insertIntoSorted(int[] ar) {
        int tmp = ar[ar.length - 1];
        for(int i = ar.length - 2; i >=0; i --) {
            if(ar[i] > tmp) {
                ar[i + 1] = ar [i];
                printArray(ar);
                if(i == 0) {
                    ar[0] = tmp;
                    printArray(ar);
                    break;
                }

            } else {
                ar [i + 1] = tmp;
                printArray(ar);
                break;
            }

        }
    }


    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        insertIntoSorted(ar);
    }


    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }


}
