class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Remove elements out of current window
            if (!dq.isEmpty() && dq.peek() <= i - k) {
                dq.poll();
            }

            // Remove all elements smaller than the current one
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offer(i); // add current index

            // Start adding to result from index k-1
            if (i >= k - 1) {
                result[i - k + 1] = nums[dq.peek()];
            }
        }

        return result;
        
    }
}