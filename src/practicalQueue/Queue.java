package practicalQueue;

public interface Queue<E> {
    public void enqueue(E e);
    public E deque();
    public boolean isEmpty();
    public int getSize();
    public E getFront();
}
