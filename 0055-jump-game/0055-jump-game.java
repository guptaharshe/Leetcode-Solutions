class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0; // furthest index we can reach
        
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false; // we can't even reach this index
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        
        return true;
    }
}
