package interview.microsoft;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by caitsithx on 14-6-9.
 */
public class CircleInLinkedListTest {
    public static Stream<Arguments> createData() {
        Node node2 = new Node(3, null);
        Node node1 = new Node(2, node2);
        Node head1 = new Node(1, node1);

        Node node23 = new Node(3, null);
        Node node22 = new Node(3, node23);
        Node node21 = new Node(2, node22);
        node23.next = node21;
        Node head2 = new Node(1, node21);


        Node node33 = new Node(3, null);
        Node node32 = new Node(3, node33);
        Node node31 = new Node(2, node32);
        Node head3 = new Node(1, node31);
        node33.next = head3;

        return Stream.of(
                Arguments.of(head1, false),
                Arguments.of(head2, true),
                Arguments.of(head3, true)
        );
    }

    @ParameterizedTest
    @MethodSource("createData")
    public void test(Node head, boolean hasCircle) {
        Assertions.assertEquals(hasCircle, CircleInLinkedList.hasCircle(head));
    }
}
