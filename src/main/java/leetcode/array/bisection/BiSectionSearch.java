package leetcode.array.bisection;

public class BiSectionSearch {

    //[-1,0,3,5,9,12]
    //2
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
//        int[] nums = new int[]{2, 5};
        System.out.println(new BiSectionSearch().search1(nums, 9));
    }

    public int search(int[] nums, int target) {
        int foundIndex = -1;
        if (nums.length == 0) {
            return foundIndex;
        }

        int i = 0;
        int j = nums.length - 1;

        foundIndex = search(nums, i, j, target);

        return foundIndex;
    }

    private int search(int[] nums, int i, int j, int target) {
        if (i == j) {
            if (nums[i] == target) {
                return i;
            } else {
                return -1;
            }
        } else {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                return search(nums, i, Math.max(mid - 1, i), target);
            } else {
                return search(nums, Math.min(mid + 1, j), j, target);
            }
        }
    }

    public int search1(int[] nums, int target) {
        int foundIndex = -1;
        if (nums == null || nums.length == 0) {
            return foundIndex;
        }

        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                foundIndex = mid;
                break;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return foundIndex;
    }
}
