class Solution {
    public boolean validUtf8(int[] data) {
        int count = 0; // number of continuation bytes expected

        for (int num : data) {
            if (count == 0) {
                if ((num >> 5) == 0b110) count = 1;       // 2-byte character
                else if ((num >> 4) == 0b1110) count = 2; // 3-byte character
                else if ((num >> 3) == 0b11110) count = 3;// 4-byte character
                else if ((num >> 7) != 0) return false;   // invalid 1-byte char
            } else {
                // Must be a continuation byte (10xxxxxx)
                if ((num >> 6) != 0b10) return false;
                count--;
            }
        }
        return count == 0; // all continuation bytes matched
    }
}
