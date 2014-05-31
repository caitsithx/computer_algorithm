package adt;

import java.util.Arrays;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 */
public class CircularBuffer<T> {
    private T[] array = null;
    private int startIdx = 0;
    private int size = 0;
    private int endIdx = 0;

    public CircularBuffer(int size) {
        array = (T[]) new Object[size];
        Arrays.fill(array, null);
    }

    public final boolean isFull() {
        return size == array.length;
    }

    public final int size() {
        return size;
    }

    public final boolean isEmpty() {
        return size == 0;
    }

    public final boolean add(T item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        if (isFull()) {
            return false;
        }

        array[endIdx] = item;
        size++;
        endIdx++;

        if (endIdx == array.length) {
            endIdx = 0;
        }

        return true;
    }

    public final T poll() {
        if (isEmpty()) {
            throw null;
        }

        T item = null;

        item = array[startIdx];
        array[startIdx] = null;
        startIdx++;
        size--;

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

}
