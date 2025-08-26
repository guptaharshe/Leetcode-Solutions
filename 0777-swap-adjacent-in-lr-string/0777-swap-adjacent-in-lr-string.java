class Solution {
    public boolean canTransform(String start, String end) {
        // Remove X's and check if the sequence of L and R is the same
        if (!start.replace("X", "").equals(end.replace("X", ""))) {
            return false;
        }

        int n = start.length();
        int i = 0, j = 0;

        while (i < n && j < n) {
            // Skip X's
            while (i < n && start.charAt(i) == 'X') i++;
            while (j < n && end.charAt(j) == 'X') j++;

            if (i == n || j == n) break;

            char c = start.charAt(i);
            // Check L and R movement validity
            if (c == 'L' && i < j) return false; // L moved right
            if (c == 'R' && i > j) return false; // R moved left

            i++;
            j++;
        }
        return true;
    }
}
