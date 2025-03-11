package SlidingWindow;

public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int target, int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int minLength = Integer.MAX_VALUE;
		int currentSum = 0;
		int start = 0;
		
		// 使用滑動窗口
		for (int end = 0; end < nums.length; end++) {
			
			currentSum += nums[end];
			 // 當總和大於等於目標值時，嘗試縮小窗口
			while (currentSum >= target) {
				minLength = Math.min(minLength, end - start + 1);
				currentSum -= nums[start];
				start++;
			}
		}
		
		return minLength == Integer.MAX_VALUE ? 0:minLength;
	}
	
	 public static void main(String[] args) {
		 MinimumSizeSubarraySum solution = new MinimumSizeSubarraySum();
	        
	        // 測試案例
	        int[][] testArrays = {
	            {2, 3, 1, 2, 4, 3},      // target = 7
	            {1, 4, 4},               // target = 4
	            {1, 1, 1, 1, 1, 1, 1},   // target = 11
	            {1, 2, 3, 4, 5},         // target = 15
	            {1, 1, 1, 1},            // target = 4
	            {5},                     // target = 5
	            {2, 16, 14, 15},         // target = 20
	            {1, 2, 1, 3},            // target = 5
	            {14,1,1,1,1,1,1,1,1,1}   // target = 14
	        };
	        
	        int[] testTargets = {7, 4, 11, 15, 4, 5, 20, 5, 14};
	        
	        // 執行測試並輸出結果
	        for (int i = 0; i < testArrays.length; i++) {
	            System.out.printf("測試案例 %d:\n", i + 1);
	            
	            System.out.print("數組: [");
	            for (int j = 0; j < testArrays[i].length; j++) {
	                System.out.print(testArrays[i][j]);
	                if (j < testArrays[i].length - 1) {
	                    System.out.print(", ");
	                }
	            }
	            System.out.println("]");
	            
	            System.out.printf("目標值: %d\n", testTargets[i]);
	            
	            int result = solution.minSubArrayLen(testTargets[i], testArrays[i]);
	            System.out.printf("最小子陣列長度: %d\n", result);
	            
	            // 若找到結果，顯示一個符合條件的子陣列
	            if (result > 0) {
	                findAndPrintSubarray(testArrays[i], testTargets[i], result);
	            }
	            
	            System.out.println("--------------------");
	        }
	        
	        // 效能測試
	        System.out.println("效能測試:");
	        int[] largeArray = new int[100000];
	        int largeTarget = 1000000;
	        for (int i = 0; i < largeArray.length; i++) {
	            largeArray[i] = (int)(Math.random() * 100) + 1; // 1-100的隨機數
	        }
	        
	        long startTime = System.currentTimeMillis();
	        int largeResult = solution.minSubArrayLen(largeTarget, largeArray);
	        long endTime = System.currentTimeMillis();
	        
	        System.out.printf("陣列大小: %d\n", largeArray.length);
	        System.out.printf("目標值: %d\n", largeTarget);
	        System.out.printf("最小子陣列長度: %d\n", largeResult);
	        System.out.printf("執行時間: %d 毫秒\n", endTime - startTime);
	    }
	    
	    // 輔助方法：找出並印出符合條件的子陣列
	    private static void findAndPrintSubarray(int[] nums, int target, int length) {
	        for (int i = 0; i <= nums.length - length; i++) {
	            int sum = 0;
	            for (int j = 0; j < length; j++) {
	                sum += nums[i + j];
	            }
	            if (sum >= target) {
	                System.out.print("符合條件的子陣列: [");
	                for (int j = 0; j < length; j++) {
	                    System.out.print(nums[i + j]);
	                    if (j < length - 1) {
	                        System.out.print(", ");
	                    }
	                }
	                System.out.printf("], 和為: %d\n", sum);
	                break;
	            }
	        }
	    }
}
