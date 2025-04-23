package DynamicProgramming;

import java.util.Arrays;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		// dp[i] 表示達到金額i所需的最少硬幣數
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
	}
	
	public static void main(String[] args) {
		CoinChange solution = new CoinChange();
        
        // 測試案例
        int[][] testCases = {
            {1, 3, 4},   // amount = 6
            {9, 6, 5, 1}, // amount = 11
            {186, 419, 83, 408}, // amount = 6249
            {1, 2, 5},   // amount = 11
            {2},         // amount = 3
            {1},         // amount = 0
        };
        
        int[] amounts = {6, 11, 6249, 11, 3, 0};
        
        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1) + ":");
            System.out.println("Coins: " + Arrays.toString(testCases[i]));
            System.out.println("Amount: " + amounts[i]);
            System.out.println("Result: " + solution.coinChange(testCases[i], amounts[i]));
            System.out.println("------------------------");
        }
    }
}
