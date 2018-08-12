package leetcode.topeasy.array.movezero;

class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length == 0) return;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] != 0) {
                i ++;
                continue;
            }

            if(nums[j] == 0) {
                j --;
                continue;
            }

            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i ++;
            j --;
        }
    }
}
