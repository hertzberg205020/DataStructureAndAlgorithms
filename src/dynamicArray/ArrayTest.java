package dynamicArray;

public class ArrayTest <E> {
    private E[] data;
    private int size;

    public ArrayTest(int capacity) {
        data = (E[]) new Object[capacity];
    }
    public ArrayTest() {
        this(10);
    }
    public int getCapacity() {
        return data.length;
    }
    public int getSize() {
        return this.size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index > 0 && index <= size.");
        }
        if (size == data.length) {
            resize(data.length * 2);
        }
        for(int i = size; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = e;
        size++;
    }
    private void resize(int newcapacity) {
        E[] newData = (E[]) new Object[newcapacity];
        for(int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size:%d, capacity:%d\n", size, data.length));
        res.append('[');
        for(int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size-1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
    public static void main(String[] args) {
        ArrayTest<Integer> arr = new ArrayTest<>();
        //arr.add(0, 1);
        //arr.add(1, 2);
        System.out.println(arr);
    }
}
