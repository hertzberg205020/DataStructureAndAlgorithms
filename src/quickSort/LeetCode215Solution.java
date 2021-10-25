package quickSort;

import java.util.Random;

public class LeetCode215Solution {
    public int findKthLargestR(int[] nums, int k) {
        Random rnd = new Random();
        return selectKR(nums, 0, nums.length-1, nums.length-k, rnd);
    }
    private int findKthLargest(int[] nums, int l, int r, int targetIndex, Random rnd) {

        int p = rnd.nextInt(r-l+1) + l;
        swap(nums, p, l);
        //nums[l+1, lt] < v; nums[lt+1, i-1] = v; nums[gt, r] > v
        int lt = l, i = l+1, gt = r+1;
        while (i < gt) {
            if (nums[i] < nums[l]) {
                lt++;
                swap(nums, lt, i);
                i++;
            } else if (nums[i] > nums[l]) {
                gt--;
                swap(nums, i, gt);
            } else {
                i++;
            }
        }
        swap(nums, l, lt);
        // nums[l, lt-1] < v; nums[lt, gt-1] == v; nums[gt, r] > v;
        if (lt <= targetIndex && gt-1 >= targetIndex) {
            return nums[targetIndex];
        } else if (targetIndex > gt-1) {
            return findKthLargest(nums, gt, r, targetIndex, rnd);
        } else {
            return findKthLargest(nums, l, lt-1, targetIndex, rnd);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private int selectKR(int[] nums, int l, int r, int k, Random rnd) {
        int p = partition2(nums, l, r, rnd);
        if (p == k) {
            return nums[k];
        }
        if (p < k) {
            return selectKR(nums, p+1, r, k, rnd);
        }
        return selectKR(nums, l, p-1, k, rnd);
    }


    private int selectK(int[] nums, int k, Random rnd) {
        int l = 0;
        int r = nums.length-1;
        while (l < r) {
            int p = partition2(nums, l, r, rnd);
            if (p == k)
                return nums[p];
            if (p < k) {
                l = p + 1;
            } else {
                r = p - 1;
            }
        }
        return -1;
        //throw new RuntimeException("No solution");
    }

    //在arr[l,r)的範圍中尋找第k小的元素，k最小是0
    private int selectK2(int[] nums, int k, Random rnd) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int p = partition(nums, l, r, rnd);
            if(p == k) {
                return nums[p];
            }
            if (p < k) {
                l = p+1;
            } else {
                r = p;
            }
        }
        return -1;
        //throw new RuntimeException("No solution");
    }
    private int partition(int[] nums, int l, int r, Random rnd) {
        int p = rnd.nextInt(r-l) + l;
        swap(nums, l, p);
        //nums[l+1, i-1] <= v ; nums[j+1, r) >= v
        int i = l+1, j = r-1;
        while (true) {
            //擴張小於標定點的區段
            while (i <= j && nums[i] < nums[l]) {
                i++;
            }
            //擴張大於標定點的區間
            while (i <= j && nums[j] > nums[l]) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, j, l);
        return j;
    }


    private int partition2(int[] nums, int l, int r, Random rnd) {
        int p = rnd.nextInt(r-l+1) + l;
        swap(nums, l, p);
        //nums[l+1, i-1] <= v ; nums[j+1, r] >= v
        int i = l+1, j = r;
        while (true) {
            //擴張小於標定點的區段
            while (i <= j && nums[i] < nums[l]) {
                i++;
            }
            //擴張大於標定點的區間
            while (i <= j && nums[j] > nums[l]) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, j, l);
        return j;
    }

}
