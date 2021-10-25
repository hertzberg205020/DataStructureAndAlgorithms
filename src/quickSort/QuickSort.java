package quickSort;

import insertionSortImplement.InsertionSort;
import sortTool.ArrayGenerator;
import sortTool.SortHelper;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    private QuickSort() {}
    public static<E extends Comparable<E>> void sort(E[] arr) {
        Random rnd = new Random();
        int n = arr.length;
        sort(arr, 0, n-1, rnd);
    }
    private static<E extends Comparable<E>> void sort(E[] arr, int l, int r, Random rnd) {
        if (r-l <= 7) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r, rnd);
        sort(arr, l, p-1, rnd);
        sort(arr, p+1, r, rnd);
    }

    private static<E extends Comparable<E>> int partition(E[] arr, int l, int r, Random rnd) {
        //arr[l, r] [l, r]->[0, r-l]
        int p = rnd.nextInt(r-l+1) + l;
        swap(arr, l, p);
        //arr[l+1, j] < arr[l], arr[j+1, i-1] > arr[l]
        int j = l;
        for (int i = l+1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                swap(arr, j, i);
            }
        }
        swap(arr, l, j);
        return j;
    }
    public static<E extends Comparable<E>> void sortMid(E[] arr) {
        int n = arr.length;
        sortMid(arr, 0, n-1);
    }
    private static<E extends Comparable<E>> void sortMid(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partitionMid(arr, l, r);
        sortMid(arr, l, p-1);
        sortMid(arr, p+1, r);
    }
    private static<E extends Comparable<E>> int partitionMid(E[] arr, int l, int r) {

        swap(arr, l, l+(r-l)/2);
        //arr[l+1, j] < arr[l], arr[j+1, i-1] > arr[l]
        int j = l;
        for (int i = l+1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                swap(arr, j, i);
            }
        }
        swap(arr, l, j);
        return j;
    }
    public static<E extends Comparable<E>> void sort2Ways(E[] arr) {
        Random rnd = new Random();
        int n = arr.length;
        sort2Ways(arr, 0, n-1, rnd);
    }
    private static<E extends Comparable<E>> void sort2Ways(E[] arr, int l, int r, Random rnd) {
        if (r-l <= 7) {
            InsertionSort.sort(arr, l, r);
            return;
        }
        int p = partition2(arr, l, r, rnd);
        sort(arr, l, p-1, rnd);
        sort(arr, p+1, r, rnd);
    }

    private static<E extends Comparable<E>> int partition2(E[] arr, int l, int r, Random rnd) {
        //arr[l, r] [l, r]->[0, r-l]
        int p = rnd.nextInt(r-l+1) + l;
        swap(arr, l, p);
        //arr[l+1, i-1] <= v  arr[j+1, r] >= v
        int i = l+1, j = r;
        while(true) {
            while(i <= j && arr[i].compareTo(arr[l]) < 0) {
                //向前探索未迭代的區間
                i++;
            }
            while (i <= j && arr[j].compareTo(arr[l]) > 0) {
                //向後探索未迭代的區間
                j--;
            }
            if(i >= j) {
                break;
            }
            swap(arr, i, j);
            //交換完，要記得繼續迭代未判斷的區間
            i++;
            j--;
        }
        //迭代循環結束時，索引j指向小於v區間中的末尾元素
        swap(arr, l, j);
        return j;
    }

    public static<E extends Comparable<E>> void sort3Ways(E[] arr) {
        Random rnd = new Random();
        sort3Ways(arr, 0, arr.length-1, rnd);
    }
    private static <E extends Comparable<E>> void sort3Ways(E[] arr, int l, int r, Random rnd) {
        if (l >= r) {
            return;
        }
        int p = l + rnd.nextInt(r-l+1);
        swap(arr, l, p);

        // arr[l+1, lt] < v; arr[lt+1, i-1] = v; arr[gt, r] > v
        int lt = l, gt = r + 1, i = l+1;
        while(i < gt) {
            if (arr[i].compareTo(arr[l]) < 0) {
                lt++;
                swap(arr, lt, i);
                i++;
            } else if (arr[i].compareTo(arr[l]) > 0) {
                gt--;
                swap(arr, gt, i);
            } else {
                i++;
            }
        }
        swap(arr, lt, l);
        //arr[l, lt-1] < v; arr[lt, gt-1] = v; arr[gt, r] > v
        sort3Ways(arr, l, lt-1, rnd);
        sort3Ways(arr, gt, r, rnd);
    }

    private static<E> void swap(E[] arr, int j, int i) {
        E temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
//        int n = 5000;
//        Integer[] arr = ArrayGenerator.generateSpecialArray(n);
//        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
//        SortHelper.sortTest("QuickSort", arr);
//        SortHelper.sortTest("QuickSort3", arr);
        int n = 0;
        while(n*n < 25) {
            n++;
        }
        System.out.println(n);
    }
}
