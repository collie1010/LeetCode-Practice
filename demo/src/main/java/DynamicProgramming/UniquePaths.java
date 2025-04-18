package DynamicProgramming;

public class UniquePaths {
	
	public int uniquePaths(int m, int n) {
		
		int[][] dp = new int[m][n];

		// 初始化第一行和第一列
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for (int j = 0; j < n; j++) {
			dp[0][j] = 1;
		}

		// 填充 dp 陣列
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

		return dp[m - 1][n - 1];
	}
	
	// 用於顯示路徑網格的輔助方法
    private static void printGrid(int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    System.out.print("S "); // Start
                } else if (i == m-1 && j == n-1) {
                    System.out.print("E "); // End
                } else {
                    System.out.print("· ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();
        
        // 測試案例
        int[][] testCases = {
            {3, 7},  // 題目範例 1
            {3, 2},  // 題目範例 2
            {7, 3},  // 測試不同維度
            {3, 3},  // 測試正方形網格
            {1, 1},  // 測試最小網格
            {10, 10} // 測試較大網格
        };

        // 執行測試
        for (int i = 0; i < testCases.length; i++) {
            int m = testCases[i][0];
            int n = testCases[i][1];
            
            System.out.println("\n測試案例 " + (i + 1) + ":");
            System.out.println("網格大小: " + m + " × " + n);
            System.out.println("網格示意圖:");
            printGrid(m, n);
            
            int result = solution.uniquePaths(m, n);
            System.out.println("不同路徑數量: " + result);
            
            System.out.println("-".repeat(30));
        }
    }
}
