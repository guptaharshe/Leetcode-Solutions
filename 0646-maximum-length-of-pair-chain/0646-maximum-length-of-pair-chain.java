class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);  // Sort by end time
        int currEnd = Integer.MIN_VALUE;
        int count = 0;

        for (int[] pair : pairs) {
            if (pair[0] > currEnd) {
                count++;
                currEnd = pair[1];
            }
        }

        return count;
        
    }
}