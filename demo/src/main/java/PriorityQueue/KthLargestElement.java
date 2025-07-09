package PriorityQueue;

import java.util.PriorityQueue;

public class KthLargestElement {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargestElement(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
