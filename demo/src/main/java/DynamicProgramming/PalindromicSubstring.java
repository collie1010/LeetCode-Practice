package DynamicProgramming;

public class PalindromicSubstring {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        PalindromicSubstring solution = new PalindromicSubstring();

        // Test cases for Counting Palindromic Substrings
        String[] testCases = {
            "abc",          // Expected: 3 ("a", "b", "c")
            "aaa",          // Expected: 6 ("a", "a", "a", "aa", "aa", "aaa")
            "aba",          // Expected: 4 ("a", "b", "a", "aba")
            "",             // Expected: 0 (empty string)
            "a",            // Expected: 1 ("a")
            "abccba"       // Expected: 9 ("a", "b", "c", "c", "b", "a", "cc", "bccb", "abccba")
        };

        int[] expectedResults = {3, 6, 4, 0, 1, 9};

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1) + ":");
            System.out.println("Input: \"" + testCases[i] + "\"");
            int result = solution.countSubstrings(testCases[i]);
            System.out.println("Expected: " + expectedResults[i] + ", Actual: " + result);
            System.out.println("Status: " + (result == expectedResults[i] ? "PASS" : "FAIL"));
            System.out.println("------------------------");
        }
    }
}
