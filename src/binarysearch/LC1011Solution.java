package binarysearch;

import java.util.Arrays;

public class LC1011Solution {
    public int shipWithinDays(int[] weights, int days) {
        //在shipCapacity[l, r]區間中尋找解
        //Days(k) <= D的最大Days所對應的k
        int l = Arrays.stream(weights).max().getAsInt(), r = Arrays.stream(weights).sum();
        while (l < r) {
            int mid = l + (r-l)/2;
            if (days(weights, mid) <= days) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return l;
    }
    private int days(int[] weights, int shipCapacity) {
       int cur = 0, res = 0;
       for(int weight: weights) {
           if (cur + weight <= shipCapacity) {
               cur += weight;
           } else {
               res++;
               cur = weight;
           }
       }
       res++;
       return res;
    }
    private int myDays(int[] weights, int shipCapacity) {
        int days = 0;
        int count = 0;
        int i = 0;
        while (i < weights.length) {
            count += weights[i];

            if(count > shipCapacity) {
                days++;
                count = 0;
            } else if(count == shipCapacity) {
                days++;
                count = 0;
                i++;
            }else {
                i++;
            }

        }
        if (count != 0) {
            days++;
        }
        return days;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1};
        int ans = (new LC1011Solution()).myDays(arr, 3);
        System.out.println(ans);
    }
}
