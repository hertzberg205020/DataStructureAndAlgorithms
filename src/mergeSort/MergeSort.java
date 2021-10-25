package mergeSort;

import insertionSortImplement.InsertionSort;
import sortTool.ArrayGenerator;
import sortTool.SortHelper;

import java.util.Arrays;

public class MergeSort {
    private MergeSort() {}
    public static<E extends Comparable<E>> void sort(E[] arr) {
        //sort(arr, 0, arr.length-1, 0);
        sort(arr, 0, arr.length-1);
    }

    private static<E extends Comparable<E>> void sort(E[] arr, int start, int end, int depth) {
//        if (end - start <= 16) {
//            InsertionSort.sort(arr, start, end);
//            return;
//        }
        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println(String.format("mergesort arr[%d, %d]", start, end));
        if (end <= start) {
            return;
        }
        int mid = start + (end - start)/2;

        sort(arr, start, mid, depth+1);

        sort(arr, mid+1, end, depth+1);
        System.out.print(depthString);
        System.out.println(String.format("merge arr[%d, %d] and arr[%d, %d]", start, mid, mid + 1, end));
        merge(arr, start, mid, end);
        System.out.print(depthString);
        System.out.print(String.format("after mergesort arr[%d, %d] :", start, end));
        String arrString = generateArrString(arr);
        System.out.println(arrString);
    }
    private static<E extends Comparable<E>> void sort(E[] arr, int start, int end) {
        if (end <= start) {
            return;
        }
        int mid = start + (end - start)/2;

        sort(arr, start, mid);
        sort(arr, mid+1, end);
        merge(arr, start, mid, end);
    }

    private static<E> String generateArrString(E[] arr) {
        StringBuilder res = new StringBuilder();
        res.append('{');
        for (int i = 0; i < arr.length; i++) {
            res.append(arr[i]);
            if (i != arr.length-1) {
                res.append(", ");
            }
        }
        res.append('}');
        return res.toString();
    }

    private static String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        if (depth != 0) {
            res.append(String.format("%2d", depth));
        }
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    private static<E extends Comparable<E>> void merge(E[] arr, int start, int mid, int end) {
        E[] temp = Arrays.copyOfRange(arr, start, end+1);
        int i = start;
        int j = mid+1;
        for (int k = start; k <= end; k++) {
            if (i > mid) {
                arr[k] = temp[j-start];
                j++;
            }
            else if (j > end) {
                arr[k] = temp[i - start];
                i++;
            }
            else if (temp[i-start].compareTo(temp[j-start]) <= 0) {
                arr[k] = temp[i-start];
                i++;
            }
            else {
                arr[k] = temp[j-start];
                j++;
            }
        }
    }
    public static<E extends Comparable<E>> void sort2(E[] arr) {
        //E[] temp = (E[]) new Object[arr.length]; 會類型轉換異常，因為不是每個Object 都是可比較的
        E[] temp = (E[]) new Comparable[arr.length];
        sort2(arr, 0, arr.length-1, temp);
    }

    private static<E extends Comparable<E>> void sort2(E[] arr, int start, int end, E[] temp) {
        if (end - start <= 16) {
            InsertionSort.sort(arr, start, end);
            return;
        }

        if (start >= end) {
            return;
        }
        int mid = start + (end - start)/2;
        sort2(arr, start, mid, temp);
        sort2(arr, mid+1, end, temp);
        if (arr[mid].compareTo(arr[mid+1]) > 0) {
            merge2(arr, start, mid, end, temp);
        }

    }
    public static<E extends Comparable<E>> void sortBU(E[] arr) {
        E[] temp = (E[]) new Comparable[arr.length];
        int n = arr.length;
        for (int i = 0; i < n; i += 16) {
            InsertionSort.sort(arr, i, Math.min(i+15, n-1));
        }

        //遍歷要被合併的那2個區間的長度
        //例如: 將區間長度為2的二個區域，合併為一個區間長度為4的區域
        for (int sz = 16; sz < n; sz += sz) {
            //循環不變量:陣列中以size長度為間隔將陣列劃分為若干區域，每個區域內的元素皆已完成排序
            //遍歷要被合併的2個區間長度的起始位置
            //合併[i, i+size-1]和[i+size, Math.min(i+size+size-1, n-1)]
            for(int i = 0; i + sz < n; i+= sz+sz) {
                if (arr[i+sz-1].compareTo(arr[i+sz]) > 0) {
                    merge2(arr, i, i+sz-1, Math.min((i+sz+sz-1), n-1), temp);
                }
            }
        }
    }

    private static<E extends Comparable<E>> void merge2(E[] arr, int start, int mid, int end, E[] temp) {
        System.arraycopy(arr, start, temp, start, end - start + 1);
        int i = start;
        int j = mid+1;
        for (int k = start; k <= end; k++) {
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            }
            else if (j > end) {
                arr[k] = temp[i];
                i++;
            }
            else if (temp[i].compareTo(temp[j]) <= 0) {
                arr[k] = temp[i];
                i++;
            }
            else {
                arr[k] = temp[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOfRange(arr, 0, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        SortHelper.sortTest("MergeSort", arr);
        SortHelper.sortTest("MergeSort2", arr2);
        SortHelper.sortTest("MergerSortBU", arr3);
        
       

    }
}
