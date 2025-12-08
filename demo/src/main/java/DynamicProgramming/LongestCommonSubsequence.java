package DynamicProgramming;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence solution = new LongestCommonSubsequence();

        // Test cases for Longest Common Subsequence
        String[][] testCases = {
            {"abcde", "ace"},          // Expected: 3 ("ace")
            {"abc", "abc"},            // Expected: 3 ("abc")
            {"abc", "def"},            // Expected: 0 (no common subsequence)
            {"", ""},                  // Expected: 0 (both empty)
            {"a", "a"},                // Expected: 1 ("a")
            {"abcdxyz", "xyzabcd"}     // Expected: 4 ("abcd" or "xyz")
        };

        int[] expectedResults = {3, 3, 0, 0, 1, 4};

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1) + ":");
            System.out.println("Text1: \"" + testCases[i][0] + "\", Text2: \"" + testCases[i][1] + "\"");
            int result = solution.longestCommonSubsequence(testCases[i][0], testCases[i][1]);
            System.out.println("Expected: " + expectedResults[i] + ", Actual: " + result);
            System.out.println("Status: " + (result == expectedResults[i] ? "PASS" : "FAIL"));
            System.out.println("------------------------");
        }
    }
}
