package GraphGeneral;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int j = 0; j < n; j++) dfs(0, j, heights, pacific);
        for (int i = 0; i < m; i++) dfs(i, 0, heights, pacific);
        for (int j = 0; j < n; j++) dfs(m - 1, j, heights, atlantic);
        for (int i = 0; i < m; i++) dfs(i, n - 1, heights, atlantic);

        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;


    }

    private void dfs(int i, int j, int[][] heights, boolean[][] visited) {
        int m = heights.length;
        int n = heights[0].length;
        
        if (visited[i][j]) return;
        visited[i][j] = true;
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n) continue;
            if (heights[x][y] < heights[i][j]) continue;
            dfs(x, y, heights, visited);
        }
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow solution = new PacificAtlanticWaterFlow();
        int[][] heights = {
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        };
        List<List<Integer>> result = solution.pacificAtlantic(heights);
        for (List<Integer> cell : result) {
            System.out.println(cell);
        }
    }
}
