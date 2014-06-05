package interview.microsoft;

/**
 * 取得连续的sum最大的sub array
 * Created by caitsithx on 14-6-5.
 */
public class MaxSubArray {

    protected int[] max = null;

    public int getMaxSubArray(int[] array) {
        int current = 0;

        for (int i = 0; i < array.length; i++) {
            current += array[i];

            if (max == null) {
                max = new int[1];
                max[0] = current;
            } else {
                if (current > max[0]) {
                    max[0] = current;
                }
            }


            if (current < 0) {
                current = 0;
            }
        }

        return max[0];
    }

}
