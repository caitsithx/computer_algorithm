package leetcode.array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Rotate {

    public void rotate(int[][] matrix) {
        rotate(matrix, 0, matrix.length - 1);
    }

    private void rotate(int[][] matrix, int start, int end) {
        int length = end - start + 1;
        if (length >= 2) {
            for (int i = start; i < end; i++) {
                int tmp = matrix[i][start];
                matrix[i][start] = matrix[end][i];
                matrix[end][i] = matrix[end - i+start][end];
                matrix[end - i+start][end] = matrix[start][end - i+start];
                matrix[start][end - i+start] = tmp;
            }

            rotate(matrix, start + 1, end - 1);
        }
    }

    public static void main(String[] args) {
        int[][] result = new int[][]{
                {1,2,3,4},
                {4,5,6,7},
                {7,8,9,10},
                {11,12,13,14}
        };

//        int[][] result = new int[][]{
//                {1,2},
//                {3,4}
//        };
        new Rotate().rotate(
                result
        );

        for (int[] line : result) {
            System.out.println(Arrays.stream(line).mapToObj(Integer::toString).collect(Collectors.joining(",")));
        }
    }
}
