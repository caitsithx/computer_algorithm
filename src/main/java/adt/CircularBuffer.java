package adt;

import java.util.Arrays;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 * @since RM 3.0.0
 */
public class CircularBuffer<T> {
    private T[] array = null;
    private int startIdx = 0;
    private int count = 0;
    private int endIdx = 0;

    public CircularBuffer(int size) {
        array = (T[]) new Object[size];
        Arrays.fill(array, -1);
    }

    public final boolean isFull() {
        return count == array.length;
    }

    public final boolean isEmpty() {
        return count == 0;
    }

    public final boolean add(T item) {
        if(item == null) {
            throw new IllegalArgumentException();
        }

        if (isFull()) {
            return false;
        }

        array[endIdx] = item;
        count++;
        endIdx++;

        if (endIdx == array.length) {
            endIdx = 0;
        }

        return true;
    }

    public final T poll() throws Exception {
        if (isEmpty()) {
            throw null;
        }

        T item = null;

        item = array[startIdx];
        array[startIdx] = null;
        startIdx++;
        count--;

        if (startIdx == array.length) {
            startIdx = 0;
        }


        return item;
    }

    public String toString() {
        if (array == null) {
            return "";
        }

        return Arrays.toString(array);
    }

    @SuppressWarnings("javadoc")
    public final static void main(String[] args) throws Exception {
        CircularBuffer cb = new CircularBuffer(4);

        int i = 0;
        for (; i < 5; i++) {
            cb.add(i);
            System.err.println(cb);
        }

        System.err.println();

        for (; i > 2; i--) {
            cb.poll();
            System.err.println(cb);
        }

        System.err.println();

        int j = 0;
        for (; j < 5; j++) {
            cb.add(j);
            System.err.println(cb);
        }

        System.err.println();

        for (; i > 0; i--) {
            cb.poll();
            System.err.println(cb);
        }

    }
}
