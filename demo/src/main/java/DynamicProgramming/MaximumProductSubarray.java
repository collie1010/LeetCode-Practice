package DynamicProgramming;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp_max = new int[n];
        int[] dp_min = new int[n];

        
        dp_max[0] = nums[0];
        dp_min[0] = nums[0];
        
        int result = nums[0];

        for (int i = 1; i < n; i++) {
            int curr = nums[i];

            dp_max[i] = Math.max(curr, Math.max(dp_max[i - 1] * curr, dp_min[i - 1] * curr));
            dp_min[i] = Math.min(curr, Math.min(dp_max[i - 1] * curr, dp_min[i - 1] * curr));

            if (dp_max[i] > result) result = dp_max[i];
        }

        return result;
    }
}
