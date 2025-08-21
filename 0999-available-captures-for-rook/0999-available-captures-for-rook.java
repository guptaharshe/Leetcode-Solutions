class Solution {
    public int numRookCaptures(char[][] board) {
        int rookRow = -1, rookCol = -1;

        // Find the rook
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    rookRow = i;
                    rookCol = j;
                    break;
                }
            }
        }

        int captures = 0;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}}; // down, up, right, left

        for (int[] dir : directions) {
            int r = rookRow, c = rookCol;
            while (r >= 0 && r < 8 && c >= 0 && c < 8) {
                r += dir[0];
                c += dir[1];
                if (r < 0 || r >= 8 || c < 0 || c >= 8) break;
                if (board[r][c] == 'B') break;        // blocked by bishop
                if (board[r][c] == 'p') { captures++; break; } // captured pawn
            }
        }
        return captures;
    }
}
