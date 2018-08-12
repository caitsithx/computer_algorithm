package interview.amz;

import interview.amz.DiffIndexNewImproved.ActionList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by lixl on 4/23/14.
 */
public class DiffIndexNewImprovedTest {

    @ParameterizedTest
    @MethodSource("createData")
    public void testPlay1(String[] phrase1, String[] phrase2, int minDiffIndex) {
        ActionList actionList = DiffIndexNewImproved.calculate(phrase1, phrase2);

        System.out.println("actionList: " + Arrays.toString(actionList.sequence.toArray()));
        Assertions.assertEquals(minDiffIndex, actionList.actionCount);
        System.out.println("perf count is: " + DiffIndexNewImproved.perfCount);
    }

    private static Stream<Arguments> createData() {
        return Stream.of(
                Arguments.of(new String[]{"Hello", "World"}, new String[]{"Hello", "Apple"}, 1),
                Arguments.of(new String[]{"Big", "Mac", "Air", "Machine"}, new String[]{"Mac", "Computer", "Hello", "Machine", "OK"}, 4));
    }

}
