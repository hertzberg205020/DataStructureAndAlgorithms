package insertionSortImplement;

import sortTool.ArrayGenerator;
import sortTool.SortHelper;

public class InsertionSortPractice {
    private InsertionSortPractice() {}
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = arr.length-1; i >= 0 ; i--) {
            //arr[0...i]未排序, arr(i...n)已排序
            E temp = arr[i];
            int j;
            //將arr[i]元素在arr(i...n)已排序區間找到合適的排序位置
            for ( j = i; j + 1< arr.length && temp.compareTo(arr[j+1]) > 0; j++) {
                arr[j] = arr[j+1];
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {

        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortHelper.sortTest("InsertionSort", arr);
        }


    }
}
