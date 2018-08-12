package interview.amz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * Created by lixl on 4/23/14.
 */

public class MMChessTest {

    public static Stream<Arguments> createData() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 2, 3}, new int[]{1, 1}, 3),
                Arguments.of(new int[]{0, 1, 2, 3, 4, 5, 1000, 1}, new int[]{1, 1, 2, 3, 5}, 1009),
                Arguments.of(new int[]{0, 1, 2, 3}, new int[]{1, 1, 2}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("createData")
    public void testPlay1(int[] grids, int[] cards, int score) {
        MMChess mmChess = new MMChess();

        MMResult result =
                mmChess.play(grids, cards);

        Assertions.assertEquals(score, result.score);
    }

}
