package TwoPointer;

public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
        // 若 s 為空字串，必定是任何字串的子序列
        if (s.length() == 0) {
            return true;
        }
        
        // 若 t 為空字串，而 s 不為空，則 s 不可能是 t 的子序列
        if (t.length() == 0) {
            return false;
        }
        
        int sIndex = 0;  // s 的目前比對位置
        int tIndex = 0;  // t 的目前比對位置
        
        // 遍歷字串 t
        while (tIndex < t.length()) {
            // 若找到匹配的字元
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;  // 移動 s 的比對位置
                // 若已經匹配完 s 中所有字元，表示找到子序列
                if (sIndex == s.length()) {
                    return true;
                }
            }
            tIndex++;  // 無論是否匹配，都要移動 t 的比對位置
        }
        
        // 若遍歷完 t 仍未找到完整的子序列，回傳 false
        return false;
    }
	
	public static void main(String[] args) {
        IsSubsequence solution = new IsSubsequence();
        
        // 測試案例
        String[][] testCases = {
            {"abc", "ahbgdc"},        // true
            {"axc", "ahbgdc"},        // false
            {"", "ahbgdc"},           // true (空字串是任何字串的子序列)
            {"abc", ""},              // false (非空字串不是空字串的子序列)
            {"abc", "abc"},           // true (完全相同)
            {"abc", "abcdef"},        // true (連續子字串)
            {"acb", "ahcbgdc"},       // false (順序不對)
            {"leetcode", "ylabel"},    // false
            {"aaaaaa", "bbaaaa"},     // false
            {"ace", "abcde"}          // true
        };
        
        // 執行測試並輸出結果
        for (int i = 0; i < testCases.length; i++) {
            String s = testCases[i][0];
            String t = testCases[i][1];
            boolean result = solution.isSubsequence(s, t);
            
            System.out.printf("測試案例 %d:\n", i + 1);
            System.out.printf("s = \"%s\", t = \"%s\"\n", s, t);
            System.out.printf("結果: %b\n", result);
            System.out.println("--------------------");
        }
        
        // 效能測試：產生較長的測試字串
        StringBuilder longS = new StringBuilder();
        StringBuilder longT = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            longS.append('a');
        }
        for (int i = 0; i < 10000; i++) {
            longT.append('a');
        }
        
        System.out.println("效能測試 (長字串):");
        System.out.printf("s 長度: %d, t 長度: %d\n", longS.length(), longT.length());
        
        long startTime = System.currentTimeMillis();
        boolean result = solution.isSubsequence(longS.toString(), longT.toString());
        long endTime = System.currentTimeMillis();
        
        System.out.printf("結果: %b\n", result);
        System.out.printf("執行時間: %d 毫秒\n", endTime - startTime);
    }
}
