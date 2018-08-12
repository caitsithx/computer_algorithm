package leetcode.topeasy.array;

import org.junit.jupiter.api.Test;

class Solution {
    public void rotate(int[][] matrix) {
        int start = 0;
        int end = matrix.length - 1;

        while(start < end) {

            for (int i = start; i < end; i++) {
                int tmp = matrix[start][i];
                matrix[start][i] = matrix[matrix.length - 1 - i][start];
                matrix[matrix.length - 1 - i][start] = matrix[matrix.length - 1 - start][matrix.length - 1 - i];
                matrix[matrix.length - 1 - start][matrix.length - 1 - i] = matrix[i][matrix.length - 1 - start];
                matrix[i][matrix.length - 1 - start] = tmp;
            }

            start ++;
            end --;
        }
    }

    @Test
    public void test() {
        new Solution().rotate(new int[][]{{1,2,3,1},{4,5,6,4},{7,8,9,8},{7,8,9,8}});
    }
}
