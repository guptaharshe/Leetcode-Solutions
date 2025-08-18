class Solution {
    public int arrangeCoins(int n) {
        // formula derived from k(k+1)/2 <= n
        return (int)((Math.sqrt(1 + 8L * n) - 1) / 2);
    }
}
