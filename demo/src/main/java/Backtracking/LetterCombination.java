package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {

	public static List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();

		// 處理空字串的情況
		if (digits == null || digits.length() == 0) {
			return result;
		}

		// 使用遞迴方式生成組合
		backTrack(digits, 0, new StringBuilder(), result);
		return result;
	}

	// 建立數字到字母的映射
	private static final String[] KEYPAD = { "", // 0
			"", // 1
			"abc", // 2
			"def", // 3
			"ghi", // 4
			"jkl", // 5
			"mno", // 6
			"pqrs", // 7
			"tuv", // 8
			"wxyz" // 9
	};

	private static void backTrack(String digit, int index, StringBuilder currString, List<String> result) {

		if (index == digit.length()) {
			result.add(currString.toString());
			return;
		}

		String letters = KEYPAD[digit.charAt(index) - '0'];
		for (char letter : letters.toCharArray()) {
			currString.append(letter);
			backTrack(digit, index + 1, currString, result);
			currString.setLength(currString.length() - 1);

		}

	}
	
	public static void main(String[] args) {
        // 測試案例
        String[] testCases = {"23", "", "2", "234", "56"};
        
        System.out.println("手機按鍵字母組合測試");
        System.out.println("=================");
        
        for (String test : testCases) {
            System.out.println("輸入: \"" + test + "\"");
            List<String> combinations = letterCombinations(test);
            System.out.println("輸出: " + combinations);
            System.out.println("組合數量: " + combinations.size());
            System.out.println();
        }
        
        // 特殊測試：顯示每個組合的生成過程
        String specialTest = "23";
        System.out.println("特殊測試 - 詳細過程展示");
        System.out.println("輸入: \"" + specialTest + "\"");
        System.out.println("生成過程：");
        List<String> result = new ArrayList<>();
        backTrack(specialTest, 0, new StringBuilder(), result);
        for (int i = 0; i < result.size(); i++) {
            System.out.printf("組合 %d: %s%n", i + 1, result.get(i));
        }
    }
}
