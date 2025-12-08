package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums)  {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int result = 0;
        for (int num : dp) result = Math.max(result, num);

        return result;
    }


    public static void main(String[] args) {
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();

        // Test cases for Longest Increasing Subsequence
        int[][] testCases = {
            {10,9,2,5,3,7,101,18},  // Expected: 4 (2,3,7,101)
            {0,1,0,3,2,3},          // Expected: 4 (0,1,2,3 or 0,1,3)
            {7,7,7,7,7,7,7},        // Expected: 1 (all same)
            {},                      // Expected: 0 (empty array)
            {1},                     // Expected: 1 (single element)
            {5,4,3,2,1}             // Expected: 1 (decreasing)
        };

        int[] expectedResults = {4, 4, 1, 0, 1, 1};

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1) + ":");
            System.out.println("Array: " + Arrays.toString(testCases[i]));
            int result = solution.lengthOfLIS(testCases[i]);
            System.out.println("Expected: " + expectedResults[i] + ", Actual: " + result);
            System.out.println("Status: " + (result == expectedResults[i] ? "PASS" : "FAIL"));
            System.out.println("------------------------");
        }
    }
}
