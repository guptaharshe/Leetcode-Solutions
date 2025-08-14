class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // dp[i][j] = true if s[0..i-1] matches p[0..j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true; // empty string matches empty pattern
        
        // Fill for patterns like a*, a*b*, a*b*c*
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        // DP computation
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                
                if (pc == '.' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1];
                } 
                else if (pc == '*') {
                    // Zero occurrence of previous char
                    dp[i][j] = dp[i][j - 2];
                    
                    // One or more occurrences
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == sc) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        
        return dp[m][n];
    }
}
