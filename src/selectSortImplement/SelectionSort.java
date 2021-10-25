package selectSortImplement;

import sortTool.ArrayGenerator;
import sortTool.SortHelper;

public class SelectionSort {
    private SelectionSort() {

    }
    public static <E extends Comparable<E>> void sort(E[] array) {

        int minIndex;
        //循環不變量: array[i...n)未排序，array[0...i)已排序
        for (int i = 0; i < array.length; i++) {
            //array[i...n)中最小值要放到array[i]的位置
            minIndex = i;
            //找出array[i...n)中最小值的索引號
            for (int j = i; j < array.length; j++) {
                //若array[minIndex]大於array[j] 返回值大於0
                if(array[minIndex].compareTo(array[j]) > 0) {
                    minIndex = j;
                }
            }
            if(minIndex != i) {
               swap(array, i, minIndex);
            }
        }
    }

    public static <E> void swap(E[] array, int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortHelper.sortTest("SelectionSort", arr);
        }

    }
}
