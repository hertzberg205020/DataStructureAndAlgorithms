package lsd;

import sortTool.ArrayGenerator;
import sortTool.SortHelper;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BucketSort {
    private BucketSort() {}
    public static void sort(Integer[] arr, int B) {
        if(B <= 1) {
            throw new IllegalArgumentException("B must > 1");
        }
        Integer[] temp = new Integer[arr.length];
        sort(arr, 0, arr.length - 1, B, temp);
    }
    private static void sort(Integer[] arr, int left, int right, int B, Integer[] temp) {
        if(left >= right) {
            return;
        }
        int maxV = Integer.MIN_VALUE, minV = Integer.MAX_VALUE;
        for(int i = left; i <= right; i++) {
            maxV = Math.max(maxV, arr[i]);
            minV = Math.min(minV, arr[i]);
        }
        if(maxV == minV) {
            return;
        }
        int d = (maxV - minV + 1) / B + ((maxV - minV + 1) % B > 0 ? 1 : 0);
        // 基數排序法
        int[] cnt = new int[B];
        int[] index = new int[B + 1];
        // 分桶(組)計次統計
        for(int i = left; i <= right; i++) {
            cnt[(arr[i] - minV) / d]++;
        }
        for(int i = 0; i < B; i++) {
            index[i + 1] = cnt[i] + index[i];
        }
        for(int i = left; i <= right; i++) {
            temp[index[(arr[i] - minV) / d] + left] = arr[i];
            index[(arr[i] - minV) / d]++;
        }
        for(int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
        sort(arr, left, left + index[0] - 1, B, temp);
        for(int i = 0; i < B - 1; i++) {
            sort(arr, left + index[i], left + index[i + 1] - 1, B, temp);
        }
    }

    public static void sort2(Integer[] arr, int c) {
        if(c <= 0) {
            throw new IllegalArgumentException("c must be > 0");
        }
        int maxV = Integer.MIN_VALUE, minV = Integer.MAX_VALUE;
        for(int e : arr) {
            maxV = Math.max(maxV, e);
            minV = Math.min(minV, e);
        }
        int range = maxV - minV + 1;
        int B = range / c + (range % c > 0 ? 1 : 0);

        LinkedList<Integer>[] buckets = new LinkedList[B];
        for(int i = 0; i < B; i++) {
            buckets[i] = new LinkedList<>();
        }
        for(int e : arr) {
            buckets[(e - minV) / c].add(e);
        }
        for(int i = 0; i < B; i++) {
            // O(n^2)級別的排序算法
            Collections.sort(buckets[i]);
        }
        int index = 0;
        for(int i = 0; i < B; i++) {
            for(int e : buckets[i]) {
                arr[index++] = e;
            }
        }
    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        SortHelper.sortTest("BucketSort", arr);
        SortHelper.sortTest("BucketSort2", arr2);
    }
}
