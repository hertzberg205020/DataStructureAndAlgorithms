package selectSortImplement;

import sortTool.ArrayGenerator;
import sortTool.SortHelper;

public class SelectionSortPractice {
    private SelectionSortPractice() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        //循環不變量 arr[i...n)已排序 arr[0...i)未排序
        for (int i = arr.length - 1; i >= 0 ; i--) {
            //將合適的元素放到arr[i]
            //每一輪從未排序的區間中找出最大值，並與arr[i]交換位置
            int maxIndex = i;
            /*
            先假設索引i為最大值，遍歷未排序區域，遇到比目前最大值還要大的元素，就將該元素
            的索引設為最大值的索引
             */

            for (int j = i-1; j >= 0; j--) {
                if (arr[maxIndex].compareTo(arr[j]) < 0) {
                    maxIndex = j;
                }
            }
            swap(arr, i, maxIndex);
        }
    }
    public static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        SortHelper.sortTest("SelectionSort", arr);
    }
}
