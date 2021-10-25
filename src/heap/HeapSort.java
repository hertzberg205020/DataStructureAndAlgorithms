package heap;

import sortTool.ArrayGenerator;
import sortTool.SortHelper;

import java.util.Arrays;

public class HeapSort{
    private HeapSort() {}
    public static<E extends Comparable<? super E>> void sort(E[] data) {
        MaxHeap<E> maxHeap = new MaxHeap<>();
        for(E e : data) {
            maxHeap.add(e);
        }
        for(int i = data.length-1; i >= 0; i--) {
            data[i] = maxHeap.extractMax();
        }
    }

    public static<E extends Comparable<? super E>> void sort2(E[] data) {
        if (data.length <= 1) {
            return;
        }
        // 將數組整理成堆的結構
        // data.length-1為末尾元素
        // parentIndex = (index-1)/2
        for (int i = ((data.length-1)-1)/2; i >= 0; i--) {
            shiftDown(data, i, data.length);
        }
        for(int i = data.length-1; i >= 0; i--) {
            swap(data, 0, i);
            shiftDown(data, 0, i);
        }
    }

    // 對data[0, n)所形成的完全二叉樹中，索引k的元素，執行shiftDown
    private static<E extends Comparable<? super E>> void shiftDown(E[] data, int k, int n) {
        int leftChildIndex = 2*k+1;
        int rightChildIndex = 2*k+2;
        while(leftChildIndex < n) {
            int largerChildIndex = leftChildIndex;
            if (rightChildIndex < n && data[leftChildIndex].compareTo(data[rightChildIndex]) < 0) {
                largerChildIndex = rightChildIndex;
            }
            if(data[k].compareTo(data[largerChildIndex]) >= 0) {
                break;
            }
            swap(data, k, largerChildIndex);

            k = largerChildIndex;
            leftChildIndex = 2*k +1;
            rightChildIndex = 2*k +2;
        }

    }

    private static<E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        Integer[] arr4 = Arrays.copyOf(arr, arr.length);
        Integer[] arr5 = Arrays.copyOf(arr, arr.length);

        SortHelper.sortTest("MergeSort", arr);
        SortHelper.sortTest("QuickSort2Ways", arr2);
        SortHelper.sortTest("QuickSort3Ways", arr3);
        SortHelper.sortTest("HeapSort", arr);
        SortHelper.sortTest("HeapSort2", arr5);
    }
}
