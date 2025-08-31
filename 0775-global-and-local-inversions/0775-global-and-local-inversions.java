class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // If any number is more than 1 index away from its sorted position
            if (Math.abs(nums[i] - i) > 1) {
                return false;
            }
        }
        return true;
    }
}
