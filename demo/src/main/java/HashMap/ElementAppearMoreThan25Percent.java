package HashMap;

import java.util.HashMap;
import java.util.Map;

public class ElementAppearMoreThan25Percent {
	public int findSpecialInteger(int[] arr) {
		Map<Integer, Integer> countMap = new HashMap<>();

		for (int num : arr) {
			countMap.put(num, countMap.getOrDefault(num, 0) + 1);
		}

		// 找出出現次數超過 25% 的數字
		int threshold = arr.length / 4;
		for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
			if (entry.getValue() > threshold) {
				return entry.getKey();
			}
		}

		return arr[0]; // 一定會有答案，這行實際上不會執行到
	}
	
	public int findSpecialInteger2(int[] arr) {
        int n = arr.length;
        int count = 1;
        int current = arr[0];
        
        for (int i = 1; i < n; i++) {
            if (arr[i] == current) {
                count++;
                if (count > n/4) return current;
            } else {
                count = 1;
                current = arr[i];
            }
        }
        
        return current; // 如果陣列長度為 1
    }
}
