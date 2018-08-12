package interview.amz;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * Created by lixl on 4/23/14.
 */

public class DiffIndexTest {
    public static Stream<Arguments> createData() {
        return Stream.of(
                Arguments.of(new String[]{"Hello", "World"}, new String[]{"Hello", "Apple"}, 1),
                Arguments.of(new String[]{"Big", "Mac", "Air", "Machine"}, new String[]{"Mac", "Computer", "Hello", "Machine", "OK"}, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("createData")
    public void testPlay1(String[] phrase1, String[] phrase2, int minDiffIndex) {
        DifferentIndex di = new DifferentIndex();
        di.diffIndex(phrase1, phrase2);
        Assertions.assertEquals(minDiffIndex, di.min.get(0).actionCount);
    }

}
