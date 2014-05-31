package amz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * Created by lixl on 4/23/14.
 */
@RunWith(Parameterized.class)
public class DiffIndexTest {
    private String[] phrase1;
    private String[] phrase2;
    private int minDiffIndex;

    private DifferentIndex di = new DifferentIndex();

    public DiffIndexTest(String[] phrase1, String[] phrase2, int minDiffIndex) {
        this.phrase1 = phrase1;
        this.phrase2 = phrase2;
        this.minDiffIndex = minDiffIndex;
    }

    @Parameterized.Parameters
    public static final Iterable data() {
        return Arrays.asList(
            new Object[][] {
                //            {new String[] {"Hello", "World"}, new String[] {"Hello", "Apple"}, 1},
                {new String[] {"Big", "Mac", "Air", "Machine"}, new String[] {"Mac", "Computer", "Hello", "Machine", "OK"}, 4}
            });
    }

    @Test
    public void testPlay1() {
        di.diffIndex(phrase1, phrase2);
        Assert.assertEquals(minDiffIndex, di.min.get(0).actionCount);
    }

}
