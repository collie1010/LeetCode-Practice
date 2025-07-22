package PriorityQueue;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();
        // Store frequencies of all tasks first
        for (char task : tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }

        // maxHeap will pick the most frequent task
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // maxHeap
        maxHeap.addAll(freqMap.values()); // Adds all frequencies to the maxHeap

        Queue<int[]> cooldown = new LinkedList<>(); // To store cooldown time, Format: [nextAvailableTime, frequency]
        int time = 0; // To calculate total time

        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            time++; // Task time calculated, +1 tick.

            // Check if any task has reached cooldown time (Means we can use it again)
            // If yes, add it to the heap for processing
            if (!cooldown.isEmpty() && cooldown.peek()[0] == time) {
                maxHeap.offer(cooldown.poll()[1]);
            }

            if (!maxHeap.isEmpty()) {
                int freq = maxHeap.poll();
                int remainingFreq = freq - 1; // 1 Tick has been consumed.
                if (remainingFreq > 0) {
                    int nextAvailableTime = time + n + 1;
                    cooldown.add(new int[] { nextAvailableTime, remainingFreq });
                }
            }

            // If code reaches here without any conditions above, then this iteration is an idle tick.
        }

        return time;
    }
}
