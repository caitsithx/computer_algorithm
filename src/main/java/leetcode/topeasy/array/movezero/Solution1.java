package leetcode.topeasy.array.movezero;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Solution1 {
    public void moveZeroes(int[] nums) {
        if(nums.length == 0) return;


        int zero = 0;
        while (nums[zero] != 0) {
            zero ++;
            if(zero == nums.length) {
                return;
            }
        }

        int nonzero = zero;
        while(zero < nums.length && nonzero < nums.length) {
            while(nums[nonzero] == 0) {
                nonzero ++;
                if(nonzero == nums.length) {
                    return;
                }
            }
            int tmp = nums[nonzero];
            nums[nonzero] = nums[zero];
            nums[zero] = tmp;
            nonzero++;
            zero ++;
        }
    }

    @Test
    public void test() {
        int[] array = new int[] {1,2,0, 3};
        new Solution1().moveZeroes(array);
        Arrays.stream(array).forEach(System.out::println);

        array = new int[] {0,1,2,0, 3};
        new Solution1().moveZeroes(array);
        Arrays.stream(array).forEach(System.out::println);
        array = new int[] {1,1,2};
        new Solution1().moveZeroes(array);
        Arrays.stream(array).forEach(System.out::println);
    }

}
