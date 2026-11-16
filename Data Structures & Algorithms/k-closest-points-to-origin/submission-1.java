class Solution {
    public int[][] kClosest(int[][] points, int k) {
        var maxHeap = new PriorityQueue<int[]>((a, b) -> Integer.compare(dist(b), dist(a)));

        for(int[] point: points) {
            maxHeap.offer(point);
            
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return maxHeap.toArray(new int[k][]);
    }

    public int dist(int[] point) {
        return point[0]*point[0] + point[1]*point[1];
    }
}
