package interview.microsoft;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 取得连续的sum最大的sub array, 中间可以间隔一次
 * Created by caitsithx on 14-6-5.
 */
public class MaxSubArray1 {

    protected ArrayList<Integer> history = new ArrayList<>();
    protected int[] max = null;

    public int getMaxSubArray(int[] array) {
        int current = 0;

        for (int i = 0; i < array.length; i++) {
            current += array[i];

            if (max == null) {
                max = new int[1];
                max[0] = current;
            } else if (current > max[0]) {
                max[0] = current;
            }

            if (current < 0) {
                addHistory();
                current = 0;
            }
        }

        if (max != null) {
            addHistory();
        }
        return getMax();
    }

    private void addHistory() {
        history.add(max[0]);
        max = null;
        Collections.sort(history);

        if (history.size() > 2) {
            history.remove(0);
        }
    }

    public int getMax() {
        int max1 = history.get(history.size() - 1);

        if (history.size() == 1) {
            return max1;
        }

        int max2 = history.get(history.size() - 2);

        return max1 + max2 > max1 ? max1 + max2 : max1;
    }
}
