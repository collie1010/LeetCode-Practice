package PriorityQueue;

import java.util.PriorityQueue;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++) {
            maxheap.offer(new int[] { score[i], i });
        }
        int rank = 1;
        while (!maxheap.isEmpty()) {
            int[] top = maxheap.poll();
            int index = top[1];
            if (rank == 1)
                result[index] = "Gold Medal";
            else if (rank == 2)
                result[index] = "Silver Medal";
            else if (rank == 3)
                result[index] = "Bronze Medal";
            else
                result[index] = String.valueOf(rank);
            rank++;
        }
        return result;
    }
}
