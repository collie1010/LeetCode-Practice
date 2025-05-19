package Matrix;

import java.util.Arrays;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // 步驟1：轉置矩陣
        transpose(matrix, n);
        
        // 步驟2：翻轉每行
        reflect(matrix, n);
    }
    
    private void transpose(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    
    private void reflect(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
    
    // 輔助方法：打印矩陣
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] test1 = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        
        System.out.println("原始矩陣：");
        printMatrix(test1);
        
        RotateImage solution = new RotateImage();
        solution.rotate(test1);
        
        System.out.println("\n旋轉後：");
        printMatrix(test1);
    }
}
