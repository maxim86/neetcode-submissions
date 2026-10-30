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
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        var minHeap = new PriorityQueue<ListNode>(Comparator.comparingInt((ListNode n) -> n.val));
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        if (list1 != null) minHeap.add(list1);
        if (list2 != null) minHeap.add(list2);

        while(!minHeap.isEmpty()) {
            var node = minHeap.poll();
           
            var next = node.next;

            node.next = null;
            tail.next = node;
            tail = node;

            if (next != null) {
                minHeap.add(next);
            }
        }


        return dummy.next;
    }


}