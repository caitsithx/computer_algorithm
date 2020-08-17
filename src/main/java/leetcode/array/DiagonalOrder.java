package leetcode.array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DiagonalOrder {

    public static void main(String[] args) {
//        int[][] result = new int[][]{
//                {1,2,3,4},
//                {4,5,6,7},
//                {7,8,9,10},
//                {11,12,13,14}
//        };

//        int[][] result = new int[][]{
//                {1,2},
//                {3,4}
//        };

        int[][] result = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(Arrays.stream(new DiagonalOrder().findDiagonalOrder(result)).mapToObj(Integer::toString).collect(Collectors.joining(",")));
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0) {
            return new int[0];
        }

        boolean up = true;
        int[] result = new int[matrix.length * matrix[0].length];

        int x = 0;
        int y = 0;
        int i = 0;
        while (x < matrix.length && y < matrix[0].length) {
            result[i++] = matrix[x][y];

            if (x == matrix.length - 1 && y == matrix[0].length - 1) {
                break;
            }

            if (up) {
                if (x - 1 >= 0 && y + 1 < matrix[0].length) {
                    x = x - 1;
                    y = y + 1;
                } else if (y + 1 >= matrix[0].length) {
                    x = x + 1;
                    up = false;
                } else if (x - 1 < 0) {
                    y = y + 1;
                    up = false;
                }
            } else {
                if (y - 1 >= 0 && x + 1 < matrix.length) {
                    y = y - 1;
                    x = x + 1;
                } else if (x + 1 >= matrix.length) {
                    y = y + 1;
                    up = true;
                }
                else if (y - 1 < 0) {
                    x = x + 1;
                    up = true;
                }
            }
        }

        return result;
    }
}
