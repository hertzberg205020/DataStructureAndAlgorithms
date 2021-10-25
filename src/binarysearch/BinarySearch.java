package binarysearch;

public class BinarySearch {
    private BinarySearch() {}
    public static int search(int[] nums, int target) {
        return search(nums, 0, nums.length-1, target);
    }

    private static int search(int[] nums, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r-l)/2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < target) {
            return search(nums, mid+1, r, target);
        }
        return search(nums, l, mid-1, target);
    }
    public static int search2(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return -1;
    }
    //尋找在一有序數組中 >target 的最小索引值

    public static<E extends Comparable<? super E>> int upper(E[] arr, E target) {
        int l = 0, r = arr.length;
        //在arr[l, r]區間尋找>target 的最小索引值
        while (l < r) {
            int mid = l + (r-l)/2;
            if (arr[mid].compareTo(target) <= 0) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return l;
    }
    // >target，返回最小索引
    // ==target，返回最大索引

    public static<E extends Comparable<? super E>> int ceil(E[] data, E target) {
        int uperIndex = BinarySearch.upper(data, target);
        if (uperIndex-1 >= 0 && data[uperIndex -1] == target) {
            return uperIndex -1;
        }
        return uperIndex;
    }

    // >= target 的最小索引
    public static<E extends Comparable<? super E>> int low_ceil(E[] data, E target) {
        int l = 0, r = data.length;
        //在arr[l, r]區間尋找>=target 的最小索引值
        while(l < r) {
            int mid = l + (r-l)/2;
            if (data[mid].compareTo(target) < 0) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    // <target的最大索引
    public static <E extends Comparable<? super E>> int lower(E[] data, E target) {
        int l = -1, r = data.length-1;

        //在data[l, r]中尋找解
        while (l < r) {
            //中間索引為上取整
            int mid = l + (r-l+1)/2;

            if (data[mid].compareTo(target) < 0) {
                l = mid;
            } else{
                r = mid-1;
            }
        }
        return l;
    }

    // <target的最大索引，=target取最小索引
    public static <E extends Comparable<? super E>> int lower_floor(E[] data, E target) {
        int lowerIndex = BinarySearch.lower(data, target);
        if (lowerIndex + 1 < data.length && data[lowerIndex+1] == target) {
            return lowerIndex+1;
        }
        return lowerIndex;
    }
    // <= target的元素其所對應的最大索引
    public static <E extends Comparable<? super E>> int upper_floor(E[] data, E target) {
        int l = -1, r = data.length-1;
        //在data[l, r]區間中尋找解
        while(l < r) {
            int mid = l + (r-l+1)/2;
            if (data[mid].compareTo(target) <= 0) {
                l = mid;
            } else {
                r = mid-1;
            }
        }
        return l;
    }
    public static<E extends Comparable<? super E>> int search3(E[] data, E target) {
        //在data[l, r] 區間中尋找 >= target的最小索引
        int l = 0, r = data.length;
        while(l < r) {
            int mid = l + (r-l)/2;
            if (data[mid].compareTo(target) < 0) {
                l = mid+1;
            } else {
                r = mid;
            }
        }

        return (l < data.length && data[l].compareTo(target) == 0) ? l : -1;
    }
    public static void main(String[] args) {

        Integer[] arr = {1, 1, 3, 3, 5, 5};
        for (int i = 0; i <= 6; i++) {
            System.out.print(upper_floor(arr, i)+" ");
        }

    }
}
