class Solution {
    public int lastStoneWeight(int[] stones) {
        var maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (int stone: stones) {
            maxHeap.offer(stone);
        }

        //sim
        while (maxHeap.size() > 1) {
            int h1 = maxHeap.poll();
            int h2 = maxHeap.poll();

            if (h1 == h2) {
                continue;
            }
            if (h1 > h2) {
                maxHeap.offer(h1 - h2);
                continue;
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
