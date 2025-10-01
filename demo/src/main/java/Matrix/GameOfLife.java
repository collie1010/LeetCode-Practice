package Matrix;

public class GameOfLife {
    private static final int[][] DIRS = { { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, 
                                        { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
                                        
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] result = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int neighbors = getNei(board, i, j);
                
                if (board[i][j] == 1) { // 活細胞
                    if (neighbors == 2 || neighbors == 3) {
                        result[i][j] = 1;
                    }
                } else { // 死細胞
                    if (neighbors == 3) {
                        result[i][j] = 1;
                    }
                }
            }
        }
        
        // 複製結果回原陣列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = result[i][j];
            }
        }
    }

    private int getNei(int[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;

        for (int[] dir : DIRS) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            
            if (inRange(ni, m) && inRange(nj, n) && board[ni][nj] == 1) {
                count++;
            }
        }

        return count;
    }

    private boolean inRange(int i, int m) {
        return i >= 0 && i < m;
    }

    public static void main(String[] args) {
        GameOfLife solution = new GameOfLife();
        int[][] board = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };
        
        solution.gameOfLife(board);
        
        // 輸出結果
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
