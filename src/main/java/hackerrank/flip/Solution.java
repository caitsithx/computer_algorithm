package hackerrank.flip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static BufferedReader in = new BufferedReader(new InputStreamReader(
            System.in));

    static int numCases = 0;

    static int[] met = {0,0};
    static int max = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        numCases = Integer.parseInt(in.readLine());
        boolean[] bits = new boolean[numCases];

        String input  = in.readLine();

        for(int i =0; i < numCases*2; i ++) {
            if(i % 2 == 0) {
            bits[i/2] = (input.charAt(i)) == '1';
            }
        }

        run(bits);

    }

    static void run(boolean[] bits) {
        int falseCount = 0;
        int start = 0;
//        for(int i = 0; i < bits.length; i ++) {
//            if(bits[i]) {
//                start ++;
//            } else {
//                break;
//            }
//        }

        for(int i = 0; i < bits.length; i ++) {
            if(bits[i]) {
                falseCount --;
            } else {
                falseCount ++;
            }

            if(falseCount <= 0) {
                //restart
                start = i + 1;
                falseCount = 0;
            } else {
                //always count the sequence containing max number of false
                if(falseCount > max) {
                    met[0] = start;
                    met[1] = i;
                    max = falseCount;
                }
            }
        }



//        for(int i =met[0]; i <=  met[1]; i ++ ) {
//            bits[i] = !bits[i];
//        }

        int count = 0;
        for(int i = 0; i < bits.length; i ++) {
            if(i >= met[0] && i <= met[1]) {
                if(!bits[i]) count++;
            } else {
                if(bits[i]) count++;
            }
        }


//        System.out.print(met[0]);
//        System.out.print(met[1]);

        System.out.print(count);
    }


}