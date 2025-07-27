class TreeAncestor {
    private int[][] dp;
    private int maxLog;

    public TreeAncestor(int n, int[] parent) {
        maxLog = (int)(Math.log(n) / Math.log(2)) + 1;
        dp = new int[n][maxLog];
        // Initialize 2^0 (= parent) level
        for (int i = 0; i < n; i++) {
            dp[i][0] = parent[i];
        }
        // Build ancestors in powers of two
        for (int j = 1; j < maxLog; j++) {
            for (int i = 0; i < n; i++) {
                int mid = dp[i][j - 1];
                dp[i][j] = (mid == -1) ? -1 : dp[mid][j - 1];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int j = 0; j < maxLog && node != -1; j++) {
            if ((k & (1 << j)) != 0) {
                node = dp[node][j];
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */