package bubbleSort;

import sortTool.ArrayGenerator;
import sortTool.SortHelper;

import java.util.Arrays;

public class BubbleSort {
    private BubbleSort() {}
    public static<E extends Comparable<? super E>> void sort(E[] data) {
        for (int i = 0; i < data.length-1; i++) {
            // arr[n-i, n)已完成排序
            // 通過冒泡排序在arr[n-i-1]位置上放上適合的元素
            for (int j = 0; j < data.length-i-1; j++) {
                if (data[j].compareTo(data[j+1]) > 0) {
                    swap(data, j, j+1);
                }
            }
        }
    }

    public static<E extends Comparable<? super E>> void sort2(E[] data) {
        for (int i = 0; i < data.length-1; i++) {
            // arr[n-i, n)已完成排序
            // 通過冒泡排序在arr[n-i-1]位置上放上適合的元素
            boolean isSwapped = false;
            for (int j = 0; j < data.length-i-1; j++) {
                if (data[j].compareTo(data[j+1]) > 0) {
                    swap(data, j, j+1);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
    }

    public static<E extends Comparable<? super E>> void sort3(E[] data) {
        for (int i = 0; i < data.length-1;) {
            // arr[n-i, n)已完成排序，共i個元素排好序
            // 通過冒泡排序在arr[n-i-1]位置上放上適合的元素
            int lastSwappedIndex = 0;
            for (int j = 0; j < data.length-i-1; j++) {
                if (data[j].compareTo(data[j+1]) > 0) {
                    swap(data, j, j+1);
                    lastSwappedIndex = j+1;
                }
            }
            // 從最後一次交換元素的索引一直到末尾元素皆已是排序狀態
            i = data.length-lastSwappedIndex;
        }
    }

    private static<E> void swap(E[] data, int j, int i) {
        E temp = data[j];
        data[j] = data[i];
        data[i] = temp;
    }

    public static void main(String[] args) {
        int n = 10000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        System.out.println("Random Array");
        SortHelper.sortTest("BubbleSort", arr);
        SortHelper.sortTest("BubbleSort2", arr2);
        SortHelper.sortTest("BubbleSort3", arr3);
        System.out.println();

        System.out.println("Ordered Array");
        arr = ArrayGenerator.generateOrderArray(n);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);
        SortHelper.sortTest("BubbleSort", arr);
        SortHelper.sortTest("BubbleSort2", arr2);
        SortHelper.sortTest("BubbleSort3", arr3);
        System.out.println();

    }
}
