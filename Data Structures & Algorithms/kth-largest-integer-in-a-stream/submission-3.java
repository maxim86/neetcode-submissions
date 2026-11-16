class KthLargest {
    int k; 
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(Comparator.comparingInt(v -> v));

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num: nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if (minHeap.size() < k || val > minHeap.peek()) {
            minHeap.offer(val);
        }

        if (minHeap.size() > k) 
            minHeap.poll();

        return minHeap.peek();
    }
}
