public class MedianFinder {
    private PriorityQueue<Integer> maxHeap; 
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a); // Max heap (simulated by reversing the order)
        minHeap = new PriorityQueue<>(); // Min heap (default order is min)
    }
    
    public void addNum(int num) {
        // Add to max heap
        maxHeap.offer(num);
        
        // Move the largest element from max heap to min heap to balance
        minHeap.offer(maxHeap.poll());
        
        // Balance the heaps so that max heap has at most one more element than min heap
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */