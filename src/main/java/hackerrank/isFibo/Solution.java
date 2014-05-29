package hackerrank.isFibo;

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
        long[] inputs = new long[numCases];

        Map<Long, Boolean> cache = new HashMap<Long, Boolean>();
        for(int i = 0; i < numCases; i ++)
        {
            inputs[i] = Long.parseLong(in.readLine());
            cache.put(inputs[i], false);
        }

        long[] sortedInputs = new long[numCases];
        System.arraycopy(inputs, 0, sortedInputs, 0, inputs.length);
        Arrays.sort(sortedInputs);

        for(int i = 0; i < numCases; i ++) {
            sortedInputList.add(sortedInputs[i]);
        }

        start(0, 1);

        for(int i = 0; i < numCases; i ++)
        {
            if(trueList.contains(inputs[i])) {
                System.out.println("IsFibo");
            } else {
                System.out.println("IsNotFibo");
            }
        }

    }

    static int index;
    static LinkedList<Long> sortedInputList = new LinkedList<Long>();
    static HashSet<Long> trueList = new HashSet<Long>();

    private static void start(long fibo0, long fibo1) {
       long fibo2 = fibo0 + fibo1;
        if(sortedInputList.peek() > fibo2) {
            start(fibo1, fibo2);
        } else {
            do {
                if(sortedInputList.peek() == fibo2) {
                trueList.add(sortedInputList.remove());
                } else {
                    sortedInputList.remove();
                }
            } while (sortedInputList.size() > 0 && sortedInputList.peek() <= fibo2);

            if(sortedInputList.size() > 0) {
                start(fibo1, fibo2);
            }

        }
    }
}