package java_coding_question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public int[] twoSum01(int[] nums, int target) {
        int len = nums.length;
        int[] result = new int[2];
        List list = new ArrayList<>();
        for(int i = 0; i < len; i++){
            int v = nums[i];
            int id = list.indexOf(target-v);
            if(id >= 0) {
                result[0] = id ;
                result[1] = i;
                return result;
            } else {
                list.add(nums[i]);
            }
        }
        return result;
    }
    public int[] twoSum02(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        // key: record the subtraction between target and num[i]
        // value: i
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int index = map.get(nums[i]);
                result[0] = index;
                result[1] = i;
                return result;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return result;
    }
}
