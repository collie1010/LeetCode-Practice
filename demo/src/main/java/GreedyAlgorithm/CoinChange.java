package GreedyAlgorithm;

public class CoinChange {
	
	public static void findMinCoins(int amount) {
        int[] coins = {50, 10, 5, 1};  // 可用的硬幣面額
        int[] result = new int[coins.length];  // 存儲每種硬幣的數量
        int remaining = amount;
        int totalCoins = 0;
        
        // 貪婪算法：優先使用大面額硬幣
        for (int i = 0; i < coins.length; i++) {
            result[i] = remaining / coins[i];  // 計算當前面額硬幣需要的數量
            remaining = remaining % coins[i];   // 計算剩餘金額
            totalCoins += result[i];           // 統計硬幣總數
        }
        
        // 輸出結果
        System.out.println("找零 " + amount + " 元的最佳方案：");
        for (int i = 0; i < coins.length; i++) {
            if (result[i] > 0) {
                System.out.println(coins[i] + "元 x " + result[i]);
            }
        }
        System.out.println("總共需要 " + totalCoins + " 枚硬幣");
    }
	
	
	public static void main(String[] args) {
        findMinCoins(68);  // 100 - 32 = 68元
    }
}
