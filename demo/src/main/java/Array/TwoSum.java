package Array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        // 使用 HashMap 儲存數字和索引
        Map<Integer, Integer> numMap = new HashMap<>();
        
        // 遍歷數組
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // 檢查是否存在互補的數字
            if (numMap.containsKey(complement)) {
                return new int[] {numMap.get(complement), i};
            }
            
            // 將當前數字和索引加入 Map
            numMap.put(nums[i], i);
        }
        
        // 依題目說明，一定會有解，所以不會執行到這裡
        return new int[]{};
    }
	
	public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        
        // 測試案例
        int[][] testNums = {
            {2, 7, 11, 15},  // target = 9
            {3, 2, 4},       // target = 6
            {3, 3},          // target = 6
            {1, 2, 3, 4, 5}, // target = 7
            {-1, -2, -3, -4},// target = -7
            {0, 4, 3, 0},    // target = 0
            {1, 5, 8, 10}    // target = 13
        };
        
        int[] testTargets = {9, 6, 6, 7, -7, 0, 13};
        
        // 執行測試並輸出結果
        for (int i = 0; i < testNums.length; i++) {
            System.out.printf("測試案例 %d:\n", i + 1);
            System.out.print("數組: [");
            for (int j = 0; j < testNums[i].length; j++) {
                System.out.print(testNums[i][j]);
                if (j < testNums[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            System.out.printf("目標值: %d\n", testTargets[i]);
            
            int[] result = solution.twoSum(testNums[i], testTargets[i]);
            
            System.out.print("結果: [");
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[j]);
                if (j < result.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            
            // 驗證結果
            if (result.length == 2) {
                int sum = testNums[i][result[0]] + testNums[i][result[1]];
                System.out.printf("驗證: %d + %d = %d\n",
                    testNums[i][result[0]],
                    testNums[i][result[1]],
                    sum);
            }
            System.out.println("--------------------");
        }
        
        // 效能測試
        System.out.println("效能測試:");
        int[] largeArray = new int[100000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = i;
        }
        int largeTarget = 199990; // 尋找陣列中後段的兩個數字
        
        long startTime = System.currentTimeMillis();
        int[] largeResult = solution.twoSum(largeArray, largeTarget);
        long endTime = System.currentTimeMillis();
        
        System.out.printf("陣列大小: %d\n", largeArray.length);
        System.out.printf("目標值: %d\n", largeTarget);
        System.out.printf("執行時間: %d 毫秒\n", endTime - startTime);
        if (largeResult.length == 2) {
            System.out.printf("找到的索引: [%d, %d]\n", largeResult[0], largeResult[1]);
            System.out.printf("對應的數字: %d + %d = %d\n",
                largeArray[largeResult[0]],
                largeArray[largeResult[1]],
                largeTarget);
        }
    }
}
