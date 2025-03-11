package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
	
	/* 數組解法
	 *    優點：
	 *      - 最優的空間和時間效率
	 *      - 適合ASCII字符集
	 *    
	 *    缺點：
	 *      - 僅限於有限的字符集
	 *    
	 *    時間複雜度：O(n)
	 *    空間複雜度：O(1) (固定大小的數組)
	 */
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		
		// 使用整數陣列記錄字元最後出現的位置
        int[] lastPos = new int[128]; // ASCII 字元
        for (int i = 0; i < 128; i++) {
            lastPos[i] = -1;  // 初始化為 -1
        }
		
        int maxLength = 0;
        int start = 0;       // 當前子字串的起始位置
        
        // 遍歷字串
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果字元已經在當前窗口中出現過，更新起始位置
            start = Math.max(start, lastPos[c] + 1);
            // 更新最大長度
            maxLength = Math.max(maxLength, i - start + 1);
            // 記錄字元最後出現的位置
            lastPos[c] = i;
        }
		
		return maxLength;
		
	}
	
	/*
	 * HashSet 解法
	 *    優點：
	 *      - 實現簡單，易於理解
	 *      - 不需要考慮字符的具體位置
	 *    
	 *    缺點：
	 *      - 需要多次移除和添加元素
	 *    
	 *    時間複雜度：O(n)
	 *    空間複雜度：O(min(m,n))，m是字符集大小
	 */
	public int lengthOfLongestSubstringHashSet(String s) {
		
		HashSet<Character> set = new HashSet<>();
		int maxLength = 0;
		int left = 0;
		
		for (int right = 0; right < s.length(); right++) {
			while (set.contains(s.charAt(right))) {
				set.remove(s.charAt(left));
				left++;
			}
			set.add(s.charAt(right));
			maxLength = Math.max(maxLength, right - left + 1);
		}
		
		return maxLength;
	}
	
	/* HashMap 解法
	 *    優點：
	 *      - 無需多次刪除元素
	 *      - 可以直接跳轉到新的左邊界
	 *    
	 *    缺點：
	 *      - HashMap操作相對較慢
	 *    
	 *    時間複雜度：O(n)
	 *    空間複雜度：O(min(m,n))
	 */
	public int lengthOfLongestSubstringHashMap(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		int maxLength = 0;
		int left = 0;
		
		for (int right = 0; right < s.length(); right++) {
			char currentChar = s.charAt(right);
			if (map.containsKey(currentChar)) {
				left = Math.max(left, map.get(currentChar) + 1);
			}
			map.put(currentChar, right);
			maxLength = Math.max(maxLength, right - left + 1);
		}
		
		return maxLength;
	}
	
	 public static void main(String[] args) {
		 LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
	        
	        // 測試案例
	        String[] testCases = {
	            "abcabcbb",  // 預期結果：3 ("abc")
	            "bbbbb",     // 預期結果：1 ("b")
	            "pwwkew",    // 預期結果：3 ("wke")
	            "",          // 預期結果：0
	            " ",        // 預期結果：1
	            "au",       // 預期結果：2
	            "dvdf",     // 預期結果：3
	            "anviaj",   // 預期結果：5
	            "abba",     // 預期結果：2
	            "aab",      // 預期結果：2
	            "abcdef"    // 預期結果：6
	        };
	        
	        // 執行測試並輸出結果
	        for (int i = 0; i < testCases.length; i++) {
	            System.out.printf("測試案例 %d:\n", i + 1);
	            String input = testCases[i];
	            System.out.printf("輸入字串: \"%s\"\n", input);
	            
	            int result = solution.lengthOfLongestSubstring(input);
	            System.out.printf("最長不重複子字串長度: %d\n", result);
	            
	            // 找出並顯示一個符合條件的子字串
	            if (result > 0) {
	                String subStr = findLongestSubstring(input);
	                System.out.printf("其中一個最長不重複子字串: \"%s\"\n", subStr);
	            }
	            
	            System.out.println("--------------------");
	        }
	        
	        // 效能測試
	        System.out.println("效能測試:");
	        StringBuilder longString = new StringBuilder();
	        int size = 100000;
	        // 產生較長的測試字串
	        for (int i = 0; i < size; i++) {
	            longString.append((char)('a' + (i % 26)));
	        }
	        
	        long startTime = System.currentTimeMillis();
	        int longResult = solution.lengthOfLongestSubstring(longString.toString());
	        long endTime = System.currentTimeMillis();
	        
	        System.out.printf("字串長度: %d\n", size);
	        System.out.printf("最長不重複子字串長度: %d\n", longResult);
	        System.out.printf("執行時間: %d 毫秒\n", endTime - startTime);
	    }
	    
	    // 輔助方法：找出一個最長不重複子字串
	    private static String findLongestSubstring(String s) {
	        if (s == null || s.length() == 0) {
	            return "";
	        }
	        
	        int[] lastPos = new int[128];
	        for (int i = 0; i < 128; i++) {
	            lastPos[i] = -1;
	        }
	        
	        int maxLength = 0;
	        int start = 0;
	        int resultStart = 0;
	        
	        for (int i = 0; i < s.length(); i++) {
	            char c = s.charAt(i);
	            start = Math.max(start, lastPos[c] + 1);
	            if (i - start + 1 > maxLength) {
	                maxLength = i - start + 1;
	                resultStart = start;
	            }
	            lastPos[c] = i;
	        }
	        
	        return s.substring(resultStart, resultStart + maxLength);
	    }
}
