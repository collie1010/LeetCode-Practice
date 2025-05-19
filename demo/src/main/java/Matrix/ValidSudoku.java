package Matrix;

import java.util.HashSet;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        // 使用哈希集合來檢查每行、每列和每個3x3子區域
        HashSet<String> seen = new HashSet<>();
        
        // 遍歷整個數獨板
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];
                if (number != '.') {
                    // 將數字及其位置信息加入到集合中
                    // 如果無法添加（已存在），則返回false
                    if (!seen.add(number + " in row " + i) ||
                        !seen.add(number + " in column " + j) ||
                        !seen.add(number + " in block " + i/3 + "-" + j/3))
                        return false;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        // 創建三個二維布爾數組來記錄數字的使用情況
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        
        // 遍歷數獨板
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 如果是空格，跳過
                if (board[i][j] == '.') {
                    continue;
                }
                
                // 將字符轉換為數字（0-8）
                int num = board[i][j] - '1';
                
                // 計算3x3子區域的索引
                int boxIndex = (i / 3) * 3 + j / 3;
                
                // 檢查是否有重複
                if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
                    return false;
                }
                
                // 標記該數字已被使用
                rows[i][num] = true;
                cols[j][num] = true;
                boxes[boxIndex][num] = true;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        // 測試案例1：有效的數獨
        char[][] validBoard = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        
        // 測試案例2：無效的數獨
        char[][] invalidBoard = {
            {'8','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        
        ValidSudoku solution = new ValidSudoku();
        
        System.out.println("測試案例1（有效的數獨）:");
        printBoard(validBoard);
        System.out.println("結果: " + solution.isValidSudoku(validBoard));
        System.out.println();
        
        System.out.println("測試案例2（無效的數獨）:");
        printBoard(invalidBoard);
        System.out.println("結果: " + solution.isValidSudoku(invalidBoard));
    }
    
    // 輔助方法：打印數獨板
    private static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("---------------------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
