import java.util.*;

public class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int num : nums) {
            int count = freq.getOrDefault(num, 0);
            if (count == result.size()) {
                result.add(new ArrayList<>());
            }
            result.get(count).add(num);
            freq.put(num, count + 1);
        }

        return result;
    }
}
