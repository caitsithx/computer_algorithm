package leetcode.array.bisection;

import java.util.Arrays;

public class SpinSearch {

//[4,5,6,7,0,1,2]
//0
    public static void main(String[] args) {
        int[] nums = new int[]{5, 1,3};
//        int[] nums = new int[]{2, 5};
        System.out.println(new SpinSearch().search(nums, 3));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int index = search1(nums, target, 0, nums.length - 1);
        return index < 0 ? -1 : index;
    }

    public int search1(int[] nums, int target, int start, int end) {

        int middle = (start + end) / 2;

        if (nums[middle] == target) {
            return middle;
        }

        if(start == end) {
            return  -1;
        }

        if (nums[start] <= nums[middle]) {
            //great than order
            if (nums[middle] > target && nums[start] <= target) {
                return Arrays.binarySearch(nums, start, middle+1, target);
            } else {
                return search1(nums, target, middle+1, end);
            }
        } else {
            if (nums[middle] < target && nums[end] >= target) {
                return Arrays.binarySearch(nums, middle, end+1, target);
            } else {
                return search1(nums, target, start, middle-1);
            }
        }
    }
}
