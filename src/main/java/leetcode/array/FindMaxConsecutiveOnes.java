package leetcode.array;

public class FindMaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        int j = 0;

        int max = 0;
        while (i < nums.length) {
            if (nums[i] != 1) {
                if (i - j > max) {
                    max = i - j;
                }
                j=i;
                while (i < nums.length && nums[i] != 1 ) {
                    j++;
                    i++;
                }
            }

            if(i < nums.length) {
                i++;
            }
        }

        if (i - j > max) {
            max = i - j;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,1,1,0, 1};
        System.out.println(new FindMaxConsecutiveOnes().findMaxConsecutiveOnes(nums));
    }
}
