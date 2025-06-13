package PriorityQueue;

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElement {
	public int[] topKFrequent(int[] nums, int k) {
		
		int[] result = new int[k];
		
		HashMap<Integer, Integer> freqMap = new HashMap<>();
		for (int num : nums) {
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		}
		
		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
		// 遍歷 HashMap 中的所有項目
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            // 將當前項目加入最小堆
            minHeap.offer(entry);
            // 如果堆的大小超過 k，則移除堆頂元素（頻率最小的元素）
            // 這樣可以保證堆中始終保留頻率最高的 k 個元素
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
		
        int i = 0;
        // 從最小堆中依次取出元素
        // 由於是最小堆，所以取出的順序是從頻率低到高
        while (!minHeap.isEmpty()) {
            // 將數字（key）存入結果陣列
            result[i++] = minHeap.poll().getKey();
        }
		
		
		return result;
		
	}
}
