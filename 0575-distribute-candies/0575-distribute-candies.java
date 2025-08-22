import java.util.*;

class Solution {
    public int distributeCandies(int[] candyType) {
        // Use a HashSet to count unique candy types
        Set<Integer> set = new HashSet<>();
        for (int candy : candyType) {
            set.add(candy);
        }
        
        // Max types you can eat = min(uniqueTypes, half of candies)
        return Math.min(set.size(), candyType.length / 2);
    }
}
