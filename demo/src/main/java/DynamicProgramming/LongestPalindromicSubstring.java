package DynamicProgramming;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        
        if (s == null || s.length() < 1) return "";

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLength = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > maxLength) {
                        start = i;
                        maxLength = j - i + 1;
                    }
                }
            }
        }


        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();

        // Test cases for Longest Palindromic Substring
        String[] testCases = {
            "babad",    // Expected: "bab" or "aba"
            "cbbd",     // Expected: "bb"
            "a",        // Expected: "a"
            "ac",       // Expected: "a" or "c"
            "",         // Expected: ""
            "racecar",  // Expected: "racecar"
            "forgeeksskeegfor" // Expected: "geeksskeeg"
        };  

        String[] expectedResults = {
            "bab", "bb", "a", "a", "", "racecar", "geeksskeeg"
        };
        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1) + ":");
            System.out.println("Input: \"" + testCases[i] + "\"");
            String result = solution.longestPalindrome(testCases[i]);
            System.out.println("Expected: \"" + expectedResults[i] + "\", Actual: \"" + result + "\"");
            boolean pass = result.equals(expectedResults[i]) || 
                           (expectedResults[i].length() == result.length() && 
                            expectedResults[i].chars().distinct().count() == result.chars().distinct().count());
            System.out.println("Status: " + (pass ? "PASS" : "FAIL"));
            System.out.println("------------------------");
        }
    }
}
