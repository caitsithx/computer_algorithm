package adt;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by caitsithx on 14-5-29.
 */
public class CircularBufferTest {
    @Test
    public void testAdd() {
        CircularBuffer cb = new CircularBuffer(4);

        int i = 0;
        for (; i < 4; i++) {
            cb.add(i);
            System.err.println(cb);
        }

        Assert.assertEquals(cb.add(4), false);

        Assert.assertEquals(cb.size(), 4);

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
