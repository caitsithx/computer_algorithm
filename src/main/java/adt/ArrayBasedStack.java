/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
package adt;

import algorithm.puzzle100.struct.IStack;

import java.util.Arrays;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 */
public class ArrayBasedStack<T> implements IStack<T> {

    private T[] m_internal;
    private int m_count;

    public ArrayBasedStack(int p_size) {
        m_internal = (T[]) new Object[p_size];
        m_count = 0;
    }

    public boolean isEmpty() {
        return m_count == 0;
    }

    public int size() {
        return m_count;
    }

    public T get(int p_index) {
        return m_internal[p_index];
    }

    public T pop() {
        if (m_count == 0) {
            throw new RuntimeException();
        }
        T l_val = m_internal[--m_count];
        m_internal[m_count] = null;
        return l_val;
    }

    public boolean push(T p_value) {
        boolean l_ok = false;
        if (m_count < m_internal.length) {
            m_internal[m_count++] = p_value;
            l_ok = true;
        }

        return l_ok;
    }

    @Override
    public String toString() {
        return Arrays.toString(m_internal);
    }

    public T top() {
        return m_internal[m_count - 1];
    }
}
