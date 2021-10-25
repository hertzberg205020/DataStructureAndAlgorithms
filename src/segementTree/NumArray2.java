package segementTree;

public class NumArray2 {
    private int[] sum;
    // sum[i]存儲前i個元素和, sum[0] = 0
    // 即sum[i]存儲nums[0...i-1]的和
    // sumRange(i, j) = sum[j+1] - sum[i]
    public NumArray2(int[] nums) {
        sum = new int[nums.length+1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
    }
    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }
}
