package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // 如果當前字符串長度達到 2n，表示已生成完整的括號組合
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        
        // 如果開括號數量小於 n，可以添加開括號
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        
        // 如果閉括號數量小於開括號數量，可以添加閉括號
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
    
    public static void main(String[] args) {
    	GenerateParenthesis solution = new GenerateParenthesis();
        
        // 測試不同的 n 值
        int[] testCases = {1, 2, 3};
        
        for (int n : testCases) {
            System.out.println("測試 n = " + n + "：");
            List<String> result = solution.generateParenthesis(n);
            System.out.println("生成的括號組合數量：" + result.size());
            System.out.println("所有組合：" + result);
            System.out.println();
        }

        // 額外測試：測試邊界情況 n = 1
        System.out.println("邊界測試 n = 1：");
        List<String> result = solution.generateParenthesis(1);
        System.out.println("生成的括號組合數量：" + result.size());
        System.out.println("所有組合：" + result);
    }
}
