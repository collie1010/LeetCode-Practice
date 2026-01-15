package DynamicProgramming;

public class LongestIncreasingPathMatrix {

    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, dfs(matrix, i, j, dp));
            }
        }
        return result;
        
    }

    private int dfs(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) return dp[i][j];

        int max = 1;
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) continue;
            if (matrix[x][y] <= matrix[i][j]) continue;
            int curr = dfs(matrix, x, y, dp);
            max = Math.max(max, curr + 1);
        }
        dp[i][j] = max;
        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingPathMatrix solution = new LongestIncreasingPathMatrix();
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(solution.longestIncreasingPath(matrix));
    }
    
}
