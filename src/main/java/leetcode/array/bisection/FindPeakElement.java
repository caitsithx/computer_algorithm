package leetcode.array.bisection;

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int middle = i + (j-i)/2;
            if(nums[middle] < nums[middle + 1]) {
                i = middle +1;
            } else {
                j = middle;
            }
        }

        return i;
    }
}
