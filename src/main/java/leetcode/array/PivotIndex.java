package leetcode.array;

public class PivotIndex {

    public static void main(String[] args) {
        System.out.println(new PivotIndex().pivotIndex(new int[]{1, 2, 3}));
    }

    public int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = 0;
        for (int i = 1; i < nums.length; i++) {
            right += nums[i];
        }
        if (left == right) {
            return 0;
        }
        int i = 0;

        while (i < nums.length - 1) {
            i = i + 1;

            left += nums[i - 1];
            right -= nums[i];
            if (left == right) {
                return i;
            }
        }

        return -1;
    }
}