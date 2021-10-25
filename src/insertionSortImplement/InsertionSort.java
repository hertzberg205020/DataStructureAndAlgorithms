package insertionSortImplement;

import sortTool.ArrayGenerator;
import sortTool.SortHelper;

public class InsertionSort {
    private InsertionSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        //迴圈不變量: array[0...i)區間元素已排序，arr[i...n)未排序
        for (int i = 0; i < arr.length; i++) {
            E temp = arr[i];
            int j;
            //在array[i...n)中依大小順序安插在合適的位置
            for (j = i; j - 1 >= 0 && temp.compareTo(arr[j-1]) < 0; j--) {
                    /*
                      若arr[j]>arr[j-1]，表示已找到目前合適的位置完成排序，這是因為
                      array(0...i]區間已完成排序，所以也不需要在與往前方元素比較，前方
                      元素已是排序好的狀態且必定比arr[j]小
                    */
                //交換涉及到3個步驟，賦值僅一個步驟，可降低常數項級別的複雜度
                arr[j] = arr[j-1];
                //swap(arr,j, j-1);
            }
            arr[j] = temp;
        }
    }
    public static<E extends Comparable<E>> void sort(E[] arr, int start, int end) {
        for (int i = start; i <= end ; i++) {
            E temp = arr[i];
            int j;
            for ( j = i; j-1 >= start &&(temp.compareTo(arr[j-1]) < 0) ; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
//        int[] dataSize = {10000, 100000};
//        for(int n : dataSize) {
//            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
//            SortHelper.sortTest("InsertionSort", arr);
//        }
        Integer[] arr2 = {4, 0, 7, 1, 5, 9, 3, 2, 6, 8};
        sort(arr2, 0, arr2.length-1);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]);
            if (i != arr2.length-1) {
                System.out.print(", ");
            }
        }
    }
}
