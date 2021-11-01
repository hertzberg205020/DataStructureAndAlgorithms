package sortTool;

import java.util.Random;

//創造測試用陣列
public class ArrayGenerator {
    private ArrayGenerator() {

    }

    public static Integer[] generateOrderArray(int n) {
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        return array;
    }
    // 生成一個長度為n的隨機陣列，每個數字的取值範圍是[0, bound)
    public static Integer[] generateRandomArray(int n, int bound) {
        Integer[] arr = new Integer[n];
        Random rdm = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rdm.nextInt(bound);
        }
        return arr;
    }
    public static  Integer[] generateSpecialArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        generateSpecialArray(arr, 0, arr.length-1);
        return arr;
    }

    private static void generateSpecialArray(Integer[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l+(r-l)/2;
        swap(arr, l, mid);
        generateSpecialArray(arr, l+1, r);

    }
    public static Integer[] generateSpecialArray2(int n) {
        Integer[] data = generateOrderArray(n);
        //[i+1, length-1]區間中的mid維持最小值
        for (int i = data.length - 2; i >= 0; i--) {
            int mid = i + (data.length - 1 - i) / 2;
            swap(data, i, mid);
        }
        return data;
    }
    public static String[] generateRandomStringArray(int n, int w) {
        // https://www.ascii-code.com/
        // 33-126 可打印字元
        String[] arr = new String[n];
        Random rnd = new Random();
        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < w; j++) {
                char c = (char) (rnd.nextInt(126 - 33 + 1) + 33);
                sb.append(c);
            }
            arr[i] = sb.toString();
        }
        return arr;
    }


    private static<E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
