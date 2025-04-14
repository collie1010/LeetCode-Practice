package GreedyAlgorithm;

public class JumpGame {

	public boolean canJumpGreedy(int[] nums) {
		int maxReach = 0; // 能到達的最遠距離

		for (int i = 0; i <= maxReach; i++) {
			// 如果已經可以到達最後一個位置，返回true
			if (maxReach >= nums.length - 1) {
				return true;
			}

			// 更新能到達的最遠距離
			maxReach = Math.max(maxReach, i + nums[i]);

			// 如果當前位置已經是能到達的最遠距離，且還沒到終點，表示無法繼續前進
			if (i == maxReach && i < nums.length - 1) {
				return false;
			}
		}

		return true;
	}

	public boolean canJumpDP(int[] nums) {
		boolean[] dp = new boolean[nums.length];
		dp[0] = true; // 初始位置可達

		for (int i = 0; i < nums.length; i++) {
			if (!dp[i])
				continue; // 如果當前位置不可達，跳過

			// 從當前位置可以跳躍到的所有位置
			for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
				dp[i + j] = true;
			}

			// 如果已經可以到達最後位置，提前返回
			if (dp[nums.length - 1]) {
				return true;
			}
		}

		return dp[nums.length - 1];
	}
	
	public static void main(String[] args) {
        JumpGame solution = new JumpGame();
        
        // 測試用例1
        int[] nums1 = {2,3,1,1,4};
        System.out.println("Test case 1: " + solution.canJumpGreedy(nums1));  // 應該輸出 true
        
        // 測試用例2
        int[] nums2 = {3,2,1,0,4};
        System.out.println("Test case 2: " + solution.canJumpGreedy(nums2));  // 應該輸出 false
        
        // 額外測試用例
        int[] nums3 = {0};
        System.out.println("Test case 3: " + solution.canJumpDP(nums3));  // 應該輸出 true
        
        int[] nums4 = {2,0};
        System.out.println("Test case 4: " + solution.canJumpDP(nums4));  // 應該輸出 true
    }
}
