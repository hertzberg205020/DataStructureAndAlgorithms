package sortTool;

import bubbleSort.BubbleSort;
import heap.HeapSort;
import insertionSortImplement.InsertionSort;
import insertionSortImplement.InsertionSortPractice;
import lsd.BucketSort;
import lsd.LSDSort;
import lsd.MSDSort;
import mergeSort.MergeSort;
import quickSort.QuickSort;
import selectSortImplement.SelectionSort;
import selectSortImplement.SelectionSortPractice;
import shellSort.ShellSort;

public class SortHelper {
    private SortHelper() {}

    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortType, E[] arr) {
        long startTime = System.nanoTime();
        if (sortType.equals("SelectionSort")) {
            SelectionSort.sort(arr);
        } else if(sortType.equals("InsertionSort")) {
            InsertionSort.sort(arr);
        } else if (sortType.equals("SelectionSortPractice")) {
            SelectionSortPractice.sort(arr);
        } else if (sortType.equals(("InsertionSortPractice"))) {
            InsertionSortPractice.sort(arr);
        } else if (sortType.equals("MergeSort")) {
            MergeSort.sort(arr);
        } else if (sortType.equals("MergeSort2")) {
            MergeSort.sort2(arr);
        } else if (sortType.equals("MergerSortBU")) {
            MergeSort.sortBU(arr);
        } else if (sortType.equals("QuickSort")) {
            QuickSort.sort(arr);
        } else if (sortType.equals("QuickSort2Ways")) {
            QuickSort.sort2Ways(arr);
        } else if (sortType.equals("QuickSort3Ways")) {
            QuickSort.sort3Ways(arr);
        } else if (sortType.equals("HeapSort")) {
            HeapSort.sort(arr);
        } else if (sortType.equals("HeapSort2")) {
            HeapSort.sort2(arr);
        } else if (sortType.equals("BubbleSort")) {
            BubbleSort.sort(arr);
        } else if (sortType.equals("BubbleSort2")) {
            BubbleSort.sort2(arr);
        } else if (sortType.equals("BubbleSort3")) {
            BubbleSort.sort3(arr);
        } else if (sortType.equals("ShellSort")) {
            ShellSort.sort(arr);
        } else if (sortType.equals("ShellSort2")) {
            ShellSort.sort2(arr);
        } else if (sortType.equals("ShellSort3")) {
            ShellSort.sort3(arr);
        } else if (sortType.equals("LSDSort")) {
            String[] strArray = (String[]) (arr);

            // 避免strArray[0]產生空指針異常
            if(strArray.length == 0) {
                throw new IllegalArgumentException("Arr can not be empty.");
            }
            LSDSort.sort(strArray, strArray[0].length());
        } else if (sortType.equals("MSDSort")) {
            String[] strArr = (String[]) arr;
            MSDSort.sort(strArr);
        } else if(sortType.equals("BucketSort")) {
            Integer[] intArr = (Integer[]) arr;
            BucketSort.sort(intArr, 200);
        }

        long endTime = System.nanoTime();
        if(!SortHelper.isSorted(arr)) {
            throw new RuntimeException(sortType + " failed");
        }
        double time = (endTime - startTime)/1000000000.0;
        System.out.println(String.format("%s, n = %d : %f s", sortType, arr.length, time));
    }
}
