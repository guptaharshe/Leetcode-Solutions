class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        
        do {
            slow = squareSum(slow);              // move 1 step
            fast = squareSum(squareSum(fast));   // move 2 steps
        } while (slow != fast);
        
        return slow == 1;
    }
    
    private int squareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }
        return sum;
    }
}
