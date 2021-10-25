package heap;

import dynamicArray.Array;

public class MinHeap<E extends Comparable<? super E>> {
    private Array<E> data;
    public MinHeap(int capacity) {
        data = new Array<>(capacity);
    }
    public MinHeap() {
        data = new Array<>();
    }
    public int size() {
        return data.getSize();
    }
    public boolean isEmpty() {
        return data.isEmpty();
    }
    // 返回完全二叉樹的數組表示中，一索引所表示的元素所對應父親節點的索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have a parent!");
        }
        return (index-1)/2;
    }

    // 返回完全二叉樹的數組表示中，一索引所表示的元素的左孩子節點的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }
    // 返回完全二叉樹的數組表示中，一索引所表示的元素的右孩子節點的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }
    // 在堆中添加元素
    public void add(E e) {
        data.addLast(e);
        shiftUp(data.getSize()-1);
    }
    // 對於最小堆，父親節點 <= 子節點
    private void shiftUp(int k) {
        while(k > 0 && data.getElement(parent(k)).compareTo(data.getElement(k)) > 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }
    // 查看堆中的最小元素
    public E findMin() {
        if (isEmpty()) {
            throw new IllegalArgumentException("can not find Min in an Empty heap");
        }
        return data.getElement(0);
    }
    public E extractMin() {
        E ret = findMin();
        data.swap(0, data.getSize()-1);
        data.removeLast();
        shiftDown(0);
        return ret;
    }
    // 對於最小堆，父親節點 <= 子節點
    private void shiftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (rightChild(k) < data.getSize() &&
                    data.getElement(rightChild(k)).compareTo(data.getElement(leftChild(k))) < 0) {
                j = rightChild(k);
            }
            if (data.getElement(k).compareTo(data.getElement(j)) <= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }
    public E replace(E e) {
        E ret = findMin();
        data.setElement(0, e);
        shiftDown(0);
        return ret;
    }

}
