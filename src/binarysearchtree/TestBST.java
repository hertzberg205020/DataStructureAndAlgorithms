package binarysearchtree;

import java.util.ArrayList;
import java.util.Random;

public class TestBST {
    public static void main(String[] args) {
        BST<Integer> bst= new BST<>();
//        int[] nums = {5, 3, 6, 8, 4, 2};
//        for(int num : nums) {
//            bst.add2(num);
//        }
//
//        /////////////////
//        //      5      //
//        //    /   \    //
//        //   3    6    //
//        //  / \    \   //
//        // 2  4     8  //
//        /////////////////
//
//        bst.preOrder();
//        System.out.println();
//        bst.preOrderNR();
//        System.out.println();
//        System.out.println(bst);
        Random rnd = new Random();

        int n = 1000;

        //test removeMin
        for(int i = 0; i < n; i++) {
            bst.add(rnd.nextInt(10000));
        }
        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty()) {
            nums.add(bst.removeMin());
        }
        System.out.println(nums);

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i-1) > nums.get(i)) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("RemoveMin test is complete.");
    }
}
