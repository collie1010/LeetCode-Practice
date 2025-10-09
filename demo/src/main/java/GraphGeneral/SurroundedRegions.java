package GraphGeneral;

public class SurroundedRegions {
    public void slove(char[][] board) {
        if (board == null || board.length == 0) return;
        int rows = board.length;
        int cols = board[0].length;

        // 標記邊界上的 'O' 及其相連的 'O'
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][cols - 1] == 'O') dfs(board, i, cols - 1);
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[rows - 1][j] == 'O') dfs(board, rows - 1, j);
        }

        // 將未標記的 'O' 轉換為 'X'，將標記的 'E' 還原為 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'E') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        int rows = board.length;
        int cols = board[0].length;
        if (x < 0 || x >= rows || y < 0 || y >= cols || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'E'; // 標記為邊界連通的 'O'
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }
}
