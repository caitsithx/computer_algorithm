package interview.microsoft;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * Created by caitsithx on 14-6-9.
 */
@RunWith(Parameterized.class)
public class CircleInLinkedListTest {
    private Node head;
    private boolean hasCircle;

    public CircleInLinkedListTest(Node head, boolean hasCircle) {
        this.head = head;
        this.hasCircle = hasCircle;
    }

    @Parameterized.Parameters
    public static final Iterable data() {
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

        return Arrays.asList(
                new Object[][]{
                        {head1, false}, {head2, true}, {head3, true}

                });
    }


    @Test
    public void test() {
        Assert.assertEquals(hasCircle, CircleInLinkedList.hasCircle(head));
    }
}
