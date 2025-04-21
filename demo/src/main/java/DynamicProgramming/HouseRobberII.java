package DynamicProgramming;

public class HouseRobberII {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}

		return Math.max(robRange(nums, 0, nums.length - 2), // 不包含最後一個房屋
				robRange(nums, 1, nums.length - 1) // 不包含第一個房屋
		);
	}

	private int robRange(int[] nums, int start, int end) {
		// 計算指定範圍的長度
		int length = end - start + 1;

		// 處理範圍內只有一個元素的情況
		if (length == 1) {
			return nums[start];
		}

		// dp數組長度應該是指定範圍的長度
		int[] dp = new int[length];
		// 初始化使用指定範圍的值
		dp[0] = nums[start];
		dp[1] = Math.max(nums[start], nums[start + 1]);

		// 迴圈應該在指定範圍內進行
		for (int i = 2; i < length; i++) {
			dp[i] = Math.max(dp[i - 2] + nums[start + i], dp[i - 1]);
		}

		// 返回指定範圍的最後一個元素
		return dp[length - 1];
	}

	public static void main(String[] args) {
		HouseRobberII solution = new HouseRobberII();

		// 測試案例1: [2,3,2]
		int[] nums1 = { 2, 3, 2 };
		System.out.println("案例1: [2,3,2]");
		System.out.println("結果: " + solution.rob(nums1)); // 預期輸出: 3
		System.out.println();

		// 測試案例2: [1,2,3,1]
		int[] nums2 = { 1, 2, 3, 1 };
		System.out.println("案例2: [1,2,3,1]");
		System.out.println("結果: " + solution.rob(nums2)); // 預期輸出: 4
		System.out.println();

		// 測試案例3: [1,2,3]
		int[] nums3 = { 1, 2, 3 };
		System.out.println("案例3: [1,2,3]");
		System.out.println("結果: " + solution.rob(nums3)); // 預期輸出: 3
	}
}
