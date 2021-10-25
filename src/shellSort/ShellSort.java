package shellSort;

import sortTool.ArrayGenerator;
import sortTool.SortHelper;

import java.util.Arrays;

public class ShellSort {
    private ShellSort() {}
    // 希爾排序法的核心思想，一輪一輪的執行插入排序法，每一輪插入排序的對象是將原數組分解成多個子數組，
    // 每個子數組元素之間有一定的間隔，最後一輪是對元素間隔為1的數組進行插入排序，亦是整個數組進行插入排序，
    // 過程中數組會逐漸變得越來越有序，使得每一輪的shellSort會越來越快
    public static<E extends Comparable<? super E>> void sort(E[] data) {
        // 每個子數組數據元素之間的間隔為h，初始值為data.length/2
        int h = data.length/2;
        while (h >= 1) {
            // 將data分解成若干個子數組，並對子數組進行插入排序

            // 循環遍歷每個子數組的起始元素
            // start為每個子數組起始元素相對應的索引
            for(int start = 0; start < h; start++) {
                // 每個start都對應到一個子數組
                // 每輪僅對一個子數組序列進行排序
                // 對以start為起始，間隔為h的子數組進行插入排序，子數組的個數為h個
                // 對data[start, start+h, start+2h, start+3h, ...] 子數組進行排序
                for(int i = start + h; i < data.length; i += h) {
                    E temp = data[i];
                    // j為要插入的索引位置
                    int j;
                    for (j = i; j-h >= 0 && temp.compareTo(data[j-h]) < 0; j -= h) {
                        data[j] = data[j-h];
                    }
                    data[j] = temp;
                }
            }
            h /= 2;
        }

    }
    public static<E extends Comparable<? super E>> void sort2(E[] data) {
        // 每個子數組數據元素之間的間隔為h，初始值為data.length/2
        int h = data.length/2;
        while (h >= 1) {

            // 對data[h, data.length)，進行插入排序
            for(int i = h; i < data.length; i++) {
                E temp = data[i];
                // j為要插入的索引位置
                int j;
                for (j = i; j-h >= 0 && temp.compareTo(data[j-h]) < 0; j -= h) {
                    data[j] = data[j-h];
                }
                data[j] = temp;
            }

            h /= 2;
        }

    }
    public static<E extends Comparable<? super E>> void sort3(E[] data) {
        // 使用不同的步常序列實現shellSort
        // 步長序列為shellSort的超參數
        // 必須要決定超參數，才能具體定義/實現算法
        int h = 1;
        while (h < data.length) {
            h = 3 * h + 1;
        }
        // h = 1, 2, 4, 8...
        // h = 1, 4, 13, 40...
        while (h >= 1) {

            // 對data[h, data.length)，進行插入排序
            for(int i = h; i < data.length; i++) {
                E temp = data[i];
                // j為要插入的索引位置
                int j;
                for (j = i; j-h >= 0 && temp.compareTo(data[j-h]) < 0; j -= h) {
                    data[j] = data[j-h];
                }
                data[j] = temp;
            }

            h /= 3;
        }

    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        Integer[] arr4 = Arrays.copyOf(arr, arr.length);
        Integer[] arr5 = Arrays.copyOf(arr, arr.length);

        SortHelper.sortTest("MergeSort", arr);
        SortHelper.sortTest("ShellSort", arr2);
        SortHelper.sortTest("ShellSort2", arr3);
        SortHelper.sortTest("ShellSort3", arr4);
        SortHelper.sortTest("QuickSort", arr5);
    }
}
