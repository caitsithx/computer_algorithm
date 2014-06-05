package interview.microsoft;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * Created by caitsithx on 14-6-5.
 */
@RunWith(Parameterized.class)
public class MaxSubArrayTest {
    private int[] array;
    private int max;

    public MaxSubArrayTest(int[] array, int max) {
        this.array = array;
        this.max = max;
    }

    @Parameterized.Parameters
    public static final Iterable data() {
        return Arrays.asList(
                new Object[][]{
                        {new int[]{0, 1, 2, 3}, 6},
                        {new int[]{0, 1, 2, -4, -1, 3, -3, 1}, 3},
                        {new int[]{0, 1, 2, -2, 1, -4, 0}, 3},
                        {new int[]{0, -1, -2, -1, 2, -1}, 2},
                        {new int[]{0, -1, -2, -1, -3, -1}, 0},
                        {new int[]{-1, -2, -1, -3, -1}, -1},
                });
    }

    @Test
    public void testMethod() {
        MaxSubArray msa = new MaxSubArray();
        Assert.assertEquals(max, msa.getMaxSubArray(array));
    }
}
