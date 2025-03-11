package TwoPointer;

public class ValidPalindrome {
	
	public boolean isPalindrome(String s) {
		if (s.isEmpty()) {
			return true;
		}
		
		 // 1. 轉換為小寫並移除非字母數字字元
        String cleanStr = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        
        int left = 0;
        int right = cleanStr.length() - 1;
        
        while (left < right) {
        	if (cleanStr.charAt(left) != cleanStr.charAt(right)) {
        		return false;
        	}
        	left++;
        	right--;
        }
		return true;
	}
	
	public static void main(String[] args) {
		ValidPalindrome solution = new ValidPalindrome();
        
        // 測試案例
        String[] testCases = {
            "A man, a plan, a canal: Panama",  // true
            "race a car",                      // false
            " ",                               // true
            ".,",                              // true
            "0P",                              // false
            "a.",                              // true
            "ab@a",                            // true (aba)
            "A man, a plan, a cat, a ham, a yak, a yam, a hat, a canal – Panama!", // true
            "12321",                           // true
            "Never odd or even",               // true
            "1a2",                             // false
            "",                                // true
            "A Santa at NASA"                  // true
        };
        
        // 執行測試並輸出結果
        for (int i = 0; i < testCases.length; i++) {
            String input = testCases[i];
            boolean result = solution.isPalindrome(input);
            
            System.out.printf("測試案例 %d:\n", i + 1);
            System.out.printf("輸入: \"%s\"\n", input);
            System.out.printf("結果: %b\n", result);
            
            // 如果想看處理後的字串，可以取消下面註解
            String cleanStr = input.toLowerCase().replaceAll("[^a-z0-9]", "");
            System.out.printf("處理後的字串: \"%s\"\n", cleanStr);
            System.out.println("--------------------");
        }
        
        // 效能測試：產生較長的回文字串
        StringBuilder longPalindrome = new StringBuilder();
        int size = 100000;
        // 產生形如 "aaaa...aaaa" 的回文
        for (int i = 0; i < size; i++) {
            longPalindrome.append('a');
        }
        
        System.out.println("效能測試 (長字串):");
        System.out.printf("字串長度: %d\n", size);
        
        long startTime = System.currentTimeMillis();
        boolean result = solution.isPalindrome(longPalindrome.toString());
        long endTime = System.currentTimeMillis();
        
        System.out.printf("結果: %b\n", result);
        System.out.printf("執行時間: %d 毫秒\n", endTime - startTime);
    }

	
}
