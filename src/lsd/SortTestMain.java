package lsd;

import sortTool.ArrayGenerator;
import sortTool.SortHelper;

import java.util.Arrays;

public class SortTestMain {
    public static void main(String[] args) {
        int n = 100000, w = 20;
        String[] strArr = ArrayGenerator.generateRandomStringArray(n, w);
        String[] strArr2 = Arrays.copyOf(strArr, strArr.length);
        String[] strArr3 = Arrays.copyOf(strArr, strArr.length);

        SortHelper.sortTest("QuickSort", strArr);
        SortHelper.sortTest("QuickSort3Ways", strArr2);
        SortHelper.sortTest("MSDSort", strArr3);
    }
}
