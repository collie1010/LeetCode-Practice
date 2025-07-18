package PriorityQueue;

import java.util.PriorityQueue;

public class KClosetPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        // 使用最小堆來存儲距離和點
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];
            return Integer.compare(distA, distB);
        });

        // 將所有點加入最小堆
        for (int[] point : points) {
            minHeap.offer(point);
        }

        // 提取前 k 個最近的點
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
