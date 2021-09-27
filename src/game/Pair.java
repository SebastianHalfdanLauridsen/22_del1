package game;

public class Pair<T1, T2> {
    private final T1 m_first;
    private final T2 m_second;

    public Pair(T1 first, T2 second) {
        m_first = first;
        m_second = second;
    }

    public T1 first() {
        return m_first;
    }

    public T2 second() {
        return m_second;
    }
}
