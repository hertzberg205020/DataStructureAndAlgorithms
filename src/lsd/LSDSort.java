package lsd;

import java.util.Arrays;

public class LSDSort {
    private LSDSort() {}
    public static void sort(String[] arr, int W) {
        for(String s : arr) {
            if(s.length() != W) {
                throw new IllegalArgumentException("All the length of string must be the same.");
            }
        }

        int R = 256; // ascii
        int[] cnt = new int[R]; // 字元頻率計數
        int[] index = new int[R + 1]; // 分組區間
        String[] temp = new String[arr.length]; // 暫存陣列

        // O(W * (n + R)) => O(n)
        for(int r = W - 1; r >= 0; r--) {
            // 統計次數歸零
            // O(n)
            Arrays.fill(cnt, 0);
            for(String s : arr) {
                cnt[s.charAt(r)]++;
            }
            // O(R)
            for(int i = 0; i < R; i++) {
                index[i+1] = index[i] + cnt[i];
            }
            // O(n)
            for(String s : arr) {
                temp[index[s.charAt(r)]] = s;
                index[s.charAt(r)]++;
            }
            // O(n)
            for(int i = 0; i < arr.length; i++) {
                arr[i] = temp[i];
            }
        }
    }

    public static void main(String[] args) {

        String[] arr = {"BCA", "CAB", "ACB", "BAC", "ABC", "CBA"};
        LSDSort.sort(arr, 3);
        for(String s: arr)
            System.out.println(s);
    }
}
