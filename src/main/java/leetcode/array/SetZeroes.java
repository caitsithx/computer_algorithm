package leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        Set<Integer> xResults = new HashSet<>();
        Set<Integer> yResults = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {


            for (int j = 0; j < matrix[i].length; j++) {

                if(matrix[i][j] == 0) {
                    xResults.add(i);
                    yResults.add(j);
                }
            }
        }

        for (int x : xResults) {
            Arrays.fill(matrix[x], 0);
        }

        for (int y : yResults) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][y] = 0;
            }
        }
    }
}
