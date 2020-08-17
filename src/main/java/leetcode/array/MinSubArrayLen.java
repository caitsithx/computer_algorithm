package leetcode.array;

public class MinSubArrayLen {

    public int minSubArrayLen(int s, int[] nums) {
        int max = 0;
        int i = 0;
        int j = 0;
        int tmp = 0;

        if(nums.length == 0) {
            return max;
        }

        do {
            tmp += nums[i];
            if (tmp >= s) {
                int current = i - j + 1;
                if (max == 0) {
                    max = current;
                } else if (max > current) {
                    max = current;

                    System.out.println(max);
                }

                do {
                    tmp -= nums[j];
                    j++;

                    if (tmp >= s) {
                        current = i - j + 1;
                        if (max == 0) {
                            max = current;
                        } else if (max > current) {
                            max = current;

                            System.out.println(max);
                        }
                    } else {
                        break;
                    }
                }
                while (j <= i);
            }

            i++;
        } while (i < nums.length);

        return max;
    }


    //80
    //[10,5,13,4,8,4,5,11,14,9,16,10,20,8]
    public static void main(String[] args) {
        int[] nums = new int[]{10,5,13,4,8,4,5,11,14,9,16,10,20,8};
        System.out.println(new MinSubArrayLen().minSubArrayLen(80, nums));
    }
}
