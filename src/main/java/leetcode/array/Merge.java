package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> result = new ArrayList<>();
        int[] tmp = null;
        for (int[] range : intervals) {
            if(tmp == null) {
                tmp = range;
            } else {
                if(range[0] > tmp[1]) {
                    result.add(tmp);
                    tmp = range;
                } else {
                    tmp[1] = Math.max(tmp[1], range[1]);
                }
            }
        }

        if(tmp != null)
        result.add(tmp);

        return result.toArray(new int[0][]);
    }
}
