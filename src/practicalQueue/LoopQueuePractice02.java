package practicalQueue;

public class LoopQueuePractice02<E> implements Queue<E> {
    private E[] data;
    private int front, tail;

    public LoopQueuePractice02(int capacity) {
        data = (E[]) new Object[capacity+1];
        front = 0;
        tail = 0;
    }
    public LoopQueuePractice02() {
        this(10);
    }

    public int getCapacity() {
        return data.length-1;
    }


    @Override
    public void enqueue(E e) {
        System.out.println("--------------------------------");
        System.out.println("enqueue.");
        if ((tail+1)%data.length == front) {
            resize(getCapacity()*2);
        }
        data[tail] = e;
        tail = (tail+1) % data.length;
        System.out.println("the tailIndex: " + tail);
        System.out.println("--------------------------------");
    }
    private void resize(int newCapacity) {
        System.out.println("-------------------------------");
        System.out.println("resize");
        E[] newData = (E[])new Object[newCapacity+1];
        for (int i = 0; i < getSize(); i++) {
            newData[i] = data[(i+front)% data.length];
        }
        //getSize在改動front之前要先賦值給tail，邏輯才會正確
        tail = getSize();
        front = 0;
        data = newData;
        System.out.println(String.format("frontIndex: %d, tailIndex: %d", front, tail));
        System.out.println("--------------------------------------");

    }

    @Override
    public E deque() {
        System.out.println("---------------------------");
        System.out.println("dequeue.");
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        front = (front+1)% data.length;
        if (getSize() == getCapacity()/4 && getCapacity()/2 != 0) {
            resize(getCapacity()/2);
        }
        System.out.println("---------------------------------------------");
        return ret;
    }

    @Override
    public boolean isEmpty() {
        return tail == front;
    }

    @Override
    public int getSize() {
        if(front == tail) return 0;
        if(front < tail) {
            return tail - front;
        } else {
            //如果front > tail 說明循環隊列"循環"了起來
            //此時隊列中元素個數為 tail - front + data.length
            //可以理解為 此時data中沒有元素的個數為front-tail
            //整體元素個數就是 data.length - (front-tail)
            return (getCapacity()+1)-(front-tail);
        }
        //return tail >= front ? tail-front : tail-front+data.length;
    }

    @Override
    public E getFront() {
        return data[front];
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Qurue: size: %d, capacity: %d\n", getSize(), getCapacity()));
        res.append("front[");
        for (int i = front; i != tail ; i=(i+1)%data.length) {
            res.append(data[i]);
            if ((i+1)%data.length != tail) {
                res.append(", ");
            }
        }
        res.append("]tail");
        return res.toString();
    }
    public static void main(String[] args) {
        LoopQueuePractice02<Integer> queue = new LoopQueuePractice02<>(5);
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
