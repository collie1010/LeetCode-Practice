package Matrix;
import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            if (rowStart <= rowEnd) {
                // 向左移動
                for (int i = colEnd; i >= colStart; i--) {
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            if (colStart <= colEnd) {
                // 向上移動
                for (int i = rowEnd; i >= rowStart; i--) {
                    result.add(matrix[i][colStart]);
                }
            }
            colStart++;

        }

        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix solution = new SpiralMatrix();

        // 測試案例1：3x3矩陣
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("測試案例1 (3x3矩陣):");
        System.out.println("輸入矩陣:");
        printMatrix(matrix1);
        System.out.println("螺旋順序輸出: " + solution.spiralOrder(matrix1));
        System.out.println();

        // 測試案例2：4x4矩陣
        int[][] matrix2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        System.out.println("測試案例2 (4x4矩陣):");
        System.out.println("輸入矩陣:");
        printMatrix(matrix2);
        System.out.println("螺旋順序輸出: " + solution.spiralOrder(matrix2));
        System.out.println();

        // 測試案例3：3x4矩陣（非方陣）
        int[][] matrix3 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        System.out.println("測試案例3 (3x4矩陣):");
        System.out.println("輸入矩陣:");
        printMatrix(matrix3);
        System.out.println("螺旋順序輸出: " + solution.spiralOrder(matrix3));
    }

    // 輔助方法：打印矩陣
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.printf("%4d", num);
            }
            System.out.println();
        }
    }
}