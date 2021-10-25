package heap;

import java.util.Random;

public class TestHeap {
    public static void main(String[] args) {
        int n = 100;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        MinHeap<Integer> minHeap = new MinHeap<>();
        Random rnd = new Random();
        for(int i = 0; i < n; i++) {
//            maxHeap.add(rnd.nextInt(Integer.MAX_VALUE));
            minHeap.add(rnd.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
//            arr[i] = maxHeap.extractMax();
            arr[i] = minHeap.extractMin();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i-1] > arr[i]) {
                throw new IllegalArgumentException("Error!");
            }
        }
        System.out.println("Test minHeap completed.");
    }
}
