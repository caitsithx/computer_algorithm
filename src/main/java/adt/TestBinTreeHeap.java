/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
package adt;

import org.junit.jupiter.api.Test;

public class TestBinTreeHeap {
    @Test
    public void case1() {
        BinTreeHeap<Integer> l_bth = new BinTreeHeap<>(100);
        int l_max = 10;
        for (int l_i = 0; l_i < l_max; l_i++) {
            l_bth.insert(l_i);
        }

        for (int l_i = 0; l_i < l_max; l_i++) {
            System.out.println(l_bth.deleteMin());
        }
    }

    @Test
    public void case2() {
        System.out.println("case2.start");
        BinTreeHeapEx<IntegerEx> l_bth = new BinTreeHeapEx<>(100);
        int l_max = 10;
        for (int l_i = 0; l_i < l_max; l_i++) {
            l_bth.insert(new IntegerEx(l_i));
        }

        l_bth.increaseP(1, 11);
        System.out.println(l_bth);
        l_bth.increaseP(3, 15);
        System.out.println(l_bth);

        for (int l_i = 0; l_i < l_max; l_i++) {
            System.out.println(l_bth.deleteMin());
        }

        System.out.println("case2.end");
    }

    @Test
    public void case3() {
        System.out.println("case3.start");
        BinTreeHeapEx<IntegerEx> l_bth = new BinTreeHeapEx<>(100);
        int l_max = 10;
        for (int l_i = 0; l_i < l_max; l_i++) {
            l_bth.insert(new IntegerEx(l_i));
        }

        l_bth.delete(5);
        System.out.println(l_bth);

        for (int l_i = 0; l_i < l_max - 1; l_i++) {
            System.out.println(l_bth.deleteMin());
        }

        System.out.println("case3.end");
    }
}

class IntegerEx implements IPriorityItem<IntegerEx> {

    private int m_value;

    public IntegerEx(int p_val) {
        m_value = p_val;
    }

    @Override
    public String toString() {
        return Integer.toString(m_value);
    }

    /**
     * @return the value
     */
    public Integer getValue() {
        return this.m_value;
    }

    /**
     * @param p_value the value to set
     */
    public void setValue(Integer p_value) {
        this.m_value = p_value;
    }

    @Override
    public int compareTo(IntegerEx p_o) {
        return m_value - p_o.m_value;
    }

    @Override
    public void increase(int p_delta) {
        m_value += p_delta;
    }

    @Override
    public void decrease(int p_delta) {
        m_value -= p_delta;
    }

    @Override
    public int getPriority() {
        return getValue();
    }

}
