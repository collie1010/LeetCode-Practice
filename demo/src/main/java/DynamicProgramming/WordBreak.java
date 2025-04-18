package DynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictionary = new HashSet<>(wordDict);			
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;  // 空字串可以被拆分
        
        // 遍歷所有可能的子字串長度
        for (int i = 1; i <= n; i++) {
            // 遍歷所有可能的拆分點
            for (int j = 0; j < i; j++) {
                // 如果前半部分可以被拆分，且後半部分在字典中存在
                if (dp[j] && dictionary.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[n];
    }
	
	// 測試輔助方法
    private static void testCase(String s, List<String> wordDict, boolean expectedResult) {
    	WordBreak solution = new WordBreak();
        boolean result = solution.wordBreak(s, wordDict);
        System.out.println("測試案例：");
        System.out.println("輸入字串: \"" + s + "\"");
        System.out.println("字典內容: " + wordDict);
        System.out.println("預期結果: " + expectedResult);
        System.out.println("實際結果: " + result);
        System.out.println("測試結果: " + (result == expectedResult ? "通過" : "失敗"));
        System.out.println("================");
    }

    public static void main(String[] args) {
        // 測試案例1
        String s1 = "leetcode";
        List<String> dict1 = Arrays.asList("leet", "code");
        testCase(s1, dict1, true);

        // 測試案例2
        String s2 = "applepenapple";
        List<String> dict2 = Arrays.asList("apple", "pen");
        testCase(s2, dict2, true);

        // 測試案例3
        String s3 = "catsandog";
        List<String> dict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        testCase(s3, dict3, false);

        // 測試案例4（空字串）
        String s4 = "";
        List<String> dict4 = Arrays.asList("test");
        testCase(s4, dict4, true);

        // 測試案例5（單個字符）
        String s5 = "a";
        List<String> dict5 = Arrays.asList("a");
        testCase(s5, dict5, true);

        // 測試案例6（重複使用字典中的詞）
        String s6 = "gogogo";
        List<String> dict6 = Arrays.asList("go");
        testCase(s6, dict6, true);

    }
}
