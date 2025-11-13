package PriorityQueue;

import java.util.Map;

public class SortCharacterByFreq {
    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new java.util.HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        java.util.PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new java.util.PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());
        
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            maxHeap.offer(entry);
        }

        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            char currentChar = entry.getKey();
            int frequency = entry.getValue();
            for (int i = 0; i < frequency; i++) {
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    public String frequencySortII(String s) {
        int[] freq = new int[128];
        for (char c : s.toCharArray()) freq[c]++;
    
        java.util.PriorityQueue<Character> maxHeap = new java.util.PriorityQueue<>(
                (a, b) -> freq[b] - freq[a]);
        
        for (char c : s.toCharArray()) {
            if (!maxHeap.contains(c)) maxHeap.offer(c);
        }

        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char currentChar = maxHeap.poll();
            int frequency = freq[currentChar];
            for (int i = 0; i < frequency; i++) result.append(currentChar);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        SortCharacterByFreq sorter = new SortCharacterByFreq();
        String input = "ttree";
        String sorted = sorter.frequencySort(input);
        System.out.println("Input: " + input);
        System.out.println("Sorted by frequency: " + sorted);
    }
}
