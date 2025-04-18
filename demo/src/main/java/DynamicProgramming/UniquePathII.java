package DynamicProgramming;

public class UniquePathII {

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0) {
			return 0;
		}

		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		// 創建 DP 陣列
		int[][] dp = new int[m][n];

		// 初始化第一個位置
		dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

		// 初始化第一列
		for (int j = 1; j < n; j++) {
			if (obstacleGrid[0][j] == 1) {
				dp[0][j] = 0;
			} else {
				dp[0][j] = dp[0][j - 1];
			}
		}

		// 初始化第一行
		for (int i = 1; i < m; i++) {
			if (obstacleGrid[i][0] == 1) {
				dp[i][0] = 0;
			} else {
				dp[i][0] = dp[i - 1][0];
			}
		}

		// 填充 DP 陣列
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}

		return dp[m - 1][n - 1];
	}

	// 輔助方法：印出網格內容
	public static void printGrid(int[][] grid) {
		System.out.println("網格內容：");
		for (int[] row : grid) {
			for (int cell : row) {
				System.out.print(cell + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// 測試案例 1：題目中的範例
		int[][] grid1 = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		System.out.println("測試案例 1:");
		printGrid(grid1);
		System.out.println("可能的路徑數量: " + uniquePathsWithObstacles(grid1));
		System.out.println("------------------------");

		// 測試案例 2：起點有障礙
		int[][] grid2 = { { 1, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		System.out.println("測試案例 2 (起點有障礙):");
		printGrid(grid2);
		System.out.println("可能的路徑數量: " + uniquePathsWithObstacles(grid2));
		System.out.println("------------------------");

		// 測試案例 3：終點有障礙
		int[][] grid3 = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 1 } };
		System.out.println("測試案例 3 (終點有障礙):");
		printGrid(grid3);
		System.out.println("可能的路徑數量: " + uniquePathsWithObstacles(grid3));
		System.out.println("------------------------");

		// 測試案例 4：較大的網格
		int[][] grid4 = { { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };
		System.out.println("測試案例 4 (較大的網格):");
		printGrid(grid4);
		System.out.println("可能的路徑數量: " + uniquePathsWithObstacles(grid4));
		System.out.println("------------------------");

		// 測試案例 5：無路可走
		int[][] grid5 = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 1, 0 } };
		System.out.println("測試案例 5 (部分路徑被擋住):");
		printGrid(grid5);
		System.out.println("可能的路徑數量: " + uniquePathsWithObstacles(grid5));
	}
}
