package lsd;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class LC164Solution {
    // 練習使用桶排序
    public static void bucketSort(int[] arr, int c) {
        if(c <= 0) {
            throw new IllegalArgumentException("c must be > 0.");
        }
        int maxV = Integer.MIN_VALUE, minV = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) {
            maxV = Math.max(maxV, arr[i]);
            minV = Math.min(minV, arr[i]);
        }
        if(maxV == minV) {
            return;
        }

        int range = (maxV - minV) + 1;
        int B = range / c + (range % c > 0 ? 1 : 0);

        LinkedList<Integer>[] buckets = new LinkedList[B];
        for(int i = 0; i < B; i++) {
            buckets[i] = new LinkedList<>();
        }
        for(int e : arr) {
            buckets[(e - minV) / c].add(e);
        }
        for(int i = 0; i < B; i++) {
            Collections.sort(buckets[i]);
        }
        int index = 0;
        for(int i = 0; i < B; i++) {
            for(int e : buckets[i]) {
                arr[index++] = e;
            }
        }
    }
    public int maximumGap(int[] nums) {
        int B = nums.length;
        int minV = Integer.MAX_VALUE, maxV = Integer.MIN_VALUE;
        for(int e : nums) {
            minV = Math.min(minV, e);
            maxV = Math.max(maxV, e);
        }
        if(maxV == minV) {
            return 0;
        }
        int range = (maxV - minV) + 1;
        int c = range / B + (range % B > 0 ? 1 : 0);
        bucketSort(nums, c);
        int maxInterval = 0;
        for(int i = 0; i + 1 < nums.length; i++) {
            if(maxInterval < (nums[i + 1] - nums[i])) {
                maxInterval = nums[i + 1] - nums[i];
            }
        }
        return maxInterval;
    }
    // 高手解法
    public int maximumGap2(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        //找出最大值、最小值
        for (int i = 1; i < n; i++) {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        if(max - min == 0) {
            return 0;
        }

        //算出每个箱子的范围
        int interval = (int) Math.ceil((double)(max - min) / (n - 1));

        //每个箱子里数字的最小值和最大值
        int[] bucketMin = new int[n - 1];
        int[] bucketMax = new int[n - 1];

        //最小值初始为 Integer.MAX_VALUE
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        //最小值初始化为 -1，因为题目告诉我们所有数字是非负数
        Arrays.fill(bucketMax, -1);

        //考虑每个数字
        for (int i = 0; i < nums.length; i++) {
            //当前数字所在箱子编号
            int index = (nums[i] - min) / interval;
            //最大数和最小数不需要考虑
            if(nums[i] == min || nums[i] == max) {
                continue;
            }
            //更新当前数字所在箱子的最小值和最大值
            bucketMin[index] = Math.min(nums[i], bucketMin[index]);
            bucketMax[index] = Math.max(nums[i], bucketMax[index]);
        }

        int maxGap = 0;
        //min 看做第 -1 个箱子的最大值
        int previousMax = min;
        //从第 0 个箱子开始计算
        for (int i = 0; i < n - 1; i++) {
            //最大值是 -1 说明箱子中没有数字，直接跳过
            if (bucketMax[i] == -1) {
                continue;
            }

            //当前箱子的最小值减去前一个箱子的最大值
            maxGap = Math.max(bucketMin[i] - previousMax, maxGap);
            previousMax = bucketMax[i];
        }
        //最大值可能处于边界，不在箱子中，需要单独考虑
        maxGap = Math.max(max - previousMax, maxGap);
        return maxGap;

    }

}
