package TwoPointer;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		
		int maxArea = 0;
		int left = 0;
		int right = height.length - 1;
		
		while (left < right) {
			
			// 計算當前容器的面積
            // 面積 = 寬度 * 高度（取兩邊較矮的高度）
			int width = right - left;
			int currentHeight = Math.min(height[left], height[right]);
			int currentArea = width * currentHeight;
			
			// 更新最大面積
			maxArea = Math.max(maxArea, currentArea);
			
			// 移動較矮的那一邊
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		
		return maxArea;
		
	}
	
	public static void main(String[] args) {
		ContainerWithMostWater solution = new ContainerWithMostWater();
        
        // 測試案例
        int[][] testCases = {
            {1, 8, 6, 2, 5, 4, 8, 3, 7},  // 預期結果：49
            {1, 1},                        // 預期結果：1
            {4, 3, 2, 1, 4},              // 預期結果：16
            {1, 2, 1},                    // 預期結果：2
            {1, 8, 100, 2, 100, 4, 8, 3, 7}, // 預期結果：200
            {1},                          // 預期結果：0
            {0, 0},                       // 預期結果：0
            {1, 2, 3, 4, 5, 6, 7, 8, 9}   // 預期結果：20
        };
        
        // 執行測試並輸出結果
        for (int i = 0; i < testCases.length; i++) {
            System.out.printf("測試案例 %d:\n", i + 1);
            System.out.print("高度陣列: [");
            for (int j = 0; j < testCases[i].length; j++) {
                System.out.print(testCases[i][j]);
                if (j < testCases[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            
            int result = solution.maxArea(testCases[i]);
            System.out.printf("最大盛水量: %d\n", result);
            
            // 如果是第一個測試案例，顯示詳細說明
            if (i == 0) {
                System.out.println("說明: 選擇第2個和最後一個高度 (8和7)");
                System.out.println("寬度 = 7 (索引8-1)");
                System.out.println("高度 = 7 (兩端最小值)");
                System.out.println("面積 = 7 * 7 = 49");
            }
            System.out.println("--------------------");
        }
        
        // 效能測試
        System.out.println("效能測試:");
        int[] largeArray = new int[100000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = (int)(Math.random() * 10000); // 隨機高度
        }
        
        long startTime = System.currentTimeMillis();
        int largeResult = solution.maxArea(largeArray);
        long endTime = System.currentTimeMillis();
        
        System.out.printf("陣列大小: %d\n", largeArray.length);
        System.out.printf("最大盛水量: %d\n", largeResult);
        System.out.printf("執行時間: %d 毫秒\n", endTime - startTime);
    }
}
