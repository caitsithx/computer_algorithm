package interview.microsoft;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * Created by caitsithx on 14-6-5.
 */

public class MaxSubArrayTest1 {

    public static Stream<Arguments> createData() {

        return Stream.of(
                Arguments.of(new int[]{0, 1, 2, 3}, 6),
                Arguments.of(new int[]{0, 1, 2, -4, -1, 3, -3, 1}, 3),
                Arguments.of(new int[]{0, 1, 2, -2, 1, -4, 0}, 3),
                Arguments.of(new int[]{0, -1, -2, -1, 2, -1}, 2),
                Arguments.of(new int[]{0, -1, -2, -1, -3, -1}, 0),
                Arguments.of(new int[]{-1, -2, -1, -3, -1}, -1)
        );
    }


    @ParameterizedTest
    @MethodSource("createData")
    public void testMethod(int[] array, int max) {
        MaxSubArray1 msa = new MaxSubArray1();
        Assertions.assertEquals(max, msa.getMaxSubArray(array));
    }
}
