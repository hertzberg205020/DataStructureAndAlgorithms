package practicalQueue;

import dynamicArray.Array;

public class ArrayQueue<E> implements Queue<E>{
    private Array<E> data;
    public ArrayQueue(int capacity) {
        data = new Array<>(capacity);
    }
    public ArrayQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.getCapacity();
    }

    @Override
    public void enqueue(E e) {
        data.addLast(e);
    }

    @Override
    public E deque() {
        return data.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public E getFront() {
        return data.getFirstElement();
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size: %d, capacity: %d\n", getSize(), getCapacity()));
        res.append("front[");
        for (int i = 0; i < getSize(); i++) {
            res.append(data.getElement(i));
            if (i != getSize()-1) {
                res.append(", ");
            }
        }
        res.append("]tail");
        return res.toString();
    }
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>(5);
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.deque();
                System.out.println(queue);
            }
        }

    }
}
