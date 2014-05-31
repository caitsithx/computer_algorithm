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
public class MMChessTest {
    private int[] grids;
    private int[] cards;
    private int score;

    private MMChess mmChess = new MMChess();

    public MMChessTest(int[] grids, int[] cards, int result) {
        this.grids = grids;
        this.cards = cards;
        this.score = result;
    }

    @Parameterized.Parameters
    public static final Iterable data() {
        return Arrays.asList(
            new Object[][] {
                {new int[] {0, 1, 2, 3}, new int[] {1, 1}, 3},
                {new int[] {0, 1, 2, 3, 4, 5, 1000, 1}, new int[] {1, 1, 2, 3, 5}, 1009},
                {new int[] {0, 1, 2, 3}, new int[] {1, 1, 2}, 5}
            });
    }

    @Test
    public void testPlay1() {
        MMResult result =
            mmChess.play(grids, cards);

        Assert.assertEquals(score, result.score);
    }

}
