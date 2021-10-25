package heap;

// 劍指offer 40

import java.util.Collections;

public class Offer40Solution {

    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.enqueue(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (!pq.isEmpty() && arr[i] < pq.getFront()) {
                pq.dequeue();
                pq.enqueue(arr[i]);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.dequeue();
        }
        return res;
    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        // java默認實現最小堆，本題要使用最大堆解題
        // 傳入比較器使表較順序顛倒，採用此方法實現最大堆
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (!pq.isEmpty() && arr[i] < pq.peek()) {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
