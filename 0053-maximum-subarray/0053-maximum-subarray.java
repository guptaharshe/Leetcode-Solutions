class Solution {
    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);

    }

    private int helper(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = (left + right)/ 2;

        int leftmax = helper(nums, left, mid);
        int rightmax = helper(nums, mid + 1, right);
        int crossmax = maxcrossingsum(nums, left, mid, right);

        return Math.max(Math.max(leftmax, rightmax), crossmax);

    }

    private int maxcrossingsum(int[] nums, int left, int mid, int right) {
        int leftsum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftsum = Math.max(leftsum, sum);

        }
        int rightsum = Integer.MIN_VALUE;
        sum = 0;

        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightsum = Math.max(rightsum, sum);
        }
        return leftsum + rightsum;
    }
}