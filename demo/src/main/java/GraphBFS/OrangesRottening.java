package GraphBFS;

import java.util.LinkedList;
import java.util.Queue;

public class OrangesRottening {

	public int orangesRotting(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		Queue<int[]> queue = new LinkedList<>();
		int fresh = 0; // 記錄新鮮橘子的數量

		// 找出所有腐爛的橘子和統計新鮮橘子數量
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 2) {
					queue.offer(new int[] { i, j });
				} else if (grid[i][j] == 1) {
					fresh++;
				}
			}
		}

		// 如果沒有新鮮橘子，直接返回0
		if (fresh == 0)
			return 0;
		// 如果有新鮮橘子但沒有腐爛的橘子，返回-1
		if (queue.isEmpty())
			return -1;

		int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 上下左右四個方向
		int minutes = 0;

		// BFS過程
		while (!queue.isEmpty() && fresh > 0) {
			minutes++;
			int size = queue.size();

			// 處理當前層的所有腐爛橘子
			for (int i = 0; i < size; i++) {
				int[] current = queue.poll();

				// 檢查四個方向
				for (int[] dir : directions) {
					int newRow = current[0] + dir[0];
					int newCol = current[1] + dir[1];

					// 檢查邊界條件和是否為新鮮橘子
					if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
						grid[newRow][newCol] = 2; // 使橘子腐爛
						queue.offer(new int[] { newRow, newCol });
						fresh--; // 減少新鮮橘子數量
					}
				}
			}
		}

		// 如果還有新鮮橘子，返回-1
		return fresh == 0 ? minutes : -1;
	}

}
