package practicalStack;

public interface Stack <E> {
    public void push(E e);
    public E pop();
    public boolean isEmpty();
    public int getSize();
    public E peek();
}
