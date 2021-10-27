package counting_sort;

// LC75 �ĥέp�ƱƧǪk

public class Solution {
    public void sortColors(int[] nums) {
        int R = 3;
        int[] cnt = new int[R];
        for(int num : nums) {
            cnt[num]++;
        }
        int[] index = new int[R+1]; // nums[index[i], index[i+1]) = i, �Ʀri�����k�϶���index[i], index[i+1]
        for(int i = 0; i < R; i++) {
            // �p��k��ɪ��_�l��m
            index[i+1] = index[i] + cnt[i];
        }
        for(int i = 0; i + 1 < index.length; i++) {
            // [index[i], index[i+1])�϶����Ȭ�i
            for(int j = index[i]; j < index[i+1]; j++) {
                nums[j] = i;
            }
        }
    }
}
