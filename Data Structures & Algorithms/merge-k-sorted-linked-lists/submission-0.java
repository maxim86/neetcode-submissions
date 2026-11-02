/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> comp = Comparator.comparingInt(n -> n.val);
        //min heap of ll 
        var minHeap = new PriorityQueue<ListNode>(comp);

        for(var node: lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        var dummy = new ListNode();
        var curr = dummy;

        while (!minHeap.isEmpty()) {
            var node = minHeap.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

        return dummy.next;
    }
}
