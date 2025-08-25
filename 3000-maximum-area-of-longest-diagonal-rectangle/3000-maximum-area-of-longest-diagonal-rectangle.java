class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int ans = 0;
        int maxDiag = 0;

        for (int[] rect : dimensions) {
            int l = rect[0], w = rect[1];
            int diagSq = l * l + w * w;
            int area = l * w;

            if (diagSq > maxDiag) {
                maxDiag = diagSq;
                ans = area;
            } else if (diagSq == maxDiag) {
                ans = Math.max(ans, area);
            }
        }

        return ans;
    }
}
