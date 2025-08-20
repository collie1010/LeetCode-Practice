package GraphGeneral;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        
        // 如果原始顏色和目標顏色相同，直接回傳
        if (originalColor == color) {
            return image;
        }
        
        dfs(image, sr, sc, originalColor, color);
        return image;
    }
    
    private void dfs(int[][] image, int row, int col, int originalColor, int newColor) {
        // 檢查邊界條件和顏色匹配
        if (row < 0 || row >= image.length || 
            col < 0 || col >= image[0].length || 
            image[row][col] != originalColor) {
            return;
        }
        
        // 填充當前像素
        image[row][col] = newColor;
        
        // 遞迴填充四個方向的相鄰像素
        dfs(image, row - 1, col, originalColor, newColor); // 上
        dfs(image, row + 1, col, originalColor, newColor); // 下
        dfs(image, row, col - 1, originalColor, newColor); // 左
        dfs(image, row, col + 1, originalColor, newColor); // 右
    }
}
