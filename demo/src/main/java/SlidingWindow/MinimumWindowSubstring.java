package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // 建立兩個 HashMap 來記錄字符頻率
        Map<Character, Integer> targetMap = new HashMap<>();  // 目標字符頻率
        Map<Character, Integer> windowMap = new HashMap<>();  // 窗口中的字符頻率

        // 統計目標字符串中字符的頻率
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;           // 左指針
        int minStart = 0;       // 最小窗口的起始位置
        int minLen = Integer.MAX_VALUE;  // 最小窗口長度
        int required = targetMap.size();  // 需要匹配的不同字符數
        int current = 0;        // 當前匹配的字符數

        // 移動右指針
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // 增加窗口中的字符頻率
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            // 檢查當前字符是否匹配目標要求
            if (targetMap.containsKey(c)
                    && windowMap.get(c).intValue() == targetMap.get(c).intValue()) {
                current++;
            }

            // 當找到一個可行解時，嘗試優化窗口大小
            while (current == required) {
                // 更新最小窗口
                if (right - left + 1 < minLen) {
                    minStart = left;
                    minLen = right - left + 1;
                }

                // 移除左邊的字符
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                // 如果移除的字符導致不再匹配
                if (targetMap.containsKey(leftChar)
                        && windowMap.get(leftChar).intValue() < targetMap.get(leftChar).intValue()) {
                    current--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    // 測試用的輔助方法
    private static void testCase(String s, String t, String expected) {
        MinimumWindowSubstring  solution = new MinimumWindowSubstring ();
        String result = solution.minWindow(s, t);
        System.out.println("Test Case:");
        System.out.println("Input String s: " + s);
        System.out.println("Input String t: " + t);
        System.out.println("Result: " + result);
        System.out.println();
    }

    public static void main(String[] args) {
        // 測試案例 1：正常情況
        testCase("ADOBECODEBANC", "ABC", "BANC");

        // 測試案例 2：單字符
        testCase("a", "a", "a");

        // 測試案例 3：無解情況
        testCase("a", "aa", "");

        // 測試案例 4：目標字符串有重複字符
        testCase("ADOBECODEBANC", "AABC", "ADOBEC");

        // 測試案例 5：完全匹配
        testCase("ABC", "ABC", "ABC");

        // 測試案例 6：較長的窗口
        testCase("AAAAABBBCCCC", "ABC", "ABBC");

        // 測試案例 7：目標字符串較長
        testCase("A", "ABC", "");

        // 測試案例 8：空字符串
        testCase("", "A", "");

        // 測試案例 9：大小寫混合
        testCase("aaAACCCBB", "ABC", "ACB");

        // 測試案例 10：連續相同字符
        testCase("AAAA", "AA", "AA");
    }

}
