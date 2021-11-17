package java_coding_question;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LC349Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int n : nums1){
            set.add(n);
        }
        for(int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])) {
                list.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for(Integer n :  list) {
            res[i++] = n;
        }
        return res;
    }
}
