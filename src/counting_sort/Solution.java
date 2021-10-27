package counting_sort;

// LC75 採用計數排序法

public class Solution {
    public void sortColors(int[] nums) {
        int R = 3;
        int[] cnt = new int[R];
        for(int num : nums) {
            cnt[num]++;
        }
        int[] index = new int[R+1]; // nums[index[i], index[i+1]) = i, 數字i的左右區間為index[i], index[i+1]
        for(int i = 0; i < R; i++) {
            // 計算右邊界的起始位置
            index[i+1] = index[i] + cnt[i];
        }
        for(int i = 0; i + 1 < index.length; i++) {
            // [index[i], index[i+1])區間的值為i
            for(int j = index[i]; j < index[i+1]; j++) {
                nums[j] = i;
            }
        }
    }
}
