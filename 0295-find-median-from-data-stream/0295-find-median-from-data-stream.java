import java.util.*;

class MedianFinder {
    private PriorityQueue<Integer> left;  // max heap
    private PriorityQueue<Integer> right; // min heap

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // Step 1: always add to max heap first
        left.offer(num);
        
        // Step 2: balance heaps (move largest of left to right)
        right.offer(left.poll());
        
        // Step 3: maintain size property (left can have one extra)
        if (left.size() < right.size()) {
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }
}
