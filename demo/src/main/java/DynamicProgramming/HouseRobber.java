package DynamicProgramming;

public class HouseRobber {
	
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

		// dp[i] 表示到第i個房屋為止能搶到的最大金額
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < nums.length; i++) {
			// 對於當前房屋，可以選擇搶或不搶
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}

		return dp[nums.length - 1];
	}
	
	public static void main(String[] args) {
        HouseRobber solution = new HouseRobber();
        
        // 測試案例1: [1,2,3,1]
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("案例1: [1,2,3,1]");
        System.out.println("結果: " + solution.rob(nums1));  // 預期輸出: 4
        System.out.println();
        
        // 測試案例2: [2,7,9,3,1]
        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println("案例2: [2,7,9,3,1]");
        System.out.println("結果: " + solution.rob(nums2));  // 預期輸出: 12
        System.out.println();
        
        // 測試案例3: [1,1]
        int[] nums3 = {1, 1};
        System.out.println("案例3: [1,1]");
        System.out.println("結果: " + solution.rob(nums3));  // 預期輸出: 1
        System.out.println();
        
        // 測試案例4: [1]
        int[] nums4 = {1};
        System.out.println("案例4: [1]");
        System.out.println("結果: " + solution.rob(nums4));  // 預期輸出: 1
        System.out.println();
        
        // 測試案例5: [4,1,2,7,5,3,1]
        int[] nums5 = {4, 1, 2, 7, 5, 3, 1};
        System.out.println("案例5: [4,1,2,7,5,3,1]");
        System.out.println("結果: " + solution.rob(nums5));  // 預期輸出: 14
    }
}
