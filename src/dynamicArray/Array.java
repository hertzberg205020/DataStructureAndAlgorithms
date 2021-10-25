package dynamicArray;

public class Array<E> {
    private int size = 0; //可以不用賦值，默認值為0
    private E[] data;

    public Array() {
        this(10);
    }

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
    }

    //取得陣列容量
    public int getCapacity() {
        return data.length;
    }

    //取得陣列中元素個數
    public  int getSize() {
        return size;
    }

    //返回陣列是否為空
    public boolean isEmpty() {
        return size == 0;
    }

    //在index索引的位置插入一個新元素e
    public void add(int index, E e) {
        //先判對索引是否合法
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size");
        }
        //陣列大小不足需要擴容
        if(size == data.length) {
            reSize(data.length * 2);
        }
        //平移data[index...size)區間的元素至data[index+1...size]
        for (int i = size; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = e;
        size++;
    }

    private void reSize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    //在所有元素末尾添加新元素
    public  void addLast(E e) {
        add(size, e);
    }
    //在所有元素前添加新元素
    public  void addFirst(E e) {
        add(0, e);
    }

    //獲取index索引位置的元素
    public E getElement(int index) {
        //先判斷索引是否合法
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }
    public E getLastElement() {
        return getElement(size-1);
    }

    public E getFirstElement() {
        return getElement(0);
    }

    //修改index索引位置的元素為e
    public void setElement(int index, E e) {
        //先判斷索引是否合法
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("SetElement failed. Index id illegal.");
        }
        data[index] = e;
    }
    //查找陣列中是否有元素e
    public boolean containsElement(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }
    //查找陣列中元素e的索引值，若元素e不存在，則返回-1
    public int searchElement(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }
    //從陣列中移除index索引位置的元素，返回刪除的元素
    public E remove(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal");
        }
        E ret = data[index];
        for (int i = index+1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        data[size] = null; // loitering objects != memory leak
        if (size == data.length/4) {
            reSize(data.length/2);
        }
        return ret;
    }

    //移除陣列中首個元素，並返回移除的元素
    public E removeFirst() {
        return remove(0);
    }

    //移除陣列中最後一個元素，並返回移除的元素
    public E removeLast() {
        return remove(size-1);
    }

    //重陣列中刪除元素e
    public void removeElement(E e) {
        int targetIndex = this.searchElement(e);
        if (targetIndex != -1) {
            remove(targetIndex);
        }
    }
    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size: %d, capacity: %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size-1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

}
