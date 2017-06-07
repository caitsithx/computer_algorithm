package amz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import amz.DiffIndexNewImproved.ActionList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Created by lixl on 4/23/14.
 */
@RunWith(Parameterized.class)
public class DiffIndexNewImprovedTest {
    private String[] phrase1;
    private String[] phrase2;
    private int minDiffIndex;

    public DiffIndexNewImprovedTest(String[] phrase1, String[] phrase2, int minDiffIndex) {
        this.phrase1 = phrase1;
        this.phrase2 = phrase2;
        this.minDiffIndex = minDiffIndex;
    }

    @Parameterized.Parameters
    public static Iterable data() {
        return Arrays.asList(
            new Object[][] {
                //            {new String[] {"Hello", "World"}, new String[] {"Hello", "Apple"}, 1},
                {new String[] {"Big", "Mac", "Air", "Machine"}, new String[] {"Mac", "Computer", "Hello", "Machine", "OK"}, 4}
            });
    }

    @Test
    public void testPlay1() {
        ActionList actionList = DiffIndexNewImproved.calculate(phrase1, phrase2);

        System.out.println("actionList: " + Arrays.toString(actionList.sequence.toArray()));
        Assert.assertEquals(minDiffIndex, actionList.actionCount);
        System.out.println("perf count is: " + DiffIndexNewImproved.perfCount);
    }

}
