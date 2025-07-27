class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];

        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> score[b] - score[a]);

        for (int i = 0; i < n; i++) {
            int idx = indices[i];
            if (i == 0) {
                result[idx] = "Gold Medal";
            } else if (i == 1) {
                result[idx] = "Silver Medal";
            } else if (i == 2) {
                result[idx] = "Bronze Medal";
            } else {
                result[idx] = String.valueOf(i + 1);
            }
        }
        return result;

    }
}