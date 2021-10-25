package practicalQueue;

public class LoopQueuePractice01<E> implements Queue<E>{
    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueuePractice01(int capacity) {
        data = (E[]) new Object[capacity];
        //由於不必浪費空間，陣列大小為capacity，而不是capacity+1
        front = 0;
        tail = 0;
        size = 0;
    }
    public LoopQueuePractice01() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }


    @Override
    public void enqueue(E e) {
        //不再使用(tail+1)%data.length==front判斷陣列是否為滿
        //而是直接使用size
        if (size == data.length) {
            resize(getCapacity()*2);
        }
        data[tail] = e;
        tail = (tail+1) % data.length;
        size++;
    }
    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i+front)% data.length];
        }
        data = newData;
        front = 0;
        tail = size;

    }

    @Override
    public E deque() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        front = (front+1)% data.length;
        size--;
        if (size == getCapacity()/4 && getCapacity()/2 != 0) {
            resize(getCapacity()/2);
        }
        return ret;
    }

    @Override
    public boolean isEmpty() {
        //不在使用tail == front判斷陣列是否為
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public E getFront() {
        return data[front];
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Qurue: size: %d, capacity: %d\n", size, getCapacity()));
        res.append("tail[");
        //循環遍歷打印隊列的邏輯也應該更改
        for (int i = 0; i < size ; i++) {
            res.append(data[(front+i)%data.length]);
            //if ((i+front+1)% data.length != tail)
            if (i != size-1) {
                res.append(", ");
            }
        }
        res.append("]tail");
        return res.toString();
    }
    public static void main(String[] args) {
        LoopQueuePractice01<Integer> queue = new LoopQueuePractice01<>(5);
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
