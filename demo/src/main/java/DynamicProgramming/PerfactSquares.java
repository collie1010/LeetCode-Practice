package DynamicProgramming;

import java.util.Arrays;

public class PerfactSquares {
	
	public static int numSquares(int n) {
        // dp[i] 表示滿足n的最少 perfectSquares 數量
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        
        // 對每個數字進行運算
        for (int i = 1; i <= n; i++) {
            // 檢查所有可能的完全平方數
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        
        return dp[n];
        
    }
	
	public static void main(String[] args) {
        // 測試案例
        int[] testCases = {12, 13, 16, 7, 4};
        
        for (int n : testCases) {
            int result = numSquares(n);
            System.out.printf("n = %d, 需要 %d 個完全平方數%n", n, result);
        }
    }
}
