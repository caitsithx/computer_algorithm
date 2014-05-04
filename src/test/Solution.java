package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static BufferedReader in = new BufferedReader(new InputStreamReader(
            System.in));
    static StringBuilder out = new StringBuilder();

    static int numCases = 0;
    public static void main(String[] args) throws NumberFormatException, IOException {
        numCases = Integer.parseInt(in.readLine());

        for(int i =0; i < numCases; i ++) {
            boolean three = (i+1) % 3 == 0;
            boolean five = (i+1) % 5 == 0;

            if(three && five) {
                System.out.println("FizzBuzz");
            } else if(three){
                System.out.println("Fizz");
            }else if(five){
                System.out.println("Buzz");
            } else {
                System.out.println(i+1);
            }
        }

    }


}