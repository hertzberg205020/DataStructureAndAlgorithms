package practicalQueue;

public class Deque<E> {
    private int front;
    private int tail;
    private int size;
    private E[] data;

    public Deque(int capacity) {
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }
    public Deque() {
        this(10);
    }
    public int getSize() {
        return size;
    }
    public int getCapacity() {
        return data.length;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }
    public E getLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        //因tail指向的是隊尾元素的下一個位置，需要計算真正隊尾元素所對應的索引位置
        //int idnex = tail == 0 ? data.length -1 : tail-1;
        //return data[index];
        return data[(tail-1+ data.length)% data.length];
    }

    public void addFront(E e) {
        if(size == getCapacity()) {
            resize(getCapacity()*2);
        }
        //首先要確定添加新元素的索引位置
        //此索引位置為front-1 這個地方
        //但要注意front == 0時，新添加元素的索引位置為data.length-1
        front = (front-1+getCapacity())%data.length;
        data[front] = e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for(int i=0; i < size; i++) {
            newData[i] = data[(i+front)%data.length];
        }
        front = 0;
        tail = size;
        data = newData;
    }

    public void addLast(E e) {
        if (size == getCapacity()) {
            resize(getCapacity()*2);
        }
        data[tail] = e;
        tail = (tail+1)%data.length;
        size++;
    }

    public E removeFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from empty deque.");
        }
        E ret = data[front];
        front = (front+1) % data.length;
        size--;
        if (size == getCapacity()/4 && getCapacity()/2 != 0) {
            resize(getCapacity()/2);
        }
        return  ret;
    }
    public E removeLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from empty deque.");
        }
        //計算刪除隊尾元素後，新的tail索引位置
        tail = tail == 0 ? data.length-1 : tail -1;
        E ret = data[tail];
        data[tail] = null;
        size--;
        if (size == getCapacity()/4 && getCapacity()/2 != 0) {
            resize(getCapacity()/2);
        }
        return ret;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Deque: size: %d, capacity: %d\n", size, getCapacity()));
        res.append("front[");
        for(int i = 0; i < size; i++) {
            res.append(data[(i+front)% data.length]);
            if(i != size-1) {
                res.append(", ");
            }
        }
        res.append("]tail");
        return res.toString();
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>(5);
        for (int i = 0; i < 10; i++) {
            deque.addLast(i);
            System.out.println(deque);
        }
        for (int i = 0; i < 9; i++) {
            deque.removeLast();
            System.out.println(deque);
        }

    }
}
