package HashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelativeSortArray {
	
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 統計 arr1 中每個數字出現的次數
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr1) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // 建立結果陣列
        int[] result = new int[arr1.length];
        int index = 0;
        
        // 根據 arr2 的順序填入數字
        for (int num : arr2) {
            int count = frequencyMap.get(num);
            // 填入指定次數的數字
            for (int i = 0; i < count; i++) {
                result[index++] = num;
            }
            // 移除已處理的數字
            frequencyMap.remove(num);
        }
        
        // 處理不在 arr2 中的數字
        List<Integer> remaining = new ArrayList<>(frequencyMap.keySet());
        Collections.sort(remaining); // 升序排序
        
        // 將剩餘數字按升序加入結果
        for (int num : remaining) {
            int count = frequencyMap.get(num);
            for (int i = 0; i < count; i++) {
                result[index++] = num;
            }
        }
        
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
