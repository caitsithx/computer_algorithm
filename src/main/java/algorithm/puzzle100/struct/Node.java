package algorithm.puzzle100.struct;

public class Node<T> {
    private Node<T> m_previous;

    private Node<T> m_next;

    private T m_value;

    /**
     * @param p_value
     * @param p_previous
     * @param p_next
     */
    public Node(T p_value, Node<T> p_previous, Node<T> p_next) {
        super();
        this.m_value = p_value;
        this.m_previous = p_previous;
        this.m_next = p_next;
    }

    /**
     * @return the previous
     */
    public Node<T> getPrevious() {
        return this.m_previous;
    }

    /**
     * @param p_previous the previous to set
     */
    public void setPrevious(Node<T> p_previous) {
        this.m_previous = p_previous;
    }

    /**
     * @return the next
     */
    public Node<T> getNext() {
        return this.m_next;
    }

    /**
     * @param p_next the next to set
     */
    public void setNext(Node<T> p_next) {
        this.m_next = p_next;
    }

    /**
     * @return the value
     */
    public T getValue() {
        return this.m_value;
    }

    /**
     * @param p_value the value to set
     */
    public void setValue(T p_value) {
        this.m_value = p_value;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Node [m_value=" + this.m_value + "]";
    }


}
