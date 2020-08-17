package leetcode.array.bisection;

public class SpinMin {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1};
//        int[] nums = new int[]{2, 5};
        System.out.println(new SpinMin().findMin(nums));
    }
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return  -1;
        }

        if(nums.length == 1) {return nums[0];}

        Integer current = null;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if(j - i == 1){
                int tmp = Math.min(nums[i], nums[j]);
                if(current == null) {
                    current = tmp;
                } else {
                    current = Math.min(current, tmp);
                }
                break;
            } else {
                int middle = i + (j-i)/2;
                if (nums[i] < nums[middle]) {
                    if(current == null) {
                        current = nums[i];
                    } else {
                        current = Math.min(current, nums[i]);
                    }

                    i = middle+1;
                } else {
                    if(current == null) {
                        current = nums[middle];
                    } else {
                        current = Math.min(current, nums[middle]);
                    }

                    j = middle;
                }
            }

        }



        if(current == null) {
            current = nums[i];
        } else {
            current = Math.min(current, nums[i]);
        }
    return current;
    }
}
