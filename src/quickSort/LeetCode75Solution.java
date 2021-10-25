package quickSort;

public class LeetCode75Solution {
    public void sortColors(int[] nums) {

        //arr[0, lt] < 1; arr[lt+1, i-1] = 1; arr[gt, arr.length-1] > 1
        int lt = -1, i = 0, gt = nums.length;
        while (i < gt) {
            if (nums[i] < 1) {
                lt++;
                swap(nums, i, lt);
                i++;
            } else if (nums[i] > 1) {
                gt--;
                swap(nums, i, gt);
            } else {
                i++;
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        (new LeetCode75Solution()).sortColors(arr);
        System.out.print('[');
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if(i != arr.length-1) {
                System.out.print(", ");
            }
        }
        System.out.print(']');
    }
}
