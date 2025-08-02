class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] score = new int[n + 1]; // people are 1-indexed

        for (int[] t : trust) {
            int a = t[0]; // person who trusts
            int b = t[1]; // person who is trusted
            score[a]--;   // a trusts someone → -1
            score[b]++;   // b is trusted → +1
        }

        for (int i = 1; i <= n; i++) {
            if (score[i] == n - 1) {
                return i; // found the judge
            }
        }

        return -1; // no judge found
    }
}
