package binarysearchtree;

public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean isEmpty();
    boolean contains(E e);
    int getSize();
}
