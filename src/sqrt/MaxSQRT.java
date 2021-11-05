package sqrt;

import java.util.Arrays;

public class MaxSQRT {
    private int[] data, blocks;
    private int N;  // 元素總數
    private int B; // 每組元素元素個數
    private int Bn; // 組數
    public MaxSQRT(int[] nums) {
        N = nums.length;
        if(N == 0) {
            return;
        }
        B = (int)Math.sqrt(N);
        Bn = N / B + (N % B > 0 ? 1 : 0);

        data = Arrays.copyOf(nums, N);

        blocks = new int[Bn];
//        Arrays.fill(blocks, Integer.MIN_VALUE);
        for(int i = 0; i < N; i++) {
            if (i % B == 0)
                blocks[i / B] = nums[i];
            else
                blocks[i / B] = max(blocks[i / B], i);
        }
    }
    private int max(int a, int b) {
        return a >= b ? a : b;
    }

    public int maxRange(int x, int y) {
        if(x < 0 || x >= N || y < 0 || y >= N || x > y) {
            return 0;
        }
        int bStart = x / B, bEnd = y / B;

        int res = Integer.MIN_VALUE;
        if(bStart == bEnd) {
            for(int i = x; i <= y; i++) {
                res = max(res, data[i]);
            }
            return res;
        }
        for(int i = x; i < (bStart + 1) * B; i++) {
            res = max(res, data[i]);
        }
        for (int b = bStart + 1; b < bEnd; b++) {
            res = max(res, blocks[b]);
        }

        for(int i = bEnd * B; i <= y; i++) {
            res = max(res, data[i]);
        }
        return res;
    }
    public void update(int i, int val) {
        if(i < 0 || i >= N) {
            return;
        }
        int b = i / B;
        blocks[b] = Integer.MIN_VALUE;
        for(int k = b * B; k < Math.min((b + 1) * B, N); k++) {
            blocks[b] = max(blocks[b], data[i]);
        }
        data[i] = val;
    }

    public static void main(String[] args) {
        int[] nums = new int[100];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        MaxSQRT maxSQRT = new MaxSQRT(nums);
        System.out.println(maxSQRT.maxRange(51, 60));
    }
}
