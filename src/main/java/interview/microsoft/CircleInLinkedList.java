package interview.microsoft;

/**
 * Created by caitsithx on 14-6-9.
 */
public class CircleInLinkedList {
    public static boolean hasCircle(Node head) {
        Node previous = head;
        Node node = head.next;
        Node tmp = null;
        while (node != null) {
            if (head == node) {
                return true;
            }

            tmp = node.next;

            node.next = previous;
            previous = node;

            node = tmp;
        }

        return false;
    }
}

class Node {
    Node next;
    int val;

    public Node(int i, Node next) {
        val = i;
        this.next = next;
    }
}
