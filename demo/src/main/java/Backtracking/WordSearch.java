package Backtracking;

class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        boolean result = false;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    result = backtrack(board, word, visited, i, j, 0);
                    if (result) return true;
                }
            }
        }
        
        return false;
    }


    private boolean backtrack(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if(index == word.length()) return true;

        if (i < 0 || i >= board.length ||  j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) 
            return false;
        
        visited[i][j] = true;

        if (backtrack(board, word, visited, i + 1, j, index + 1) ||
            backtrack(board, word, visited, i - 1, j, index + 1) ||
            backtrack(board, word, visited, i, j + 1, index + 1) ||
            backtrack(board, word, visited, i, j - 1, index + 1))
            return true;

        visited[i][j] = false;
        return false;

    }
    
    // 輔助方法：打印網格
    private static void printBoard(char[][] board) {
        System.out.println("目前網格：");
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // 建立測試用例
        char[][] board1 = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        
        char[][] board2 = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        
        char[][] board3 = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        
        // 建立測試單詞
        String[] testWords = {"ABCCED", "SEE", "ABCB"};
        
        WordSearch solution = new WordSearch();
        
        // 執行測試
        System.out.println("開始測試單詞搜尋：");
        System.out.println("=================");
        
        // 測試每個案例
        for (int i = 0; i < testWords.length; i++) {
            System.out.println("測試案例 " + (i + 1) + "：");
            System.out.println("搜尋單詞：" + testWords[i]);
            
            char[][] currentBoard;
            switch (i) {
                case 0: currentBoard = board1; break;
                case 1: currentBoard = board2; break;
                default: currentBoard = board3;
            }
            
            printBoard(currentBoard);
            
            boolean result = solution.exist(currentBoard, testWords[i]);
            System.out.println("結果：" + (result ? "True" : "False"));
            System.out.println("=================");
        }
        
        // 額外測試案例
        System.out.println("測試特殊案例：");
        
        // 測試單個字符
        char[][] singleChar = {{'A'}};
        System.out.println("單個字符測試：" + solution.exist(singleChar, "A"));
        
        // 測試較長的單詞
        String longWord = "ABCESCFSADEE";
        System.out.println("較長單詞測試：" + solution.exist(board1, longWord));
    }
}