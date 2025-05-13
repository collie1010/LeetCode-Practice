package GraphGeneral;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		int rows = grid.length;
		int cols = grid[0].length;
		int islands = 0;

		// 遍歷整個網格
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				// 當找到一塊陸地（'1'）時，計數加1並進行 DFS
				if (grid[i][j] == '1') {
					islands++;
					dfs(grid, i, j);
				}
			}
		}

		return islands;
	}

	private void dfs(char[][] grid, int row, int col) {
		int rows = grid.length;
		int cols = grid[0].length;

		// 檢查邊界條件或是否已訪問（被標記為'0'）
		if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == '0') {
			return;
		}

		// 將當前陸地標記為已訪問（改為'0'）
		grid[row][col] = '0';

		// 遞迴訪問上下左右四個方向
		dfs(grid, row - 1, col); // 上
		dfs(grid, row + 1, col); // 下
		dfs(grid, row, col - 1); // 左
		dfs(grid, row, col + 1); // 右
	}

	private void bfs(char[][] grid, int row, int col) {
		int rows = grid.length;
		int cols = grid[0].length;

		// 定義方向數組（上、下、左、右）
		int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		// 使用 LinkedList 作為隊列
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { row, col });
		grid[row][col] = '0'; // 標記為已訪問

		// BFS 主要邏輯
		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			// 檢查四個方向
			for (int[] dir : directions) {
				int newRow = current[0] + dir[0];
				int newCol = current[1] + dir[1];

				// 檢查新位置是否有效且為陸地
				if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == '1') {

					queue.offer(new int[] { newRow, newCol });
					grid[newRow][newCol] = '0'; // 標記為已訪問
				}
			}
		}
	}

	// 用於印出網格的輔助方法
	private static void printGrid(char[][] grid) {
		for (char[] row : grid) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println();
	}

	public static void main(String[] args) {
		NumberOfIsland solution = new NumberOfIsland();

		// 測試用例 1
		char[][] grid1 = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };

		System.out.println("測試用例 1:");
		System.out.println("初始網格:");
		printGrid(grid1);
		int result1 = solution.numIslands(grid1);
		System.out.println("島嶼數量: " + result1);

		// 測試用例 2
		char[][] grid2 = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };

		System.out.println("測試用例 2:");
		System.out.println("初始網格:");
		printGrid(grid2);
		int result2 = solution.numIslands(grid2);
		System.out.println("島嶼數量: " + result2);

		// 測試用例 3 (額外測試: 單一島嶼)
		char[][] grid3 = { { '1', '1', '1' }, { '1', '1', '1' }, { '1', '1', '1' } };

		System.out.println("測試用例 3:");
		System.out.println("初始網格:");
		printGrid(grid3);
		int result3 = solution.numIslands(grid3);
		System.out.println("島嶼數量: " + result3);

		// 測試用例 4 (額外測試: 沒有島嶼)
		char[][] grid4 = { { '0', '0', '0' }, { '0', '0', '0' }, { '0', '0', '0' } };

		System.out.println("測試用例 4:");
		System.out.println("初始網格:");
		printGrid(grid4);
		int result4 = solution.numIslands(grid4);
		System.out.println("島嶼數量: " + result4);

	}
}
