package heap;

import dynamicArray.Array;

public class MaxHeap<E extends Comparable<? super E>> {
    private Array<E> data;
    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }
    public MaxHeap() {
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
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
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

    private void shiftUp(int k) {
        // 檢查索引k是否滿足堆的性質，每個節點元素 >= 所有的孩子節點中的元素
        while(k > 0 && data.getElement(k).compareTo(data.getElement(parent(k))) > 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    // 查看堆中的最大元素
    public E findMax() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Can not find Max in an empty heap.");
        }
        return data.getElement(0);
    }

    // 取出堆中的最大元素
    public E extractMax() {
        E ret = findMax();

        data.swap(0, data.getSize()-1);
        data.removeLast();
        shiftDown(0);

        return ret;
    }

    private void shiftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            // 每輪循環中，data[k]與data[j]交換位置
            // data[j]為leftChild與rightChild中的最大值
            int j = leftChild(k);

            if (rightChild(k) < data.getSize() &&
                    data.getElement(rightChild(k)).compareTo(data.getElement(leftChild(k))) > 0) {
                j = rightChild(k);
            }
            if (data.getElement(k).compareTo(data.getElement(j)) >= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }

    }
}
