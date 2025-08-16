import java.util.*;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1); // first element always 1

        for (int i = 1; i <= rowIndex; i++) {
            // Insert 0 at beginning to shift values
            row.add(0, 0);
            for (int j = 0; j < i; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
        }
        return row;
    }
}
