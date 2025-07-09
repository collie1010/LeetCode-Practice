package PriorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> countMap = new HashMap<>();

        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        // 2. 將 HashMap 的 key（單字）轉換成 List
        List<String> result = new ArrayList<>(countMap.keySet());

        // 3. 使用 Collections.sort 進行排序
        Collections.sort(result, (a, b) -> {
            // 比較頻率
            int freqCompare = countMap.get(b) - countMap.get(a);
            // 如果頻率相同，按字母順序排序
            if (freqCompare == 0) {
                return a.compareTo(b);
            }
            return freqCompare;
        });

        // 4. 返回前 k 個元素
        return result.subList(0, k);
    }
}
