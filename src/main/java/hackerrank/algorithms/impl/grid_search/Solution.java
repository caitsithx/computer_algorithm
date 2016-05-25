package hackerrank.algorithms.impl.grid_search;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int testCount = in.nextInt();
        IntStream.range(0, testCount).forEach(Solution::search);
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }

    static int gridRowCount;
    static int gridColumnCount;
    static String[] gridRows;
    static int patternRowCount;
    static int patternColCount;
    static String[] patternRows;

    private static void search(int index) {
        gridRowCount = in.nextInt();
        gridColumnCount = in.nextInt();
        gridRows = new String[gridRowCount];
        in.nextLine();
        IntStream.range(0, gridRowCount).forEach(i -> {
            gridRows[i] = in.nextLine();
        });
        patternRowCount = in.nextInt();
        patternColCount = in.nextInt();
        patternRows = new String[gridRowCount];
        in.nextLine();
        IntStream.range(0, patternRowCount).forEach(i -> {
            patternRows[i] = in.nextLine();
        });

        boolean matched = false;
        for (int rowIndex = 0; rowIndex < gridRowCount - patternRowCount + 1; rowIndex++) {
            int firstMatchedColumnIndex = gridRows[rowIndex].indexOf(patternRows[0], 0);
            for (int columnIndex = firstMatchedColumnIndex; columnIndex < gridColumnCount - patternColCount + 1 && columnIndex >= 0;) {
                matched = searchSub(rowIndex, columnIndex);
                if(matched) {
                    break;
                } else {
                    columnIndex = gridRows[rowIndex].indexOf(patternRows[0], columnIndex + 1);
                }
            }
            if(matched) {
                break;
            }
        }

        if(matched) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean searchSub(int rowIndex, int colIndex) {
        for(int patternRowIndex = 1; patternRowIndex < patternRowCount; patternRowIndex ++) {
            if(gridRows[rowIndex + patternRowIndex].indexOf(patternRows[patternRowIndex], colIndex) != colIndex) {
                return false;
            }
        }

        return true;
    }
}